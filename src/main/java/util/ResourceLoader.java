package util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourceLoader {
    private static ResourceBundle rb= ResourceBundle.getBundle("test");
    public static String getValue(String key){
        String value="";
        try{
            value=rb.getString(key);
        }catch (MissingResourceException e){
            System.out.println("Value not found in properties file");
        }
        return value;
    }
}
