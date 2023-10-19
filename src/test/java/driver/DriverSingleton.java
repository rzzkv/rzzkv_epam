package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
    private static WebDriver driver;

    private DriverSingleton(){}

    public static WebDriver getDriver(){
        if (driver == null){
            if ("firefox".equals(System.getProperty("browser"))) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if ("chrome".equals(System.getProperty("browser"))) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
