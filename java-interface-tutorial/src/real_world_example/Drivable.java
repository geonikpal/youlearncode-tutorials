package real_world_example;

public interface Drivable {

    default void canBeDrivenOn(){
       System.out.println("Default is road");
    }

    void printNumberOfWheels();

    void printTypeOfFuel();

    static void sayHelloFrom(String type){
       System.out.println("Hello, I'm inside a(n) "+type);
    }
}
