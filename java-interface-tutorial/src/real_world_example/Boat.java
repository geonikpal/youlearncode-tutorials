package real_world_example;

public class Boat implements Drivable{

    @Override
    public void printNumberOfWheels() {
        System.out.println("A boat has no wheels");
    }

    @Override
    public void printTypeOfFuel() {
        System.out.println("Boat mainly uses gas and diesel");
    }

    @Override
    public void canBeDrivenOn() {
        System.out.println("Sea");
    }

    public static void main(String[] args) {
        Drivable boat = new Boat();
        boat.printNumberOfWheels();
        boat.printTypeOfFuel();
        boat.canBeDrivenOn();
    }

}
