public class ExampleEnhancedLoop {
    public static void main(String[] args) {

        // Declare our integer array with 10 elements
        int[] myNumbers = {2, 44, 5, 0, -3 ,33, 11, 1, 2, 776};

        /* Print every element in the array.
         * arrayType: int, type of elements in the array
         * nameOfVariable: number, naming the current element
         * nameOfArray: myNumbers, the array to iterate
         * Statement: print our message
         * */
        for(int number: myNumbers) {
            System.out.println("My number is " + number);
        }
    }
}