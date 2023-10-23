package helpers;

import driver.DriverSingleton;
import objects.PricingCalculatorPageConfiguration;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.Utility;

import java.io.IOException;

abstract public class CommonConditions {

    protected WebDriver driver;
    protected SoftAssertions softly = new SoftAssertions();
    protected Utility utility = new Utility();
    PricingCalculatorPageConfiguration pageConfiguration;

    @BeforeClass()
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @BeforeMethod
    public void configureModel() {
        pageConfiguration = GoogleCloudPricingCalculatorConfigurationCreator.createWithProperty();
    }

    @AfterMethod()
    public void takeScreenShotIfTestFails(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            utility.takeScreenShot(driver);
        }
    }

    @AfterClass()
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}
