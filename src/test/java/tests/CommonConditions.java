package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.Tab;
import utils.Utility;

import java.io.IOException;
import java.time.Duration;

abstract public class CommonConditions{
    protected static WebDriver driver = new ChromeDriver();
    TestData data = new TestData();
    Tab tab = new Tab();
    Utility utility=new Utility(driver);

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterMethod
    public void screenShot(ITestResult result) throws IOException {
        if(ITestResult.FAILURE==result.getStatus()){
            try{
                utility.takeScreenShot(driver);
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
        driver.close();
        driver.quit();
    }
}
