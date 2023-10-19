package objects;

import helpers.TestDataReader;

import java.util.Objects;

public class ComputeEngineBO {

    private static String numberOfInstances = TestDataReader.getTestData("calculator.numberOfInstances");
    private static String series = TestDataReader.getTestData("calculator.series");
    private static String machineType = TestDataReader.getTestData("calculator.machineType");
    private static String gpuNumber = TestDataReader.getTestData("calculator.numberOfGPU");
    private static String gpuType = TestDataReader.getTestData("calculator.typeOfGPU");
    private static String ssd = TestDataReader.getTestData("calculator.localSSD");
    private static String usage = TestDataReader.getTestData("calculator.committedUsage");

    public ComputeEngineBO(String numberOfInstances, String series, String machineType, String gpuType, String gpuNumber, String ssd, String location, String usage){
        ComputeEngineBO.numberOfInstances = numberOfInstances;
        ComputeEngineBO.series = series;
        ComputeEngineBO.machineType = machineType;
        ComputeEngineBO.gpuType = gpuType;
        ComputeEngineBO.gpuNumber = gpuNumber;
        ComputeEngineBO.ssd = ssd;
        ComputeEngineBO.usage = usage;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public String getSeries() {
        return series;
    }

    public String getMachineType() {
        return machineType;
    }

    public String getGpuType() {
        return gpuType;
    }

    public String getGpuNumber() {
        return gpuNumber;
    }

    public String getSsd() {
        return ssd;
    }

    public String getUsage() {
        return usage;
    }

    public static ComputeEngineBO createWithProperty() {
        return new ComputeEngineBO(numberOfInstances,  series,
                machineType, machineType, gpuType, gpuNumber, ssd, usage);
    }

    /*
            equals(Object o) method can determine whether two ComputeEngineBO objects are equal
            based on their numberOfInstances and series fields.
         */
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }else if (o == null || getClass() != o.getClass()){
            return false;
        }else{
            ComputeEngineBO that = (ComputeEngineBO) o;
            return Objects.equals(numberOfInstances, that.numberOfInstances)
                    && Objects.equals(series, that.series)
                    && Objects.equals(machineType, that.machineType)
                    && Objects.equals(gpuType, that.gpuType)
                    && Objects.equals(gpuNumber, that.gpuNumber)
                    && Objects.equals(ssd, that.ssd)
                    && Objects.equals(usage, that.usage);
        }

    }
}
