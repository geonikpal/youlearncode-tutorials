package default_constructor;

public class Person {

    private String name;
    private String surname;

    public static void main(String[] args) {
        // This is completely legal, the default
        // constructor will be created automatically
        Person person = new Person();
        person.name = "John";
        person.surname = "Smith";

    }
}
