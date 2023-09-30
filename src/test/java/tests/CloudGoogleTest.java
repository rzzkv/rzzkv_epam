package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CloudGooglePage;
import pages.YopmailPage;
import pages.CalculatorPage;

public class CloudGoogleTest extends CommonConditions {

    @Test
    public void googleCloudCalculatorTest() throws InterruptedException {
        CloudGooglePage cloudGooglePage = new CloudGooglePage(driver);
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        YopmailPage yopmailPage = new YopmailPage(driver);

        cloudGooglePage
                .open(data.URL_CLOUD_GOOGLE)
                .searchCalculator(data.searchValue)
                .openCalculator();

        calculatorPage
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
        String totalCost = calculatorPage.getTotalCost();

        yopmailPage
                .createNewTab()
                .open(data.URL_EMAIL)
                .createRandomEmail();
        String emailAddress = yopmailPage.getEmailAddress();
        yopmailPage.switchToFirstTab();
        calculatorPage
                .calculatorPageFrame()
                .emailEstimate(emailAddress)
                .switchToSecondTab();
        String mailMessage = yopmailPage.getEmailMessage();

        Assertions.assertTrue(mailMessage.contains(totalCost));
    }
}

// Things to improve:
// add additional unit tests or separate to small tests
// delete test  from emailPage
// our main service test depends on email service,