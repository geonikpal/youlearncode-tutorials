public class ExampleDynamicAdditionLoop {
    public static void main(String[] args) {
        System.out.println("Let's sum from 0 to 10");
        sumAndPrint(10);

        System.out.println("\nNow let's sum from 0 to 42");
        sumAndPrint(42);

        System.out.println("\nNow let's count to 42");
        reverseAddAndPrint(42);
    }

    // This method sums all numbers from 0 to our specified non-negative number and prints the result
    public static void sumAndPrint(int toNumber) {
        int result = 0;

        /* As you can see, the starting position can be whatever we want. There is no need to start from 0,
        because the first statement would be result = 0 + 0, which is unnecessary.
            * Starting expression: i = 1
            * Condition to check: as long as the i is less than our specified number
            * Increment: move to the next number
            * Statement: add current number to the result
         */
        for(int i = 1; i <= toNumber; i++) {
            result += i;
        }
        System.out.println("The sum from 0 to " + toNumber + " is " + result);
    }

    // This method sums all numbers from our specified negative number to 0 and prints the result
    public static void reverseAddAndPrint(int toNumber) {
        int result = 0;

        /* Here, we do the reverse process. We begin from our number and add the numbers in reverse. The result is the
        same as the above.
            * Starting expression: we start from our number
            * Condition to check: as long as the i is more than 0
            * Decrement: move to the next number, in reverse order
            * Statement: add current number to the result
         */
        for(int i = toNumber; i > 0; i--) {
            result += i;
        }
        System.out.println("The reverse sum from " + toNumber + " to 0 is " + result);
    }
}
