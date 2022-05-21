import java.util.function.Supplier;

public class Person {

    private String name;
    private int age;

    public static void main(String[] args) {
        Supplier<Person> personWithName = Person::new;
    }

}
