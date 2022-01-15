package default_constructor;

public class PersonWithConstructors {

    private String name;
    private String surname;

    public PersonWithConstructors() {}

    public PersonWithConstructors(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public static void main(String[] args) {
        PersonWithConstructors person = new PersonWithConstructors();

    }
}
