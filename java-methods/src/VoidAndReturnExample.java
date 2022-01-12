public class VoidAndReturnExample {

    public static void firstMethod() {
        System.out.println("This is a void method.\n");
    }
    public static String secondMethod() {
        String str="This is a return type method.";
        return str;
    }

    public static void main(String args[]){
        firstMethod();
       System.out.println(secondMethod());
    }
}
