package pages;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPage extends BasePage {

    private static final String URL = "https://yopmail.com/en/";

    @FindBy(xpath = "//*[@href='email-generator']")
    private WebElement randomEmail;
    @FindBy(xpath = "//span[@class='genytxt']") //in case I would use getText method
    private WebElement emailAddress;
//    @FindBy(xpath = "//button[@id='cprnd']") //in case I would bring data from buffer
//    private WebElement searchIcon;
    @FindBy(xpath = "//*[text()='Check Inbox']")
    private WebElement checkInbox;
    @FindBy(xpath = "//input[@class='mb2a7b']")
    private WebElement searchIcon;
    @FindBy(xpath = "//input[@class='mb2a7b']")
    private WebElement searchIcon1;

    public EmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public EmailPage open() {
        driver.get(URL);
        return this;
    }

    public EmailPage createEmailAddress() {
        randomEmail.click();
        return this;
    }

    public EmailPage copyEmailAddress() {
        emailAddress.getText();
        return this;
    }

    public EmailPage checkEmailAddress() {
        checkInbox.click();
        return this;
    }





}
