package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
    static WebDriver driver;
    public Utility(WebDriver driver){
        Utility.driver = driver;
    }
    public static void iFrameXpath(WebDriver driver, String xpath){
        driver.switchTo().frame(driver.findElement(By.xpath(xpath)));
    }

    public static void iFrameId(WebDriver driver, String id){
        driver.switchTo().frame(driver.findElement(By.id(id)));
    }

    public void takeScreenShot(WebDriver driver) throws IOException {
        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String time = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-aa").format(new Date());
        String fileWithPath = "./screenshots/" + time + ".png";
        FileUtils.copyFile(screenshotFile, new File(fileWithPath));
    }
}
