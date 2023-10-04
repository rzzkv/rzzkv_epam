package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CloudGooglePage;
import pages.YopmailPage;
import pages.CloudGoogleCalculatorPage;


public class CloudGoogleTest extends CommonConditions {

    @Test(groups = { "blocker", "google" })
    public void calculatorSearchTest(){
        CloudGooglePage cloudGoogle = new CloudGooglePage(driver);

        cloudGoogle
                .open(data.URL_CLOUD_GOOGLE)
                .searchCalculator(data.searchValue);
        String mailMessage = cloudGoogle.getCalculatorLinkText();

        Assert.assertEquals(mailMessage, data.CalculatorLinkText);
    }

    @Test(groups = { "blocker", "main" })
    public void googleCloudCalculatorTest() throws InterruptedException {
        CloudGooglePage cloudGoogle = new CloudGooglePage(driver);
        CloudGoogleCalculatorPage cloudGoogleCalculator = new CloudGoogleCalculatorPage(driver);
        YopmailPage yopmail = new YopmailPage(driver);

        cloudGoogle
                .open(data.URL_CLOUD_GOOGLE)
                .searchCalculator(data.searchValue)
                .openCalculator();

        cloudGoogleCalculator
                .calculatorPageFrame()
                .setNumberOfInstances(data.instanceValue)
                .setSeries()
                .setMachineType()
                .addGPU()
                .selectGPUType()
                .selectGPUNumber()
                .setSSDValue()
                .setLocation()
                .setUsageValue()
                .addToEstimateBtn();

        String estimateTitle = cloudGoogleCalculator.getEstimateTitle();
        Assert.assertTrue(estimateTitle.contains(data.totalEstimateCostText));
        String totalCost = cloudGoogleCalculator.getTotalCost();

        tab.createNewTab(driver);
        yopmail
                .open(data.URL_EMAIL)
                .createRandomEmail();
        String emailAddress = yopmail.getEmailAddress();

        tab.switchToMainTab(driver);
        cloudGoogleCalculator
                .calculatorPageFrame()
                .emailEstimate(emailAddress);

        tab.switchToSecondTab(driver);
        String mailMessage = yopmail.getEmailMessage();

        Assert.assertTrue(mailMessage.contains(totalCost));
    }
}



