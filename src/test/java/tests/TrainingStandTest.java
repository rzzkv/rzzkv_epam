package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.CloudGoogleCalculatorPage;
import tests.helpers.CommonConditions;
import tests.helpers.TestData;

public class TrainingStandTest extends CommonConditions {

    @Test
    public void testMain(){
        CloudGoogleCalculatorPage cloudGoogleCalculator = new CloudGoogleCalculatorPage(driver);

        driver.get("https://cloud.google.com/products/calculator");
        cloudGoogleCalculator
                .calculatorPageFrame(driver)
                .setNumberOfInstances(TestData.instanceValue)
                .setSeries(TestData.seriesValue)
                .setMachineType(TestData.machineTypeValue)
                .addGPU()
                .selectGPUType(TestData.gpuTypeValue)
                .selectGPUNumber(TestData.gpuNumberByText)
                .setSSDValue(TestData.ssdValue)
//                .setLocation(TestData.locationValue)
                .setUsageValue(TestData.usageId);
    }

    @Test
    public void testId(){
        CloudGoogleCalculatorPage cloudGoogleCalculator = new CloudGoogleCalculatorPage(driver);
        driver.get("https://cloud.google.com/products/calculator");
        cloudGoogleCalculator
                .calculatorPageFrame(driver)
                .setNumberOfInstances(TestData.instanceValue)
                .setSeries(TestData.seriesValue)
                .setMachineType(TestData.machineTypeValue)
                .addGPU()
                .selectGPUType(TestData.gpuTypeValue);
        //gpuNumber
        driver.findElement(By.id("select_507")).click();
        driver.findElement(By.id("select_option_515")).click();
        //ssd
        driver.findElement(By.id("select_464")).click();
        driver.findElement(By.id("select_option_490")).click();
        //usage
        driver.findElement(By.id("select_138")).click();
        driver.findElement(By.id("select_option_136")).click();
    }

    @Test
    public void testCss(){
        CloudGoogleCalculatorPage cloudGoogleCalculator = new CloudGoogleCalculatorPage(driver);
        driver.get("https://cloud.google.com/products/calculator");
        cloudGoogleCalculator
                .calculatorPageFrame(driver)
                .setNumberOfInstances(TestData.instanceValue)
                .setSeries(TestData.seriesValue)
                .setMachineType(TestData.machineTypeValue)
                .addGPU()
                .selectGPUType(TestData.gpuTypeValue);
        //gpuNumber
        driver.findElement(By.id("select_507")).click();
        driver.findElement(By.cssSelector("md-option[ng-repeat=\"item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]\"][value=\"1\"]")).click();
        //ssd
        driver.findElement(By.id("select_464")).click();
        driver.findElement(By.xpath("//md-option[@ng-repeat=\"item in listingCtrl.dynamicSsd.computeServer\" and @value=\"2\"]")).click();
//        driver.findElement(By.cssSelector("md-option[ng-repeat=\"item in listingCtrl.dynamicSsd.computeServer\"][value=\"2\"]")).click();
        //usage
        driver.findElement(By.id("select_138")).click();
        driver.findElement(By.id("select_option_136")).click();
    }}
