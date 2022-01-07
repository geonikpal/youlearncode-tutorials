
public class LogicalOperators {
    public static void main(String[] args) {

        if (true && 5>0)
            System.out.println("true");
        else
            System.out.println(false);

        if (false && 5>0)
            System.out.println(true);
        else
            System.out.println(false);

        if (true || 5>0)
            System.out.println("true");
        else
            System.out.println(false);

        if (false || 5>0)
            System.out.println(true);
        else
            System.out.println(false);
    }
}
