package tests;

import org.junit.jupiter.api.Test;
import pages.EmailPage;
import pages.MainPage;
import pages.PastePage;

import static java.lang.Thread.sleep;

public class PastebinTest extends TestBase {

    @Test
    public void checkNewPaste(){
        MainPage mainPage = new MainPage(driver);

        mainPage
                .open()
                .searchCalculator(data.searchValue)
                .openCalculator()
                .setUpForm(data.instanceValue)
                .checkPriceIsCalculated()
                .emailEstimate();

    }

    @Test
    public void createEmailAddres(){
        EmailPage emailPage = new EmailPage(driver);

        emailPage
                .open()
                .createEmailAddress()
                .copyEmailAddress();


        String email = emailPage.copyEmailAddress().toString();
        System.out.println(email);
    }
}
