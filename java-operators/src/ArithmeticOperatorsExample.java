
public class ArithmeticOperatorsExample {
    public static void main(String[] args) {
//        plusMinus();
//        ints();
        doubles();



    }

    public static void plusMinus(){
        int x = 5;
        x = x + 10;
        System.out.println(x);
        int j = 20;
        j = j - 5;
        System.out.println(j);
    }

    public static void ints(){
        // Working with ints
        int x = 20;
        x = x * 5;
        System.out.println(x);
        // You can't do that without casting to int
        // x = x * 5.5;
        x = (int) (x * 5.5);
        System.out.println(x);
        // You can however create a new double to store the result
        double res = x * 3.95;
        System.out.println(res);

        int z = 20;
        // Quotient
        int quotienInt = z / 3;
        System.out.println("Quotient is: "+quotienInt);
        //Remainder
        int remainderInt = z % 3;
        System.out.println("Remainder is: "+remainderInt);
    }

    public static void doubles(){
        // Working with doubles
        double y = 30.2;
        y = y * 3.2;
        System.out.println(y);

        // Double division
        double a = 5.2;
        double quotientDouble = 5.2/3;
        double remainderDouble = 5.2 % 3.2;
        System.out.println(quotientDouble);
        System.out.println(remainderDouble);
    }
}
