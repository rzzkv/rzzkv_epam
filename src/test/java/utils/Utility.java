package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.CloudGoogleCalculatorPage;

public class Utility {
    static WebDriver driver;
    public Utility(WebDriver driver){
        this.driver = driver;
    }
    public static void iFrameXpath(WebDriver driver, String xpath){
        driver.switchTo().frame(driver.findElement(By.xpath(xpath)));
    }

    public static void iFrameId(WebDriver driver, String id){
        driver.switchTo().frame(driver.findElement(By.id(id)));
    }
}
