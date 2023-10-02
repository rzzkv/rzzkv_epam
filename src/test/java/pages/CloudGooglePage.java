package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloudGooglePage extends YopmailPage {

    @FindBy(xpath = "//input[@class='mb2a7b']")
    private WebElement searchIcon;
    @FindBy(xpath = "//a[@class='gs-title']")
    private WebElement calculatorLink;

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

    public void openCalculator() {
        calculatorLink.click();
    }

    public String getCalculatorLinkText() {
        return calculatorLink.getText();
    }
}
