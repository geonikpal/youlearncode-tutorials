package overriding.classes;

public class FastCar extends Car {

    protected final int maxSpeed = 350;

    @Override
    protected void playSound(){
        System.out.println("Playing fastCar.mp3...");
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.playSound();
        System.out.println(car.maxSpeed);

        Car fastCar = new FastCar();
        System.out.println(fastCar.maxSpeed);
        fastCar.playSound();

        FastCar fastCar1 = new FastCar();
        System.out.println(fastCar1.maxSpeed);
    }

}
