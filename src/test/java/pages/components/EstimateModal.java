package pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class EstimateModal {

    @FindBy(xpath = "//md-card-content[@id='resultBlock']")
    private WebElement checkEstimateExist;

    public void checkPriceIsCalculated(String cal){
        Assert.assertTrue(checkEstimateExist.getText().contains(cal));
    }
}
