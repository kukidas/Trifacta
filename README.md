# Trifacta

About the codebase:
---------------------------------
*This is a simple test project for testing a login flow in Trifacta Homepage
**Tech Stack:** *Java*  *Selenium* *TestNG*  *Maven*

Steps to Run
----------------------------------
1. Download the code
2. modify /src/main/resources/test.properties for valid email and password.
3. ```cd trifacta```
3. ```mvn test```

Note: If you get driver not executable error please check the permission of the driver files.
Driver files are in the main directory named as chromerdriver_<os>. 
you may need to run below equivalent to make it executable.
```$xslt
chmod 777 chromedriver_mac
``` 


