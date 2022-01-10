
public class BitwiseOperators {

    public static void main(String[] args) {

    and();
    or();
    xor();
    complement();

    }

    private static void and(){
        //booleans
        int x = 100;
        System.out.println("false & true: "+(false & --x == 99));
        System.out.println("Now x is decreased by 1, x is:"+x);
        //whereas with logical AND
        System.out.println("false && true: "+(false && --x == 99));
        System.out.println("Now x doesn't change, x is:"+x);

        //integers
        //1100100 in binary
        int z = 100;
        //1100101 in binary
        int y = 101;

        /* 1100100 is the result of
         * 1100100 & 1100101
         * which is 100 in binary
         * So that will print 100
         */
        System.out.println(z & y);
    }

    private static void or(){

        //booleans
        int a = 100;
        System.out.println("true | false: "+(true | --a == 99));
        System.out.println("Now a is decreased by 1, a is:"+a);
        //whereas with logical OR
        System.out.println("true | false: "+(true || --a == 99));
        System.out.println("Now a doesn't change, a is:"+a);

        //integers
        //1100100 in binary
        int z = 100;
        //1100101 in binary
        int y = 101;

        /* 1100101 is the result of
         * 1100100 | 1100101
         * which is 101 in binary
         * So that will print 101
         */
        System.out.println(z | y);
    }

    private static void xor(){

        //booleans
        System.out.println("true ^ false: "+(true ^ false));
        System.out.println("false ^ true: "+(false ^ true));
        System.out.println("false ^ false: "+(false ^ false));
        System.out.println("true ^ true: "+(true ^ true));

        //integers
        //1100100 in binary
        int z = 100;
        //1100101 in binary
        int y = 101;
        /* 0000001 is the result of
         * 1100100 ^ 1100101
         * which is 1 in binary
         * So that will print 1
         */
        System.out.println(z ^ y);
    }

    private static void complement(){

        //1100100 in binary
         int z = 100;
         //This will print -101 since
         //~1100100 in 2's complement is
        //1111111110011011
        System.out.println(~z);

    }
}
