package config;

import tests.helpers.CommonConditions;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {

    public static Properties properties = new Properties();
    public static final String PATH_TO_PROPERTIES = "src/test/resources/properties/config.properties";

    public static void getProperties() {
        try {
            InputStream input = new FileInputStream(PATH_TO_PROPERTIES);
            properties.load(input);
            CommonConditions.browserName = properties.getProperty("browser");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }

    public static void setProperties() {
        try {
            OutputStream output = new FileOutputStream(PATH_TO_PROPERTIES);
            properties.setProperty("browser", "chrome");
            properties.store(output, null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }
}
