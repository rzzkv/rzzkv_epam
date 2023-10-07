package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utility;

public class CloudGoogleCalculatorPage extends BasePage {

    public static final String iFrameXpath = "//iframe[contains(@src,'frame/products/calculator/index')]";
    public static final String iFrameId = "myFrame";
    private final static String BY_VALUE = "//md-option[@value='%s']";

    @FindBy(id = "input_98")
    private WebElement numberOfInstances;
    @FindBy(id = "select_123")
    private WebElement series;
    @FindBy(id = "select_125")
    private WebElement machineType;
    @FindBy(xpath = "//div[@class='md-label'][contains(text(), 'Add GPUs.')]")
    private WebElement gpu;
    @FindBy(id = "select_505")
    private WebElement gpuType;
    @FindBy(id = "select_507")
    private WebElement gpuNumber;
    private final static String GPU_NUMBER_SET = "//md-option[.//div[normalize-space(text())='%s']]";
    @FindBy(id = "select_464")
    private WebElement ssd;
    private final static String SSD_VALUE_SET = "//md-option[@ng-repeat=\"item in listingCtrl.dynamicSsd.computeServer\" and @value=\"%s\"]";
    @FindBy(id = "select_131")
    private WebElement location;
    private final static String LOCATION_VALUE_SET = "//md-option[@value='%s']";
    @FindBy(id = "select_138")
    private WebElement usage;
    private final static String USAGE_VALUE_SET = "//md-option[@id='%s']";
    @FindBy(xpath = "//md-card-content[@id='resultBlock']")
    private WebElement checkEstimateExist;
    @FindBy(xpath = "//div[contains(@class, 'layout-align-end-start')]/button[contains(@class, 'cpc-button')]")
    private WebElement addToEstimate;
    @FindBy(xpath = "//div[@class='cpc-cart-total']")
    private WebElement cartTotal;
    @FindBy(xpath = "//button[.//span[text()='email']]")
    private WebElement emailEstimate;
    @FindBy(xpath = "//input[@type='email']")
    private WebElement setEmailAddress;
    @FindBy(xpath = "//button[contains(text(), 'Send Email')]")
    private WebElement sendEmail;

    public CloudGoogleCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CloudGoogleCalculatorPage calculatorPageFrame(WebDriver driver){
        Utility.iFrameXpath(driver, iFrameXpath);
        Utility.iFrameId(driver, iFrameId);
        return this;
    }

    public CloudGoogleCalculatorPage setNumberOfInstances(String instanceValue){
        numberOfInstances.sendKeys(instanceValue);
        return this;
    }

    public CloudGoogleCalculatorPage setSeries(String value){
        series.click();
        driver.findElement(
                By.xpath(String.format(BY_VALUE, value))).click();
        return this;
    }

    public CloudGoogleCalculatorPage setMachineType(String value){
        machineType.click();
        driver.findElement(
                By.xpath(String.format(BY_VALUE, value))).click();
        return this;
    }

    public CloudGoogleCalculatorPage addGPU(){
        gpu.click();
        return new CloudGoogleCalculatorPage(driver);
    }

    public CloudGoogleCalculatorPage selectGPUType(String value){
        gpuType.click();
        driver.findElement(
                By.xpath(String.format(BY_VALUE, value))).click();
        return this;
    }

    public CloudGoogleCalculatorPage selectGPUNumber(String value){
        gpuNumber.click();
        driver.findElement(
                By.xpath(String.format(GPU_NUMBER_SET, value))).click();
        return this;
    }

    public CloudGoogleCalculatorPage setSSDValue(String value){
        ssd.click();
        driver.findElement(
                By.xpath(String.format(SSD_VALUE_SET, value))).click();
        return this;
    }

    public CloudGoogleCalculatorPage setLocation(String value){
        location.click();
        driver.findElement(
                By.xpath(String.format(BY_VALUE, value))).click();
        return this;
    }

    public CloudGoogleCalculatorPage setUsageValue(String value){
        usage.click();
        driver.findElement(
                By.xpath(String.format(USAGE_VALUE_SET, value))).click();
        return this;
    }

    public void addToEstimateBtn(){
        addToEstimate.click();
    }

    public String getEstimateTitle(){
        return checkEstimateExist.getText();
    }

    public String getTotalCost() {
        return cartTotal.getText()
                .replace("Total Estimated Cost: ", "")
                .replace(" per 1 month", "");
    }

    public CloudGoogleCalculatorPage emailEstimateBtn(){
        emailEstimate.click();
       return this;
    }

    public CloudGoogleCalculatorPage setEmailAddress(String emailAddress){
        setEmailAddress.sendKeys(emailAddress);
        return this;
    }

    public void sendEmailBtn(){
        sendEmail.click();
    }
}

