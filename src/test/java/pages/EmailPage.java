package pages;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class EmailPage extends BasePage {

    private static final String URL = "https://yopmail.com/en/";

    @FindBy(xpath = "//*[@href='email-generator']")
    private WebElement randomEmail;
    @FindBy(xpath = "//span[@class='genytxt']")
    private WebElement emailAddress;
    @FindBy(xpath = "//*[text()='Check Inbox']")
    private WebElement checkInbox;
    @FindBy(xpath = "//input[@class='mb2a7b']")
    private WebElement searchIcon;
    @FindBy(xpath = "//input[@class='mb2a7b']")
    private WebElement searchIcon1;
    @FindBy(xpath = "//button[@id='refresh']")
    private WebElement refreshButton;
    @FindBy(xpath = "//div[@id='mail']")
    private WebElement mailField;

    public EmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public EmailPage open() {
        driver.get(URL);
        return this;
    }

    public EmailPage createRandomEmail() {
        randomEmail.click();
        return this;
    }

    public EmailPage removeAdd(){ // todo

        return this;
    }

    public String getEmailAddress() {
        return emailAddress.getText() + "@yopmail.com";
    }

    public EmailPage checkMessage() {
        checkInbox.click();
        return this;
    }

    public String getEmailMessage() throws InterruptedException {

        refreshButton.click();
        driver.switchTo().frame(driver.findElement(By.id("myFrame")));
        if(!mailField.isDisplayed()){
// can not use this, since id would not presence without refresh
//      new WebDriverWait(driver, Duration.ofSeconds(10))
//                    .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("mail")));
            mailField.wait(5000);
            refreshButton.click();
        }
        return mailField.getText();
    }

    public void createEmailAddress(){
        driver.switchTo().newWindow(WindowType.TAB);
                open();
                createRandomEmail();
                getEmailAddress();
        Set<String> windowHandles = driver.getWindowHandles();
        driver.switchTo().window(windowHandles.iterator().next());

    }

}
