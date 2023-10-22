package tests;

import org.testng.annotations.Test;
import pages.CloudGooglePage;
import pages.YopmailPage;
import pages.CloudGoogleCalculatorPage;
import helpers.CommonConditions;
import helpers.TestData;

public class CloudGoogleTest extends CommonConditions {


    @Test(groups = { "blocker", "google" })
    public void calculatorSearchTest(){
        CloudGooglePage cloudGoogle = new CloudGooglePage(driver);

        cloudGoogle
                .open(TestData.URL_CLOUD_GOOGLE)
                .searchGivenValue(TestData.searchValue);
        String mailMessage = cloudGoogle.getCalculatorLinkText();

        softly.assertThat(mailMessage).isEqualTo(TestData.CalculatorLinkText);
    }

    @Test(groups = { "blocker", "main" })
    public void googleCloudCalculatorTest() throws InterruptedException {
        CloudGooglePage cloudGoogle = CloudGooglePage.init(driver);
//        CloudGoogleCalculatorPage cloudGoogleCalculator = new CloudGoogleCalculatorPage(driver);
        YopmailPage yopmail = new YopmailPage(driver);

        cloudGoogle
//                .open(TestData.URL_CLOUD_GOOGLE)
                .searchGivenValue(TestData.searchValue);

        CloudGoogleCalculatorPage cloudGoogleCalculator = cloudGoogle.openCalculator();

        cloudGoogleCalculator
                .calculatorPageFrame(driver)
                .setNumberOfInstances(TestData.instanceValue)
                .setSeries(TestData.seriesValue)
                .setMachineType(TestData.machineTypeValue)
                .addGPU()
                .selectGPUType(TestData.gpuTypeValue)
                .selectGPUNumber(TestData.gpuNumberByText)
                .setSSDValue(TestData.ssdValue)
                .setUsageValue(TestData.usageId)
                .addToEstimateBtn()
                .checkEstimateAdded();

//        String estimateTitle = cloudGoogleCalculator.getEstimateTitle();
//        // move this assert to the CloudGoogleCalculatorPage in separate method
//        softly.assertThat(estimateTitle).contains(TestData.totalEstimateCostText);
        String totalCost = cloudGoogleCalculator.getTotalCost();

        utility.createNewTab(driver);
        yopmail.createRandomEmail(TestData.URL_RANDOM_EMAIL);
        String emailAddress = yopmail.getEmailAddress();

        utility.switchToMainTab(driver);
        cloudGoogleCalculator
                .calculatorPageFrame(driver)
                .emailEstimateBtn()
                .setEmailAddress(emailAddress)
                .sendEmailBtn();

        utility.switchToSecondTab(driver);
        String mailMessage = yopmail.getEmailMessage();

        softly.assertThat(mailMessage).contains(totalCost);
        softly.assertAll();
    }
}




