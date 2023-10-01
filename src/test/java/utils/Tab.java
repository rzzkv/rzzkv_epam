package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import java.util.Set;

public class Tab {

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
