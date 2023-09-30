package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainPage extends BasePage {

    @FindBy(xpath = "//textarea[@id='postform-text']")
    private WebElement pasteArea;
    @FindBy(xpath = "//span[@id='select2-postform-expiration-container']")
    private WebElement pasteExpiration;
    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement pasteExpirationSet10Minutes;
    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement pasteName;
    @FindBy(xpath = "//div[@class='form-group form-btn-container']//button[@type='submit']")
    private WebElement createPasteBtn;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage open(String URL){
        driver.get(URL);

        WebElement popupAd = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//div[@id='vi-smartbanner']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].remove()", popupAd);
        return this;
    }

    public MainPage writeInPaste(String pasteValue) {
        pasteArea.sendKeys(pasteValue);
        return this;
    }

    public MainPage setPasteExpiration() {
        pasteExpiration.click();
        pasteExpirationSet10Minutes.click();
        return this;
    }

    public MainPage setPasteName(String nameValue) {
        pasteName.sendKeys(nameValue);
        return this;
    }

    public void createPaste() {
        createPasteBtn.click();
    }
}
