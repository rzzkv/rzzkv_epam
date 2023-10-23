package pages;

import helpers.TestData;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloudGooglePage extends YopmailPage {

    @FindBy(xpath = "//input[@class='mb2a7b']")
    private WebElement searchElement;
    @FindBy(xpath = "//a[@class='gs-title']/b[text()='Google Cloud Pricing Calculator']")
    private WebElement calculatorLink;

    public CloudGooglePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

   public static CloudGooglePage init(WebDriver driver){
       CloudGooglePage page = new CloudGooglePage(driver);
       page.open(TestData.URL_CLOUD_GOOGLE);
       //Проверить заголовок
       return page;
   }

    public CloudGooglePage open(String URL) {
        driver.get(URL);
        return this;
    }

    //    Решил в итоге не разделять этот метод, т.к эти 3 действия всегда будут вместе, просто поменял названия
    public CloudGooglePage searchGivenValue(String searchValue) {
        searchElement.click();
        searchElement.sendKeys(searchValue);
        searchElement.sendKeys(Keys.ENTER);
        return this;
    }
//    return new CloudGoogleCalculatorPage(driver);
//    т.к после вызова openCalculator() нас переносит на странцу CloudGoogleCalculatorPage
    public CloudGoogleCalculatorPage openCalculator() {
        calculatorLink.click();
        //проверить что страница появилась с assert get title

        return new CloudGoogleCalculatorPage(driver);
    }

    public String getCalculatorLinkText() {
        return calculatorLink.getText();
    }
}