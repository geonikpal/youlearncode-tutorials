package real_world_example;

public class Car implements Drivable{

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void printNumberOfWheels() {
        System.out.println("Car has 4 wheels");
    }

    @Override
    public void printTypeOfFuel() {
        System.out.println("Car mainly uses Gas");
    }

    public void printColor(){
        System.out.println("The color of the car is "+color);
    }

    public static void main(String[] args) {

        Drivable car = new Car();

        //This won't compile
//         car.setColor("red");
        //neither this
        // car.printColor()
        car.printNumberOfWheels();
        car.printTypeOfFuel();
        car.canBeDrivenOn();
        Drivable.sayHelloFrom("car");

        Car car1 =  new Car();
        car1.setColor("red");
        car1.printColor();
    }
}
