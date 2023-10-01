package tests;

import org.junit.jupiter.api.*;
import pages.YopmailPage;
import utils.Utility;

import java.io.IOException;

public class YopmailTest extends CommonConditions{

    @Tags({@Tag("smoke"), @Tag("BLOCKER")})
    @DisplayName("The check for the possibility of creating a random temporary Email Address.")
    @Test
    public void createRandomEmailTest() throws IOException {
        YopmailPage yopmail = new YopmailPage(driver);
        yopmail
                .open(data.URL_EMAIL)
                .createRandomEmail();
        String emailAddress = yopmail.getEmailAddress();

        Assertions.assertTrue(emailAddress.contains("@yopmail.com"));

        utility.takeScreenShot(driver);
    }
}
