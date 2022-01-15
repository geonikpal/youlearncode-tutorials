package parameterized_constructor;

public class Car {
    private String brand;
    private String model;
    private int horses;
    //In cc
    private int engineVolume;

    // Empty
    public Car() {}

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public Car(String brand) {
        this.brand = brand;
    }

    public Car(int horses) {
        this.horses = horses;
    }

    public Car(int horses, int engineVolume) {
        this.horses = horses;
        this.engineVolume = engineVolume;
    }

    public Car(String brand, String model, int horses) {
        this.brand = brand;
        this.model = model;
        this.horses = horses;
    }

    public Car(String brand, String model, int horses, int engineVolume) {
        this.brand = brand;
        this.model = model;
        this.horses = horses;
        this.engineVolume = engineVolume;
    }

    public Car(Car car){
        this.brand = car.brand;
        this.model = car.model;
        this.horses = car.horses;
        this.engineVolume = car.engineVolume;
    }

    public static void main(String[] args) {
        Car car = new Car("Opel", "Astra");

        // Brand and model are required
        car.setHorses(105);
        car.setEngineVolume(1600);

    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorses() {
        return horses;
    }

    public void setHorses(int horses) {
        if(horses > 0 && horses < 1500)
            this.horses = horses;
        else
            throw new
                    IllegalArgumentException("A car cannot have 0, negative horses or more than 1500 horses");
    }

    public int getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(int engineVolume) {
        if(engineVolume > 0 && engineVolume < 10000)
            this.engineVolume = engineVolume;
        else
            throw new
                    IllegalArgumentException("An engine volume cannot be 0cc, negative cc or more than 10000cc");
    }
}
