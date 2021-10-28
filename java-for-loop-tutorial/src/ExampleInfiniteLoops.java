import java.util.ArrayList;

public class ExampleInfiniteLoops {
    public static void main(String[] args) {
        infiniteLoopThatStops();
        System.out.println();
        infiniteLoopThatNeverStops();
    }

    public static void infiniteLoopThatStops() {
        int iterations = 0;
        double randomNumber = 0.0;
        for (;;) {

            // generate a random number
            randomNumber = Math.random();

            // increase iterations by 1
            iterations++;

            // exit infinite loop if the random number is less than 0.01
            if(randomNumber < 0.01) {
                break;
            }
        }

        // print the number and iterations it took to get that number
        System.out.println("Number is : " + randomNumber+ " Iterations : " + iterations);
    }

    public static void infiniteLoopThatNeverStops() {

        // create a dynamic ArrayList
        ArrayList<Double> arrayList = new ArrayList<Double>();

        // keep note of the current time
        long timestampStart = System.nanoTime();

        // a try block is used to catch the eventual OutOfMemoryError and perform the wanted actions
        try {
            for (;;) {
                double randomNumber = Math.random();

                // append the random number to the list. It doesn't matter if it's random
                arrayList.add(randomNumber);
            }
        } catch(OutOfMemoryError error) {
            // print stack trace of the error, as well as the time it took for it to happen (in seconds)
            error.printStackTrace();
            long timestampFinish = System.nanoTime();
            System.out.println("Time elapsed until OutOfMemoryError: "+ (timestampFinish - timestampStart));
        }
    }
}
