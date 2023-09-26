package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.EmailPage;
import pages.MainPage;

import static java.lang.Thread.sleep;

public class cloudGoogleTest extends TestBase {


    @Test
    public void checkNewPaste() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        EmailPage emailPage = new EmailPage(driver);


        mainPage
                .open()
                .searchCalculator(data.searchValue)
                .openCalculator()
                .setUpForm(data.instanceValue)
                .checkPriceIsCalculated(data.cal);

        emailPage
                .createEmailAddress();

        mainPage
                .emailEstimate();

//        Assertions.assertTrue(
//                emailPage.getEmailMessage()
//                    .contains(mainPage.getPriceCalculated()));
    }

//    @Test
//    public void createEmailAddress(){
//        emailPage
//                .open()
//                .createRandomEmail()
//                .getEmailAddress(); //todo delete this method
//    }
}

// add additional unit tests or separate to small tests
// delete test  from emailPage
// delete one of protected WebDriver driver; DRY
// our main service test depends on email service,