public class TernaryOperator {

    public static void main(String[] args) {

        // x will be 10
        int x = true ? 10 : 20;
        // y will be 20
        int y = false ? 10 : 20;

        System.out.println(getRandomInt(0));
        System.out.println(getRandomInt(10));
    }

    // returns 0, if the input is 0,
    // returns a random number, if input is other than 0
    private static double getRandomInt(int x){
        return x == 0 ? 0 : Math.random();
    }
}
