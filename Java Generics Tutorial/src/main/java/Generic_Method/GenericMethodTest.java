package Generic_Method;

public class GenericMethodTest {
    public static void main(String[] args) {

        GenericMethodEx ob = new GenericMethodEx();

        ob.<String>coinMethod("50");

        ob.<Integer>coinMethod(30);
    }
}
