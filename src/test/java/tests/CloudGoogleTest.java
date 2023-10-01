package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CloudGooglePage;
import pages.YopmailPage;
import pages.CloudGoogleCalculatorPage;

public class CloudGoogleTest extends CommonConditions {

    @Test
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
                .addToEstimateBtn()
                .checkPriceIsCalculated(data.totalEstimateCostTxt);
        String totalCost = cloudGoogleCalculator.getTotalCost();

        yopmail
                .createNewTab()
                .open(data.URL_EMAIL)
                .createRandomEmail();
        String emailAddress = yopmail.getEmailAddress();
        yopmail.switchToFirstTab();
        cloudGoogleCalculator
                .calculatorPageFrame()
                .emailEstimate(emailAddress)
                .switchToSecondTab();
        String mailMessage = yopmail.getEmailMessage();

        Assertions.assertTrue(mailMessage.contains(totalCost));
    }
}



