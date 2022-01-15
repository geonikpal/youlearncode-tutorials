package constructors_order;

public class WorkingCar extends Car {

    private int daysLeftUntilService;

    public WorkingCar(String canBeDrivenOn, String brand, String model, int horses, int engineVolume, int daysLeftUntilService) {
        super(canBeDrivenOn, brand, model, horses, engineVolume);
        System.out.println("Inside Working Car constructor");
        this.daysLeftUntilService = daysLeftUntilService;
    }
}
