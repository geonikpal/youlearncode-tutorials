import java.util.List;

public class ForLoop {

    public static void main(String[] args) {
        nestedLoops();
        forEach();
        System.out.println(isPalindrome("anna"));
        System.out.println(isPalindrome("kayak"));
        System.out.println(isPalindrome("deified"));
        System.out.println(isPalindrome("peep"));
        System.out.println(isPalindrome("level"));
        System.out.println(isPalindrome("hello"));
        System.out.println(isPalindrome("world"));
        System.out.println(isPalindrome("you"));

    }


    private static void nestedLoops(){

        outer: for (int i = 0; i < 3; i++) {
            inner: for (int j = 3; j >= 0; j--){
                if(j == 1) break outer;
                if(j == 2) continue;
                System.out.println("i is:"+ i + " j is:" + j);
            }
        }
    }

    public static void forEach(){
        int[] numbers = new int[]{1, 2, 3, 4, 5};
        for (int i : numbers) {
            System.out.println(i);
        }

        List<String> ylc = List.of("You", "Learn", "Code");
        for (String s: ylc) {
            System.out.println(s);
        }
    }

    public static boolean isPalindrome(String word) {
        for (
                int i = 0, j = word.length() - 1;
                i <=  word.length() / 2 || j >= word.length()/2;
                i++, j--
        ){
            if(word.charAt(i) != word.charAt(j)) return false;
        }
        return true;
    }
}
