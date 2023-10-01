package Utils;

import org.openqa.selenium.WindowType;
import tests.CommonConditions;

import java.util.Set;

public class Tab extends CommonConditions {

    public void createNewTab(){
        driver.switchTo().newWindow(WindowType.TAB);
    }

    public String switchToFirstTab(){
        Set<String> windowHandles = driver.getWindowHandles();
        String tab1Handle = windowHandles.iterator().next();
        String tab2Handle = windowHandles.stream().filter(handle -> !handle.equals(tab1Handle)).findFirst().get();
        driver.switchTo().window(tab1Handle);
        return tab2Handle;
    }

    public void switchToSecondTab(){
        driver.switchTo().window(switchToFirstTab());
    }
}
