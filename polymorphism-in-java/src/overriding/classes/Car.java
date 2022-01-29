package overriding.classes;

public class Car {

    public final int maxSpeed = 200;

    protected void playSound(){
        System.out.println("Playing car.mp3...");
    }
}
