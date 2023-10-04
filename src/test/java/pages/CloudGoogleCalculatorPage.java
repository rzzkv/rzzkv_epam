package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloudGoogleCalculatorPage extends YopmailPage {
    @FindBy(xpath = "//input[@id='input_98']")
    private WebElement numberOfInstances;
    @FindBy(xpath = "//*[@id='select_value_label_93']")
    private WebElement series;
    @FindBy(css = ".md-select-menu-container.md-active.md-clickable md-option[value^=\"n1\"]")
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
    @FindBy(css = "md-option[ng-repeat=\"item in listingCtrl.dynamicSsd.computeServer\"][value=\"2\"]")
    private WebElement ssdValue;
    @FindBy(xpath = "//*[@id='select_value_label_96']")
    private WebElement location;
    @FindBy(css = "div[role^=\"presentation\"] ._md.md-overflow ._md>md-optgroup>md-option[value^=\"europe-west3\"]")
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

    public CloudGoogleCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CloudGoogleCalculatorPage calculatorPageFrame(){
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'frame/products/calculator/index')]")));
        driver.switchTo().frame(driver.findElement(By.id("myFrame")));
        return this;
    }

    public CloudGoogleCalculatorPage setNumberOfInstances(String instanceValue){
        numberOfInstances.sendKeys(instanceValue);
        return this;
    }

    public CloudGoogleCalculatorPage setSeries(){
        series.click();
        seriesValue.click();
        return this;
    }

    public CloudGoogleCalculatorPage setMachineType(){
        machineType.click();
        machineTypeValue.click();
        return this;
    }

    public CloudGoogleCalculatorPage addGPU(){
        gpu.click();
        return this;
    }

    public CloudGoogleCalculatorPage selectGPUType(){
        gpuType.click();
        gpuTypeSelect.click();
        return this;
    }

    public CloudGoogleCalculatorPage selectGPUNumber(){
        gpuNumber.click();
        gpuNumberSelect.click();
        return this;
    }

    public CloudGoogleCalculatorPage setSSDValue(){
        ssd.click();
        ssdValue.click();
        return this;
    }

    public CloudGoogleCalculatorPage setLocation(){
        location.click();
        locationValue.click();
        return this;
    }

    public CloudGoogleCalculatorPage setUsageValue(){
        usage.click();
        usageValue.click();
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

    public void emailEstimate(String emailAddress){
        emailEstimate.click();
        setEmailAddress.click();
        setEmailAddress.sendKeys(emailAddress);
        sendEmail.click();
    }
}

