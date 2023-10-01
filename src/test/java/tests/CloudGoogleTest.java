package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.CloudGooglePage;
import pages.YopmailPage;
import pages.CloudGoogleCalculatorPage;
import utils.Tab;

import java.io.IOException;

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
//                .setLocation()
                .setUsageValue()
                .addToEstimateBtn()
                .checkPriceIsCalculated(data.totalEstimateCostTxt);
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

        Assertions.assertTrue(mailMessage.contains(totalCost));
    }
}



