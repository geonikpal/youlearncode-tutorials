public class PrefixVsPostfix {
    public static void main(String[] args) {

        int x = 100;

        int j = --x;
        // Now j has the new value of x
        // so it will print 99
        System.out.println(j);
        int k = x--;
        // Now k has the old value of x
        // so it will print 99
        System.out.println(k);
        // x is 98
        System.out.println(x);

    }
}
