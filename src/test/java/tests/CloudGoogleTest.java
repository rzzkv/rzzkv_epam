package tests;

import org.junit.jupiter.api.Test;
import pages.CloudGooglePage;
import pages.YopmailPage;
import pages.CloudGoogleCalculatorPage;
import tests.helpers.CommonConditions;
import tests.helpers.TestData;

public class CloudGoogleTest extends CommonConditions {

    @Test
    public void googleCloudCalculatorTest() throws InterruptedException {
        CloudGooglePage cloudGoogle = new CloudGooglePage(driver);
        CloudGoogleCalculatorPage cloudGoogleCalculator = new CloudGoogleCalculatorPage(driver);
        YopmailPage yopmail = new YopmailPage(driver);

        cloudGoogle
                .open(TestData.URL_CLOUD_GOOGLE)
                .searchGivenValue(TestData.searchValue)
                .openCalculator();

        cloudGoogleCalculator
                .calculatorPageFrame(driver, TestData.iFrameXpath, TestData.iFrameId)
                .setNumberOfInstances(TestData.instanceValue)
                .setSeries(TestData.seriesValue)
                .setMachineType(TestData.machineTypeValue)
                .addGPU()
                .selectGPUType(TestData.gpuTypeValue)
                .selectGPUNumber(TestData.gpuNumberByText)
                .setSSDValue(TestData.ssdValue)
//                .setLocation(TestData.locationValue)
                .setUsageValue(TestData.usageId)
                .addToEstimateBtn();

        String estimateTitle = cloudGoogleCalculator.getEstimateTitle();
        softly.assertThat(estimateTitle.contains(TestData.totalEstimateCostText));
        String totalCost = cloudGoogleCalculator.getTotalCost();

        tab.createNewTab(driver);
        yopmail.createRandomEmail(TestData.URL_RANDOM_EMAIL);
        String emailAddress = yopmail.getEmailAddress();

        tab.switchToMainTab(driver);
        cloudGoogleCalculator
                .calculatorPageFrame(driver, TestData.iFrameXpath, TestData.iFrameId)
                .emailEstimateBtn()
                .setEmailAddress(emailAddress)
                .sendEmailBtn();

        tab.switchToSecondTab(driver);
        String mailMessage = yopmail.getEmailMessage();

        softly.assertThat(mailMessage.contains(totalCost));
    }
}




