import java.util.ArrayList;

public class CoinFlipsArrayListExampleClass {

    /* In main method, we repeat the same experiment 10 times. Notice how greatly ArrayList's size differs in each
    * attempt.*/
    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            int totalNumberOfAttempts = flipCoinForFifteenHeads();
            System.out.println("Experiment: " + (i + 1) + ". I got 15 Heads in a row by flipping the coin " + totalNumberOfAttempts + " times.");
        }
    }

    /* This method flips a coin as much as needed, until we get 15 Heads in a row.*/
    private static int flipCoinForFifteenHeads() {
        int numberOfConsecutiveHeads = 0; // used to count the consecutive Heads we got. If we get 15, we stop flipping.
        ArrayList<String> coinFlips = new ArrayList<String>(); // all coinflips so far.

        while(numberOfConsecutiveHeads != 15) {
            String coinFlip = Math.random() < 0.5 ? "Heads" : "Tails"; // 50/50 probability to get heads or tails

            if(coinFlip.equals("Heads")) {
                numberOfConsecutiveHeads += 1; // the Heads streak is still going on
            } else {
                numberOfConsecutiveHeads = 0; // the Heads streak was broken
            }

            coinFlips.add(coinFlip); // add attempt in our ArrayList
        }

        return  coinFlips.size(); // total size of the ArrayList is the total number of attempts we made
    }
}
