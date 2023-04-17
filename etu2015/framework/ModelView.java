package etu2015.framework;

import java.util.HashMap;

public class ModelView {
    String view;
    HashMap<String,Object> data = new HashMap<>();
    
    public ModelView(String view) {
        this.view = view;
    }

    public ModelView() {
    }

    public void addItem(String key,Object value){
        this.getData().put(key, value);
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }
}
