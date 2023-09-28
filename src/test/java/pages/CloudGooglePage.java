package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class CloudGooglePage extends EmailPage {

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

    @FindBy(xpath = "//div[@class='cpc-cart-total']")
    private WebElement cartTotal;
    @FindBy(xpath = "//button[.//span[text()='email']]")
    private WebElement emailEstimate;
    @FindBy(xpath = "//input[@type='email']")
//    @FindBy(xpath = "//label[text()='Email ']/ancestor-or-self::md-input-container")
//    @FindBy(xpath = "//md-input-container[@class='flex md-input-invalid']/input[@id='input_633']")
    private WebElement setEmailAddress;
    @FindBy(xpath = "//button[contains(text(), 'Send Email')]")
    private WebElement sendEmail;

    public CloudGooglePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CloudGooglePage open(String URL){
        driver.get(URL);
        return this;
    }

    public CloudGooglePage searchCalculator(String searchValue) {
        searchIcon.click();
        searchIcon.sendKeys(searchValue);
        searchIcon.sendKeys(Keys.ENTER);
        return this;
    }

    public CloudGooglePage openCalculator() {
        calculatorLink.click();
        return this;
    }

    public CloudGooglePage setUpForm(String instanceValue){
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

    public void checkPriceIsCalculated(String cal){
    //I know that in Page should not be any test, but did not figure out how to do it better
        Assertions.assertTrue(checkEstimateExist.getText().contains(cal));
    }

    public String getTotalCost(){
        return cartTotal.getText().replace("Total Estimated Cost: ", "").replace(" per 1 month", "");
    }

    public CloudGooglePage emailEstimate(String emailAddress){
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'frame/products/calculator/index')]")));
        driver.switchTo().frame(driver.findElement(By.id("myFrame")));

        emailEstimate.click();
        setEmailAddress.click();
        setEmailAddress.sendKeys(emailAddress);
        sendEmail.click();
        driver.switchTo().window(switchToAnotherTab());
        return this;
    }
}

