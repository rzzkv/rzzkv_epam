package tests;

import org.testng.annotations.Test;
import pages.YopmailPage;
import helpers.CommonConditions;
import helpers.TestData;

public class YopmailTest extends CommonConditions {

    @Test(groups = { "blocker", "mail" })
    public void createRandomEmailTest(){
        YopmailPage yopmail = new YopmailPage(driver);
        yopmail.createRandomEmail(TestData.URL_RANDOM_EMAIL);
        String emailAddress = yopmail.getEmailAddress();

        softly.assertThat(emailAddress).contains("@yopmail.com");
        softly.assertAll();
    }
}
