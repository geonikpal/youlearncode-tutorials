public class StaticMethodEx {

        static int add(int x, int y) {
            return x + y;
        }
        public static void main(String[] args) {

            int result = StaticMethodEx.add(5, 5);
            System.out.println(result);
        }

}
