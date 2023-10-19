package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class Utility {
//    static WebDriver driver;
//    public Utility(WebDriver driver){
//        Utility.driver = driver;
//    }
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

    public void createNewTab(WebDriver driver){
        driver.switchTo().newWindow(WindowType.TAB);
    }

    public String switchToMainTab(WebDriver driver){
        Set<String> windowHandles = driver.getWindowHandles();
        String tab1Handle = windowHandles.iterator().next();
        String tab2Handle = windowHandles.stream().filter(handle -> !handle.equals(tab1Handle)).findFirst().get();
        driver.switchTo().window(tab1Handle);
        return tab2Handle;
    }

    public void switchToSecondTab(WebDriver driver){
        driver.switchTo().window(switchToMainTab(driver));
    }
}
