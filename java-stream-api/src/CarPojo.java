import java.util.Objects;

public class CarPojo {
    private String brand;
    private String model;
    private int horsePower;
    private double price;

    public CarPojo(String brand, String model, int horsePower, double price) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarPojo)) return false;
        CarPojo carPojo = (CarPojo) o;
        return horsePower == carPojo.horsePower && Double.compare(carPojo.price, price) == 0 && Objects.equals(brand, carPojo.brand) && Objects.equals(model, carPojo.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, horsePower, price);
    }

    @Override
    public String toString() {
        return "CarPojo{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", horsePower=" + horsePower +
                ", price=" + price +
                '}';
    }
}
