public class MathPow {

    public static void main(String[] args) {
        mathPowExamples();
        calculatePowerExamples();
    }


    private static void calculatePowerExamples(){
        System.out.println(calculatePower(2.5, 2));
        System.out.println(calculatePower(-5, 2));
        System.out.println(calculatePower(0, 2));
        System.out.println(calculatePower(5, 0));
        System.out.println(calculatePower(-5, 0));
        System.out.println(calculatePower(1000, 2));
        System.out.println(calculatePower(-2.5, 3));
        System.out.println(calculatePower(4, -1));
        System.out.println(calculatePower(64, -1));
    }

    private static double calculatePower(double base, int exponent){
        double result = 1;
        int abs = Math.abs(exponent);
        for(int i = 0; i < abs; i++){
            result *= base;
        }
        return exponent >= 0 ? result : 1/result;
    }

    private static void mathPowExamples(){
        //Negative base
        System.out.println("Negative Base: ");
        System.out.println(Math.pow(-5, -2));
        System.out.println(Math.pow(-5, 0));
        System.out.println(Math.pow(-5, 0.5));
        System.out.println(Math.pow(-5, 1));
        System.out.println(Math.pow(-5, 100));
        System.out.println(Math.pow(-5, Double.NaN));
        System.out.println(Math.pow(-5, Double.NEGATIVE_INFINITY));
        System.out.println(Math.pow(-5, Double.POSITIVE_INFINITY));

        //Zero Base
        System.out.println("Zero Base: ");
        System.out.println(Math.pow(0, -2));
        System.out.println(Math.pow(0, 0));
        System.out.println(Math.pow(0, 0.5));
        System.out.println(Math.pow(0, 1));
        System.out.println(Math.pow(0, 100));
        System.out.println(Math.pow(0, Double.NaN));
        System.out.println(Math.pow(0, Double.NEGATIVE_INFINITY));
        System.out.println(Math.pow(0, Double.POSITIVE_INFINITY));

        // 0 < Base < 1
        System.out.println("0 < Base < 1: ");
        System.out.println(Math.pow(0.2, -2));
        System.out.println(Math.pow(0.5, 0));
        System.out.println(Math.pow(0.5, 0.5));
        System.out.println(Math.pow(0.5 , 1));
        System.out.println(Math.pow(0.5 , 100));
        System.out.println(Math.pow(0.5 , Double.NaN));
        System.out.println(Math.pow(0.6 , Double.NEGATIVE_INFINITY));
        System.out.println(Math.pow(0.5 , Double.POSITIVE_INFINITY));
        // Base > 1
        System.out.println("Base > 1: ");
        System.out.println(Math.pow(6, -2));
        System.out.println(Math.pow(4, 0));
        System.out.println(Math.pow(100.5, 0.5));
        System.out.println(Math.pow(4 , 1));
        System.out.println(Math.pow(4 , 100));
        System.out.println(Math.pow(4 , Double.NaN));
        System.out.println(Math.pow(4 , Double.NEGATIVE_INFINITY));
        System.out.println(Math.pow(4 , Double.POSITIVE_INFINITY));
        // Base is NaN
        System.out.println("Base is NaN: ");
        System.out.println(Math.pow(Double.NaN, -2));
        System.out.println(Math.pow(Double.NaN, 0));
        System.out.println(Math.pow(Double.NaN, 0.5));
        System.out.println(Math.pow(Double.NaN , 1));
        System.out.println(Math.pow(Double.NaN , 100));
        System.out.println(Math.pow(Double.NaN , Double.NaN));
        System.out.println(Math.pow(Double.NaN , Double.NEGATIVE_INFINITY));
        System.out.println(Math.pow(Double.NaN , Double.POSITIVE_INFINITY));

        // Base is Negative infinity
        System.out.println("Base is -inf: ");
        System.out.println(Math.pow(Double.NEGATIVE_INFINITY, -2));
        System.out.println(Math.pow(Double.NEGATIVE_INFINITY, 0));
        System.out.println(Math.pow(Double.NEGATIVE_INFINITY, 0.5));
        System.out.println(Math.pow(Double.NEGATIVE_INFINITY , 1));
        System.out.println(Math.pow(Double.NEGATIVE_INFINITY , 100));
        System.out.println(Math.pow(Double.NEGATIVE_INFINITY , Double.NaN));
        System.out.println(Math.pow(Double.NEGATIVE_INFINITY , Double.NEGATIVE_INFINITY));
        System.out.println(Math.pow(Double.NEGATIVE_INFINITY , Double.POSITIVE_INFINITY));

        // Base is Positive infinity
        System.out.println("Base is +inf ");
        System.out.println(Math.pow(Double.POSITIVE_INFINITY, -2));
        System.out.println(Math.pow(Double.POSITIVE_INFINITY, 0));
        System.out.println(Math.pow(Double.POSITIVE_INFINITY, 0.5));
        System.out.println(Math.pow(Double.POSITIVE_INFINITY , 1));
        System.out.println(Math.pow(Double.POSITIVE_INFINITY , 100));
        System.out.println(Math.pow(Double.POSITIVE_INFINITY , Double.NaN));
        System.out.println(Math.pow(Double.POSITIVE_INFINITY , Double.NEGATIVE_INFINITY));
        System.out.println(Math.pow(Double.POSITIVE_INFINITY , Double.POSITIVE_INFINITY));
    }
}
