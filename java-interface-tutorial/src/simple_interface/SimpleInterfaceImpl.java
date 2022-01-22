package simple_interface;

public class SimpleInterfaceImpl implements SimpleInterface{

    @Override
    public void printHelloInLanguage(String language) {
        switch (language){
            case "english":
                System.out.println("Hello");
                break;
            case "greek":
                System.out.println("Γειά");
                break;
        }
    }

    @Override
    public void sayHello() {
        SimpleInterface.super.sayHello();
        System.out.println("Default method overriden!");
    }

    public static void main(String[] args) {

        SimpleInterface simpleInterface = new SimpleInterfaceImpl();

        System.out.println("calling sayHello():");
        simpleInterface.sayHello();
        System.out.println();

        System.out.println("calling printHelloInLanguage():");
        simpleInterface.printHelloInLanguage("english");
        System.out.println();


        System.out.println("calling sayBye():");
        SimpleInterface.sayBye();
        System.out.println();

        System.out.println("calling sayByeMultipletimes():");
        SimpleInterface.sayByeMultipletimes();
    }
}
