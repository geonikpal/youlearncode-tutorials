public class PassByReferenceEx {
    int i = 10;
    public void call(PassByReferenceEx par) {
        par.i = par.i+20;
    }

    public static void main(String[] args) {

        PassByReferenceEx par = new PassByReferenceEx();
        System.out.println("Before call: " + par.i);


        par.call(par);
        System.out.println("After call: " + par.i);


    }
}
