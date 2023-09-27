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
    @FindBy(xpath = "//*[@id='google_esf']")
    WebElement adFrame;

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
        if(adFrame.isEnabled()) {
            driver.get("https://yopmail.com/en/email-generator");
//            driver.navigate().refresh();
//            randomEmail.click();
        }
        return this;
    }

    public String getEmailAddress() {
        System.out.println(emailAddress.getText() + "@yopmail.com");
        return emailAddress.getText() + "@yopmail.com";

    }

//    public EmailPage checkMessage() {
//        checkInbox.click();
//        return this;
//    }

    public String getEmailMessage() throws InterruptedException {

        driver.navigate().refresh();
        checkInbox.click();
        refreshButton.click();
        driver.switchTo().frame(driver.findElement(By.id("ifmail")));
        if(!mailField.isDisplayed()){
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
//        Set<String> windowHandles = driver.getWindowHandles();
//        driver.switchTo().window(windowHandles.iterator().next());

    }

    public String switchToAnotherTab(){
        Set<String> windowHandles = driver.getWindowHandles();
        String tab1Handle = windowHandles.iterator().next();
        String tab2Handle = windowHandles.stream().filter(handle -> !handle.equals(tab1Handle)).findFirst().get();
        driver.switchTo().window(tab1Handle);
        return tab2Handle;
    }

}
