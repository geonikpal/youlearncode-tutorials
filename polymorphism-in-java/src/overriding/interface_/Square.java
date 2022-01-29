package overriding.interface_;

public class Square implements Drawable{

    @Override
    public void printAreaFormula() {
        System.out.println("Length * Height");
    }

    @Override
    public void printName() {
        System.out.println("This is a square");
    }
}
