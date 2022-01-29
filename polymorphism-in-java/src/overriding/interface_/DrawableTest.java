package overriding.interface_;

public class DrawableTest {
    public static void main(String[] args) {
        Drawable square = new Square();
        square.printName();
        square.printAreaFormula();

        Drawable circle = new Circle();
        circle.printName();
        circle.printAreaFormula();
    }
}
