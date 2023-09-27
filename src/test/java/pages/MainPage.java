package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static java.lang.Thread.sleep;

public class MainPage extends EmailPage {

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
    private WebElement gpuType;
    @FindBy(xpath = "//md-option[.//div[normalize-space(text())='NVIDIA Tesla V100']]")
//    @FindBy(xpath = "//*[@id='select_option_548']")
    private WebElement gpuTypeSelect;
    @FindBy(xpath = "//md-select-value[.//div[normalize-space(text())='0']]")
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
    @FindBy(xpath = "//input[@type='email']")
//    @FindBy(xpath = "//label[text()='Email ']/ancestor-or-self::md-input-container")
//    @FindBy(xpath = "//md-input-container[@class='flex md-input-invalid']/input[@id='input_633']")
    private WebElement setEmailAddress;
    @FindBy(xpath = "//button[contains(text(), 'Send Email')]")
    private WebElement sendEmail;

    public MainPage(WebDriver driver) {
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

    public MainPage checkPriceIsCalculated(String cal){
    //I know that in Page should not be any test, but did not figure out how to do it better
        Assertions.assertTrue(checkEstimateExist.getText().contains(cal));
        return this;
    }

    public String getPriceCalculated(){

        String priceCalculated = checkEstimateExist.getText();

        return priceCalculated;
    }

    public MainPage emailEstimate(){
//        driver.switchTo().window(driver.getWindowHandle());

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'frame/products/calculator/index')]")));
        driver.switchTo().frame(driver.findElement(By.id("myFrame")));

        emailEstimate.click();
        setEmailAddress.click();
//        setEmailAddress.sendKeys("998936236723@yandex.ru"); //todo
        setEmailAddress.sendKeys(getEmailAddress());
        sendEmail.click();
        driver.switchTo().window(switchToAnotherTab());

        return this;
    }
}

