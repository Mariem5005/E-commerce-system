public class Product {
    protected String name;
    protected double price;


    public Product(String name, double price) {
        if (name == null || name.isEmpty() || price < 0) {
            throw new IllegalArgumentException("Invalid product attributes");
        }
        this.name=name;
        this.price=price;
    }

    public String getName() {return name;}
    public double getPrice() {return price;}
    public void setName(String name) {this.name = name;}
    public void setPrice(double price) {this.price = price;}

}
