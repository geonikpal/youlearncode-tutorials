
public class Person {

    private String name;
    private String surname;
    private int age;

    public Person() {}

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    private void sayHello(String name){
        System.out.println("Hello, I'm " + name);
    }

    private void sayHello(String name, int age){
        System.out.println("Hello, I'm " + name + ", and I'm " + age + "year(s) old.");
    }

    //This will not compile
//    private String sayHello(String name){
//        return "Hello, I'm " + name;
//    }

// This will not compile
//    private void sayHello(String surname){
//        System.out.println("Hello, I'm " + surname);
//    }



    public static void main(String[] args) {
        Person unknown = new Person();
        Person john = new Person("John", "Smith");
        Person jane = new Person("Jane", "Doe", 25);
        john.sayHello("John", 30);
        jane.sayHello("Jane");
    }


}
