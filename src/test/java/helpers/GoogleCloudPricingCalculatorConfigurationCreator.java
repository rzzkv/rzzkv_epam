package helpers;

import objects.PricingCalculatorPageConfiguration;

public class GoogleCloudPricingCalculatorConfigurationCreator {
    private static final String numberOfInstances = TestDataReader.getTestData("calculator.numberOfInstances");
    private static final String operatingSystem = TestDataReader.getTestData("calculator.operatingSystem");
    private static final String provisioningModel = TestDataReader.getTestData("calculator.provisioningModel");
    private static final String machineFamily = TestDataReader.getTestData("calculator.machineFamily");
    private static final String series = TestDataReader.getTestData("calculator.series");
    private static final String machineType = TestDataReader.getTestData("calculator.machineType");
    private static final String numberOfGPU = TestDataReader.getTestData("calculator.numberOfGPU");
    private static final String typeOfGPU = TestDataReader.getTestData("calculator.typeOfGPU");
    private static final String localSSD = TestDataReader.getTestData("calculator.localSSD");
    private static final String committedUsage = TestDataReader.getTestData("calculator.committedUsage");


    public static PricingCalculatorPageConfiguration createWithProperty() {
        return new PricingCalculatorPageConfiguration(numberOfInstances, operatingSystem, provisioningModel, machineFamily, series,
                machineType, numberOfGPU, typeOfGPU, localSSD, committedUsage );
    }
}
