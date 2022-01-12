import java.util.Scanner;

public class ExceptionsInMethodsEx {

        public static int method() throws Exception {

            Scanner myObj = new Scanner(System.in);
            System.out.println("Give me a number between 1 and 100");

            int var = myObj.nextInt();

            if(var>100 || var<1) {
                throw new Exception();
            }
            return var;
        }

        public static void main(String args[]) throws Exception {
            try {
                int res = method();
                System.out.println("The result is: "+res);
            }
            catch(Exception e) {
                System.out.println("The exception was handled!");
            }
        }
}
