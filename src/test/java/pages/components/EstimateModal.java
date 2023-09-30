package pages.components;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EstimateModal {

    @FindBy(xpath = "//md-card-content[@id='resultBlock']")
    private WebElement checkEstimateExist;

    public void checkPriceIsCalculated(String cal){
        Assertions.assertTrue(checkEstimateExist.getText().contains(cal));
    }
}
