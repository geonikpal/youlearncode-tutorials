public class PassByValueEx {

    int i = 10;
  public void call(int i) {
        i = i+10;
    }

    public static void main(String[] args) {

        PassByValueEx eg = new PassByValueEx();
        System.out.println("Before call: " + eg.i);


        eg.call(30);
        System.out.println("After call: " + eg.i);


    }
}
