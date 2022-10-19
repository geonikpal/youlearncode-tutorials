public class Circle extends Shape {

    private static final double PI = 3.14;
    private final double radius;

    protected Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    protected double getArea() {
        return PI * Math.pow(radius, 2);
    }

    @Override
    protected double getPerimeter() {
        return 2 * PI * radius;
    }

}