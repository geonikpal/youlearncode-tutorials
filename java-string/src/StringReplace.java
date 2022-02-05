public class StringReplace {
    public static void main(String[] args) {
        replace();
        System.out.println();
        replaceWithRegex();
    }


    static void replace(){
        String clh  = "Code Learn Hub";
        clh =  clh.replace('e', 'a');
        System.out.println(clh);

        String hello = "Hello world and Hello world";
        hello = hello.replace("Hello", "Bye");
        System.out.println(hello);
    }

    static void replaceWithRegex(){
        String clh  = "Code 7Learn4 Hub9";
        clh = clh.replaceAll("[0-9]", "5");
        System.out.println(clh);

        String hello = "Hello15 world and Hello world50";
        hello = hello.replaceFirst("\\d+", "100");
        System.out.println(hello);
    }
}
