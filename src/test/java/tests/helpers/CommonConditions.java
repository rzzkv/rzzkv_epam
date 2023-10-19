package tests.helpers;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Utility;

import java.io.IOException;
import java.time.Duration;

abstract public class CommonConditions {

    protected SoftAssertions softly = new SoftAssertions();
    protected Utility utility=new Utility(driver);

    //protected static WebDriver driver = null; //было бы логично сделать
    protected static WebDriver driver = new ChromeDriver();
    //проблема с этой строкой, без нее не работают тест сюиты, но с ней открывается два браузера

    //chose browser
    public static String browserName = "firefox";

    @BeforeMethod
    public void setUp() {
//        PropertiesFile.getProperties();
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver","/usr/local/bin/geckodriver");
            driver = new FirefoxDriver();
        }else { // default browser
            System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
        }
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
