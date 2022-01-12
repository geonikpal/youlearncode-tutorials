package Overriding_example;

public class Test {

    public static void main(String args[]){

        Parent ob1 = new Parent();
        ob1.method();

        Parent ob2 = new Child();
        ob2.method();
    }
}
