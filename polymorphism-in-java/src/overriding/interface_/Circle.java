package overriding.interface_;

public class Circle implements Drawable{
    @Override
    public void printAreaFormula() {
        System.out.println("π * Radius ^ 2");
    }

    @Override
    public void printName() {
        System.out.println("This is a circle");
    }
}
