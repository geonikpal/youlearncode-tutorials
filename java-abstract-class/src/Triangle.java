public class Triangle extends Shape {

    private double firstSide;
    private double secondSide;
    private double base;
    private double height;

    protected Triangle(String name, double firstSide, double secondSide, double base, double height) {
        super(name);
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.base = base;
        this.height = height;
    }

    @Override
    protected double getArea() {
        return (base * height) / 2;
    }

    @Override
    protected double getPerimeter() {
        return firstSide + secondSide + base;
    }
}
