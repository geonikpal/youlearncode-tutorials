public class UnaryOperatorExample {

    public static void main(String[] args) {

        //++variable operator
        int x = 100;
        // This increments x by one and returns the new value
        // 101
         int j = ++x;
        //Now both j and x have the same value
        System.out.println(j == x);

        //--variable operator
        int y = 100;
        // This increments x by one and returns the new value
        // 99
        int k = --y;
        //Now both j and x have the same value
        System.out.println(y == k);

        //!variable operator
        boolean flag = false;
        boolean newFlag = !flag;
        // This will print true
        System.out.println(newFlag);

        //~ operator
        int z = 100;
        int w = -z-1;

        int newVar = ~z;
        System.out.println(w);
        System.out.println(newVar == w);

        // +variable between non-arithmetic variables
        String hello = "Hello";
        String space = " ";
        String world = "world!";
        String helloWorld = hello + space + world;
        // This concatenates the strings
        System.out.println(helloWorld);

    }

}
