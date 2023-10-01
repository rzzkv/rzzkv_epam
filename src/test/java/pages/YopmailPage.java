package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class YopmailPage extends BasePage {

    @FindBy(xpath = "//*[@href='email-generator']")
    private WebElement randomEmail;
    @FindBy(xpath = "//div[@id='geny']")
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

    public YopmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public YopmailPage open(String URL) {
        driver.get(URL);
        return this;
    }

    public YopmailPage createRandomEmail() {
        randomEmail.click();
//  need this "if" because of full page ad
        if(adFrame.isEnabled()) {
            driver.get("https://yopmail.com/en/email-generator");
        }
        return this;
    }

    public String getEmailAddress() {
        return emailAddress.getText();
    }

    public String getEmailMessage() throws InterruptedException {

        checkInbox.click();
        refreshButton.click();
        driver.switchTo().frame(driver.findElement(By.id("ifmail")));
//  need this "if" in case email wasn't received yet
        if(!mailField.isDisplayed()){
            mailField.wait(5000);
            refreshButton.click();
        }
        return mailField.getText();
    }

    public YopmailPage createNewTab(){
        driver.switchTo().newWindow(WindowType.TAB);
        return this;
    }

    public String switchToFirstTab(){
        Set<String> windowHandles = driver.getWindowHandles();
        String tab1Handle = windowHandles.iterator().next();
        String tab2Handle = windowHandles.stream().filter(handle -> !handle.equals(tab1Handle)).findFirst().get();
        driver.switchTo().window(tab1Handle);
        return tab2Handle;
    }
}
