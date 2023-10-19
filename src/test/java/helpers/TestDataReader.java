package helpers;

import java.util.ResourceBundle;

public class TestDataReader {
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("environment/" + System.getProperty("environment"));

    public static String getTestData(String key) {
        return RESOURCE_BUNDLE.getString(key);
    }
}
