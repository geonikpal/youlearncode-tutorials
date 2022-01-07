package comparison;

public class ComparisonOperators {

    public static void main(String[] args) {

        // greater than and less than
        System.out.println("5 > 10: "+ (5 > 10));
        System.out.println("5 < 10: "+ (5 < 10));
        System.out.println();

        // With chars
        // the ASCII code will be compared
        System.out.println("'A' numeric value is "+Character.getNumericValue('A'));
        System.out.println("'B' numeric value is "+Character.getNumericValue('B'));
        System.out.println("A > B: "+('A' > 'B'));
        System.out.println();

        //greater or equal
        System.out.println("5 >= 10: "+ (5 >= 10));
        System.out.println("5 <= 10: "+ (5 <= 10));
        System.out.println();
        // equality
        System.out.println("5 == 10: "+ (5 == 10));
        System.out.println("5 == 5: "+ (5 == 5));
        System.out.println();
        // inequality
        System.out.println("5 != 10: "+ (5 == 10));
        System.out.println("5 != 5: "+ (5 == 5));
        System.out.println();
        System.out.println(String.class instanceof Object);

    }
}
