
public class ShiftOperators {
    public static void main(String[] args) {

        // Is like 100 * 2^2 = 100*4 = 400
         System.out.println(100<<2);

        // Is like 33 * 2^3 = 33*8 = 264
        System.out.println(33<<3);

        // Is like 100 / 2^2 = 100*4 = 400
        System.out.println(100>>2);

        // Is like 33 / 2^3 = 33/8 = 4
        System.out.println(33>>3);

        // This will print 25
        System.out.println(100>>2);
        // This will also print 25
        System.out.println(100>>>2);
        // This will print -25
        System.out.println(-100>>2);
        // This will print 1073741799
        System.out.println(-100>>>2);
    }
}
