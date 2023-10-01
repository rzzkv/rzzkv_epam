package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.components.EstimateModal;

import static java.lang.Thread.sleep;

public class CalculatorPage extends YopmailPage {

    EstimateModal estimateModal = new EstimateModal();
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

    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CalculatorPage calculatorPageFrame(){
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'frame/products/calculator/index')]")));
        driver.switchTo().frame(driver.findElement(By.id("myFrame")));
        return this;
    }

    public CalculatorPage setNumberOfInstances(String instanceValue){
        numberOfInstances.click();
        numberOfInstances.sendKeys(String.valueOf(instanceValue));
        return this;
    }

    public CalculatorPage setSeries(){
        series.click();
        seriesValue.click();
        return this;
    }

    public CalculatorPage setMachineType(){
        machineType.click();
        machineTypeValue.click();
        return this;
    }

    public CalculatorPage addGPU(){
        gpu.click();
        return this;
    }

    public CalculatorPage selectGPUType(){
        gpuType.click();
        gpuTypeSelect.click();
        return this;
    }

    public CalculatorPage selectGPUNumber(){
        gpuNumber.click();
        gpuNumberSelect.click();
        return this;
    }

    public CalculatorPage setSSDValue(){
        ssd.click();
        ssdValue.click();
        return this;
    }

    public CalculatorPage setLocation(){
        location.click();
        locationValue.click();
        return this;
    }

    public CalculatorPage setUsageValue(){
        usage.click();
        usageValue.click();
        return this;
    }

    public CalculatorPage addToEstimateBtn(){
        addToEstimate.click();
        return this;
    }

    public void checkPriceIsCalculated(String totalEstimateCostTxt){
//  I know that in Page should not be any test, but did not figure out how to do it better
        Assertions.assertTrue(checkEstimateExist.getText().contains(totalEstimateCostTxt));
//  Tried to add separate class EstimateModal as component, but didn't work "NullPointerException", thing to discuss on call
//        estimateModal.checkPriceIsCalculated(cal);
    }

    public String getTotalCost() {
        return cartTotal.getText()
                .replace("Total Estimated Cost: ", "")
                .replace(" per 1 month", "");
    }

    public CalculatorPage emailEstimate(String emailAddress){
        emailEstimate.click();
        setEmailAddress.click();
        setEmailAddress.sendKeys(emailAddress);
        sendEmail.click();
        return  this;
    }

    public void switchToSecondTab(){
        driver.switchTo().window(switchToFirstTab());
    }
}

