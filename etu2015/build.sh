javac -d . *java 
jar -cf testFramework/WEB-INF/lib/wf.jar framework/.
cd testFramework
jar -cf testFramework.war *
cp "testFramework.war" "/var/lib/tomcat9/webapps/"
cd ../