package config;

import tests.helpers.CommonConditions;
import java.io.*;
import java.util.Properties;

public class PropertiesFile {

    static Properties properties = new Properties();
    public static void main(String[] args) {
        setProperties();
    }

    public static void getProperties(){
        try {
            InputStream input = new FileInputStream("src/test/resources/config.properties");
            properties.load(input);
            CommonConditions.browserName = properties.getProperty("browser");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }

    public static void setProperties(){
        try {
            OutputStream output = new FileOutputStream("src/test/resources/config.properties");
            properties.setProperty("browser","chrome");
            properties.store(output, null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }

}
