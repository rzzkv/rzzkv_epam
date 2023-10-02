package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.YopmailPage;

import java.io.IOException;

public class YopmailTest extends CommonConditions{

    @Test(groups = { "blocker", "mail" })
    public void createRandomEmailTest() throws IOException {
        YopmailPage yopmail = new YopmailPage(driver);
        yopmail
                .open(data.URL_EMAIL)
                .createRandomEmail();
        String emailAddress = yopmail.getEmailAddress();

        Assert.assertTrue(emailAddress.contains("@yopmail.com"));

//        utility.takeScreenShot(driver);
    }
}
