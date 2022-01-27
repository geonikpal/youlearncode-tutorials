package Generic_Class;

public class GenericClassTest {
    public static void main(String[] args) {


        GenericClassEx<Integer> coinInt = new GenericClassEx<>(50);
        System.out.println("The class returns: " + coinInt.getData());


        GenericClassEx<String> coinStr = new GenericClassEx<>("Coins");
        System.out.println("The class returns: " + coinStr.getData());
    }
}

