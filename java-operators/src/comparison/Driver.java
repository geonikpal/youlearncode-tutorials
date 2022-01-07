package comparison;

public class Driver {
    public static void main(String[] args) {
        Person person = new Person();
        Employee employee = new Employee();

        System.out.println("person instanceof Person: "+(person instanceof Person));
        System.out.println("person instanceof Employee: "+(person instanceof Employee));

        System.out.println("employee instanceof Person: "+(employee instanceof Person));
        System.out.println("employee instanceof Employee: "+(employee instanceof Employee));
    }
}
