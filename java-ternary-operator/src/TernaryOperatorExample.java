public class TernaryOperatorExample {
    public static void main(String[] args) {
        System.out.println(abs(5));
        System.out.println(abs(-5));
        printPositiveness(10);
        printPositiveness(0);
        printPositiveness(-10);
        checkNumber(5);
        checkNumber(-5);
    }


    public static double abs(double x){
        return x >= 0 ? x : -x;
    }

    public static void printPositiveness(int x){
        String xString = x >= 0 ?
               x == 0 ? "x is zero" : "x is greater than zero"
                : "x is negative";
        System.out.println(xString);
    }

    public static int checkNumber(int x){
        if (x >= 0){
            return x;
        }
        else {
            throw new IllegalArgumentException("The number cannot be negative");
        }
    }
}
