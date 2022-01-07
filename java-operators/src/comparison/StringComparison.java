package comparison;

public class StringComparison {

    public static void main(String[] args) {

        String hello = "Hello";
        // This string is now in the String pool

        String hello1 = "Hello";
        // The hello1 variable just
        // points to the same reference as of hello variable

        // This will print true since the reference is compared
        System.out.println("hello == hello1? "+(hello == hello1));
        // What if we force the creation of a new reference?
        String hello2 = new String("Hello");
        // This will be false even though the string is the same
        System.out.println("hello2 == hello? "+(hello2 == hello));
        // This will be true, as expected
        System.out.println("hello2.equals(hello)? "+hello2.equals(hello));

    }
}
