package constructors_order;

public class Car extends Vehicle {

    private String brand;
    private String model;
    private int horses;
    //In cc
    private int engineVolume;

    public Car(String canBeDrivenOn, String brand, String model, int horses) {
        super(canBeDrivenOn);
        System.out.println("Inside Car constructor - 4 params");
        this.brand = brand;
        this.model = model;
        this.horses = horses;
    }

    public Car(String canBeDrivenOn, String brand, String model, int horses, int engineVolume) {
        this(canBeDrivenOn, brand, model, horses);
        System.out.println("Inside Car constructor - 5 params");
        this.engineVolume = engineVolume;
    }

}
