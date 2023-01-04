package src.RawData;

public class Car {

    /////"<Model> <EngineSpeed> <EnginePower> <CargoWeight> <CargoType> "


    private String model;
    private int engineSpeed;

    public String getModel() {
        return model;
    }

    private int enginePower;

    public int getEnginePower() {
        return enginePower;
    }

    private int cargoWeight ;

    public String getCargoType() {
        return cargoType;
    }

    private String cargoType;

    public Car (String model,int engineSpeed, int enginePower,int cargoWeight,String cargoType){
        this.model = model;
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
        this.cargoWeight=cargoWeight;
        this.cargoType= cargoType;
    }
}
