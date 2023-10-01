package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
                .setLocation()
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

    @Test
    public void test(){
                driver.get("https://cloud.google.com/products/calculator");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'frame/products/calculator/index')]")));
        driver.switchTo().frame(driver.findElement(By.id("myFrame")));

        driver.findElement(By.xpath("//*[@id='select_value_label_96']")).click();
        driver.findElement(By.xpath("(//div[normalize-space(text())='Frankfurt (europe-west3)'])[last()]")).click();

    }
}



