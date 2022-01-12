public class MethodOverloadingEx {
    public static void main(String args[]) {
        MethodOverloadingEx example = new MethodOverloadingEx();

        System.out.println(example.div(10, 5));

        System.out.println(example.div(10, 5, 4));

        System.out.println(example.div(10.5, 5.5,1.5));

    }
    public int div(int i,int j) {

        int result=i/j;
        return  result;
    }
    public int div(int i,int j,int f) {

        int result=(i/j)/f;
        return  result;
    }
    public double div(double i,double j,double f) {

        double result=(i/j)/f;
        return  result;
    }
}
