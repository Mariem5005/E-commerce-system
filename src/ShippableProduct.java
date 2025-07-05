public class ShippableProduct extends NonExpirableProduct implements Shippable {
    private double weight;
    public ShippableProduct(String name, double price, double weight) {
        super(name, price);
        if (weight <= 0) throw new IllegalArgumentException("Weight must be > 0");
        this.weight = weight;
    }
    @Override
    public double getWeight() {return weight;}
}
