package etu2015.framework.servlet;

import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import etu2015.framework.annotation.url;
import etu2015.framework.Mapping;

import jakarta.servlet.*;
import jakarta.servlet.http.*;


public class FrontServlet extends HttpServlet {

    Map<String, Mapping> mappingUrls;

    public void init() throws ServletException {
        try {
            mappingUrls = new HashMap<String, Mapping>();
            String packageName = "etu2015.model";
            URL root = Thread.currentThread().getContextClassLoader().getResource(packageName.replace(".", "/"));
            for (File file : new File(root.getFile()).listFiles()) {
                if (file.getName().contains(".class")) {
                    String className = file.getName().replaceAll(".class$", "");
                    Class<?> cls = Class.forName(packageName + "." + className);
                    for (Method method : cls.getDeclaredMethods()) {
                        if (method.isAnnotationPresent(url.class)) {
                            mappingUrls.put(method.getAnnotation(url.class).value(), new Mapping(cls.getName(), method.getName()));
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.println(request.getHttpServletMapping().getMatchValue());
        for (Map.Entry<String, Mapping> entry : mappingUrls.entrySet()) {
            out.println(entry.getKey() + " " + entry.getValue().getClassName() + " " + entry.getValue().getMethod());
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        processRequest(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        processRequest(request, response);
    }

}