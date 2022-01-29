package overriding.abstract_class;


public class FastCar extends Car {

    protected final int maxSpeed = 350;

    @Override
    protected void playSound(){
        System.out.println("Playing fastCar.mp3...");
    }
}
