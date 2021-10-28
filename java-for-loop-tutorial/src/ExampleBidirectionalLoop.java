public class ExampleBidirectionalLoop {
    public static void main(String[] args) {
        checkPalindrome("anna"); // even length
        checkPalindrome("john");
        checkPalindrome("aba"); // odd length
        checkPalindrome("abc");
        checkPalindrome("d"); // single letter is palindrome to itself
        checkPalindrome("Pop"); // capitalization matters in our example. You can make it ignore cases

    }

    /* This method checks and prints whether a string is palindrome.
       A palindrome word reads the same backward as forward. */
    public static void checkPalindrome(String word) {

        // Because of the symmetry of palindrome words, we only need to check until the middle of the word
        int mid = word.length() / 2;

        /* The loop's expressions are a bit trickier here.
             * Starting expression: i = 0 for the beginning of the word, j = word.length() - 1 for the ending of the word.
             *                      Remember, indices are zero-indexed.
             * Condition to check: i must be on the first half of the word, j on the second half
             * Increment/decrement: i moves towards the middle in proper order, j in reverse order
             * Statement: explained below
        */

        for(int i = 0, j = word.length() - 1; i <= mid && j >= mid; i++, j--) {

            // If the characters in symmetrical places are different, then the word is not palindrome
            if(word.charAt(i) != word.charAt(j)) {
                System.out.println(word + " is not a palindrome");
                return; // Used to stop the loop, as well as the function
            }
        }

        // Nothing stopped us, so the word is palindrome
        System.out.println(word + " is a palindrome");
    }
}
