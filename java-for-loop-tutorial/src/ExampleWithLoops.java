public class ExampleWithLoops {
    public static void main(String[] args) {

        // Declare our integer array with 10 elements
        int[] myNumbers = {2, 44, 5, 0, -3 ,33, 11, 1, 2, 776};

        /* For every element, print its position and value, using a for loop.
            * Starting expression: i = 0, or the first index of our array
            * Condition to check: as long as the i is less than the length of the array
            * Increment: move to the next element
            * Statement: print our message
        * */
        for(int i = 0; i < myNumbers.length; i++) {
            System.out.println("My position is " + i + " and my number is " + myNumbers[i]);
        }
    }
}
