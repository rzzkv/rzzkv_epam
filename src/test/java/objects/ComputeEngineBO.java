package objects;

import java.util.Objects;

public class ComputeEngineBO {

    private String numberOfInstances;
    private String series;
    private String machineType;
    private String gpuType;
    private String gpuNumber;
    private String ssd;
    private String location;
    private String usage;

    public ComputeEngineBO(String numberOfInstances, String series, String machineType, String gpuType, String gpuNumber, String ssd, String location, String usage){
        this.numberOfInstances = numberOfInstances;
        this.series = series;
        this.machineType = machineType;
        this.gpuType = gpuType;
        this.gpuNumber = gpuNumber;
        this.ssd = ssd;
        this.location = location;
        this.usage = usage;
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

    public String getLocation() {
        return location;
    }

    public String getUsage() {
        return usage;
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
                    && Objects.equals(location, that.location)
                    && Objects.equals(usage, that.usage);
        }

    }
}
