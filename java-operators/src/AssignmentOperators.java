import java.util.Arrays;
import java.util.List;

public class AssignmentOperators {

    public static void main(String[] args) {

        System.out.println(calculateSum(Arrays.asList(5, 76, 98, 1, -100)));

        System.out.println(calculatePower(2,-2));
        System.out.println(calculatePower(2,8));
        System.out.println(calculatePower(2,0));
    }

    /**
     *
     * @param numbers A list of numbers
     * @return The sum of the numbers
     */
    private static int calculateSum(List<Integer> numbers){
        int sum = 0;
        for(int number : numbers){
            sum += number;
        }
        return sum;
    }

    /**
     *
     * @param base The base
     * @param exponent The exponent
     * @return base^exponent
     */
    private static double calculatePower(double base, int exponent){
        double result = 1;
        int abs = Math.abs(exponent);
            for(int i = 0; i < abs; i++){
                result *= base;
            }
        return exponent >= 0 ? result : 1/result;
    }


}
