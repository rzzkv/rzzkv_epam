package tests;

import config.PropertiesFile;
import org.testng.annotations.Test;
import pages.YopmailPage;
import tests.helpers.CommonConditions;
import tests.helpers.TestData;

public class YopmailTest extends CommonConditions {

    @Test(groups = { "blocker", "mail" })
    public void createRandomEmailTest(){
        YopmailPage yopmail = new YopmailPage(driver);
        yopmail
                .createRandomEmail(TestData.URL_RANDOM_EMAIL);
        String emailAddress = yopmail.getEmailAddress();

        softly.assertThat(emailAddress).contains("@yopmail.com");
        softly.assertAll();
    }
}
