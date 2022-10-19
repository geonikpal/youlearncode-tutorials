public class Main {

    public static void main(String[] args) {
        Shape circleA = new Circle("A", 5);
        Shape triangleA = new Triangle("A", 2, 4, 5, 4);
        System.out.println(circleA.getArea());
        System.out.println(circleA.getPerimeter());
        System.out.println(triangleA.getArea());
        System.out.println(triangleA.getPerimeter());

        Shape square = new Shape("A Square with side == 5") {

            @Override
            protected double getArea() {
                return 5 * 5;
            }

            @Override
            protected double getPerimeter() {
                return 5 * 4;
            }
        };

        System.out.println(square.getPerimeter());
        System.out.println(square.getArea());
    }
}
