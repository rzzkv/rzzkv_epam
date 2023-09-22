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

    private static final String URL = "https://pastebin.com/";

    @FindBy(xpath = "//textarea[@id='postform-text']")
    private WebElement pasteArea;
    @FindBy(xpath = "//span[@id='select2-postform-expiration-container']")
    private WebElement pasteExpiration;
    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement pasteExpirationSet;
    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement pasteName;
    @FindBy(xpath = "//div[@class='form-group form-btn-container']//button[@type='submit']")
    private WebElement createPasteBtn;

    public MainPage(WebDriver driver) {
        // базовый класс для пейджпей наследуется каждый раз в потомках через super
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage open(){
        driver.get(URL);
        return this;
    }

    public MainPage removeAdd(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement popupAd = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//div[@id='vi-smartbanner']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].remove()", popupAd);

        return this;
    }

    public MainPage createNewPaste(String pasteValue, String nameValue) {
        pasteArea.click();
        pasteArea.sendKeys(pasteValue);
        pasteExpiration.click();
        pasteExpirationSet.click();
        pasteName.click();
        pasteName.sendKeys(nameValue);
        createPasteBtn.click();
        return this;
    }
}
