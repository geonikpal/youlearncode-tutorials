public class ReplaceExamples {

    public static void main(String[] args) {
        replaceString();
        replaceChar();
        replaceAll();
        replaceFirst();
    }

    static void replaceChar(){
        String clh  = "Code Learn Hub";
        clh =  clh.replace('e', 'a');
        System.out.println(clh);
    }

    static void replaceString(){
        String hello = "Hello world and Hello world";
        hello = hello.replace("Hello", "Bye");
        System.out.println(hello);
    }

    static void replaceAll(){
        String clh  = "Code 7Learn4 Hub9";
        clh = clh.replaceAll("[0-9]", "5");
        System.out.println(clh);
    }

    static void replaceFirst(){
        String hello = "Hello15 world and Hello world50";
        hello = hello.replaceFirst("\\d+", "100");
        System.out.println(hello);
    }

}