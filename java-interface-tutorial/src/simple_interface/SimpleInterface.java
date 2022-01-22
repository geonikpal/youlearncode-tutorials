package simple_interface;

public interface SimpleInterface {

    int NUMBER_OF_TIMES = 5;

    void printHelloInLanguage(String language);

    default void sayHello(){
        System.out.println("Hello world");
    }

    static void sayBye(){
        System.out.println("Bye world");
    }

    static void sayByeMultipletimes(){
        for (int i = 0; i <NUMBER_OF_TIMES ; i++) {
            sayBye();
        }

    }

}
