package constructors_order;

public class FaultyCar extends Car {

    private int moneyNeededToFix;

    public FaultyCar(String canBeDrivenOn, String brand, String model, int horses, int engineVolume, int moneyNeededToFix) {
        super(canBeDrivenOn, brand, model, horses, engineVolume);
        System.out.println("Inside Faulty Car constructor");
        this.moneyNeededToFix = moneyNeededToFix;
    }
}
