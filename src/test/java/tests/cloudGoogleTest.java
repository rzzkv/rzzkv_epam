package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.EmailPage;
import pages.CloudGooglePage;

import static java.lang.Thread.sleep;

public class cloudGoogleTest extends TestBase {

    @Test
    public void googleCloudCalculatorTest() throws InterruptedException {
        CloudGooglePage cloudGooglePage = new CloudGooglePage(driver);
        EmailPage emailPage = new EmailPage(driver);

        cloudGooglePage
                .open(data.URL_CLOUD_GOOGLE)
                .searchCalculator(data.searchValue)
                .openCalculator()
                .setUpForm(data.instanceValue)
                .checkPriceIsCalculated(data.cal);
        String totalCost = cloudGooglePage.getTotalCost();
        emailPage
                .createNewTab()
                .open(data.URL_EMAIL)
                .createRandomEmail()
                .getEmailAddress();
        String emailAddress = emailPage.getEmailAddress();

        emailPage.switchToAnotherTab();
        cloudGooglePage.emailEstimate(emailAddress);
        String mailMessage = emailPage.getEmailMessage();

        Assertions.assertTrue(mailMessage.contains(totalCost));
    }
}


// add additional unit tests or separate to small tests
// delete test  from emailPage
// delete one of protected WebDriver driver; DRY
// our main service test depends on email service,