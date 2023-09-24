package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class MainPage extends BasePage {

    private static final String URL = "https://cloud.google.com/";
    @FindBy(xpath = "//input[@class='mb2a7b']")
    private WebElement searchIcon;
    @FindBy(xpath = "//a[@class='gs-title']")
    private WebElement calculatorLink;
    @FindBy(xpath = "//input[@id='input_98']")
    private WebElement numberOfInstances;
    @FindBy(xpath = "//*[@id='select_value_label_93']")
    private WebElement series;
    @FindBy(xpath = "//*[@id='select_option_220']")
    private WebElement seriesValue;
    @FindBy(xpath = "//*[@id='select_value_label_94']")
    private WebElement machineType;
    @FindBy(xpath = "//*[@id='select_option_469']")
    private WebElement machineTypeValue;
    @FindBy(xpath = "//div[@class='md-label'][contains(text(), 'Add GPUs.')]")
    private WebElement gpu;
    @FindBy(xpath = "//md-select[.//span[text()='GPU type']]")
//    @FindBy(xpath = "//span[text()='GPU type']")
//    @FindBy(xpath = "//md-select-value[@class='md-select-value md-select-placeholder'][contains(text(), 'GPU type')]")
//    @FindBy(xpath = "//*[@id='select_value_label_499']")
//    @FindBy(xpath = "//*[@id='select_value_label_503']/*[@class='md-select-icon']")
//    @FindBy(xpath = "//*[@id='select_value_label_503']/*[@class='md-select-icon']")
//    @FindBy(xpath = "//*[@id='select_value_label_503'][contains(text(), 'GPU type')]")
//    @FindBy(xpath = "//*[@id='select_505'")
    private WebElement gpuType;
    @FindBy(xpath = "//md-option[.//div[normalize-space(text())='NVIDIA Tesla V100']]")
//    @FindBy(xpath = "//md-option[.//div[text()='NVIDIA Tesla V100']]")
//    @FindBy(xpath = "//*[@id='select_option_548']")
    private WebElement gpuTypeSelect;
    @FindBy(xpath = "//md-select-value[.//div[normalize-space(text())='0']]")
//    @FindBy(xpath = "//md-select[.//span[text()='Number of GPUs']]")
    private WebElement gpuNumber;
    @FindBy(xpath = "//md-option[.//div[normalize-space(text())='1']]")
    private WebElement gpuNumberSelect;
    @FindBy(xpath = "//*[@id='select_value_label_463']")
    private WebElement ssd;
    @FindBy(xpath = "//*[@id='select_option_490']")
    private WebElement ssdValue;
    @FindBy(xpath = "//*[@id='select_value_label_96']")
    private WebElement location;
    @FindBy(xpath = "//md-option[.//div[normalize-space(text())='Frankfurt (europe-west3)']][3]")
//    @FindBy(xpath = "//md-option[.//div[normalize-space(text())='Frankfurt (europe-west3)']]")
    private WebElement locationValue;
    @FindBy(xpath = "//*[@id='select_value_label_97']")
    private WebElement usage;
    @FindBy(xpath = "//*[@id='select_option_136']")
    private WebElement usageValue;
    @FindBy(xpath = "//div[contains(@class, 'layout-align-end-start')]/button[contains(@class, 'cpc-button')]")
    private WebElement addToEstimate;
    @FindBy(xpath = "//md-card-content[@id='resultBlock']")
    private WebElement checkEstimateExist;
    @FindBy(xpath = "//button[.//span[text()='email']]")
    private WebElement emailEstimate;
    @FindBy(xpath = "//md-input-container[@class='flex md-input-invalid']/input[@id='input_633']")
    private WebElement setEmailAddress;
    @FindBy(xpath = "//button[contains(text(), 'Send Email')]")
    private WebElement sendEmail;

    public MainPage(WebDriver driver) {
        // базовый класс для пейджпей наследуется каждый раз в потомках через super
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage open() {
        driver.get(URL);
        return this;
    }

    public MainPage searchCalculator(String searchValue) {
        searchIcon.click();
        searchIcon.sendKeys(searchValue);
        searchIcon.sendKeys(Keys.ENTER);
        return this;
    }

    public MainPage openCalculator() {
        calculatorLink.click();
        return this;
    }

    public MainPage setUpForm(int instanceValue){

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'frame/products/calculator/index')]")));
        driver.switchTo().frame(driver.findElement(By.id("myFrame")));

        numberOfInstances.click();
        numberOfInstances.sendKeys(String.valueOf(instanceValue));
        series.click();
        seriesValue.click();
        machineType.click();
        machineTypeValue.click();
        gpu.click();
        gpuType.click();
        gpuTypeSelect.click();
        gpuNumber.click();
        gpuNumberSelect.click();
        ssd.click();
        ssdValue.click();
//        location.click();
//        locationValue.click();
        usage.click();
        usageValue.click();
        addToEstimate.click();
        return this;
    }

    public MainPage checkPriceIsCalculated(){
        String cal = "Total Estimated Cost:";
        Assertions.assertTrue(checkEstimateExist.getText().contains(cal));
        return this;
    }

    public MainPage emailEstimate(){
        String emailAddress = "praweuvallomi-7791@yopmail.com";

        emailEstimate.click();
        setEmailAddress.click();
        setEmailAddress.sendKeys(emailAddress);
        sendEmail.click();

        return this;
    }



}
