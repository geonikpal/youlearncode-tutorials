public abstract class Shape {


    static int hello(){
        return 2;
    }
    protected String name;

    protected Shape(String name) {
        this.name = name;
    }

    protected abstract double getArea();

    protected abstract double getPerimeter();

    protected void printName(){
        System.out.println(name);
    }
    
}