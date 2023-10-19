package helpers;

import driver.DriverSingleton;
import jdk.jfr.Description;
import objects.ComputeEngineBO;
import objects.PricingCalculatorPageConfiguration;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.Utility;

abstract public class CommonConditions {

    protected WebDriver driver;
    protected SoftAssertions softly = new SoftAssertions();
    protected Utility utility=new Utility(driver);

    PricingCalculatorPageConfiguration pageConfiguration;
    @BeforeClass()
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @BeforeMethod
    public void configureModel(){
        pageConfiguration = GoogleCloudPricingCalculatorConfigurationCreator.createWithProperty();
    }

    @AfterClass()
    public void tearDown() {
        DriverSingleton.closeDriver();
    }

}
