package constructors_order;

public class Vehicle {

    private String canBeDrivenOn;

    public Vehicle(String canBeDrivenOn) {
        System.out.println("Inside Vehicle constructor");
        this.canBeDrivenOn = canBeDrivenOn;
    }
}
