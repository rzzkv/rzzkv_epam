package tests;

import org.junit.jupiter.api.*;
import pages.YopmailPage;
import tests.helpers.CommonConditions;
import tests.helpers.TestData;

import java.io.IOException;

public class YopmailTest extends CommonConditions {

    @Test
    public void createRandomEmailTest() throws IOException {
        YopmailPage yopmail = new YopmailPage(driver);
        yopmail
                .open(TestData.URL_EMAIL)
                .createRandomEmail();
        String emailAddress = yopmail.getEmailAddress();

        Assertions.assertTrue(emailAddress.contains("@yopmail.com"));
    }
}
