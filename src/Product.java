public class Product {
    protected String name;
    protected double price;
    protected int Inventory_Quantity;


    public Product(String name, double price, int quantity) {
        if (name == null || name.isEmpty() || price < 0 || quantity < 0) {
            throw new IllegalArgumentException("Invalid product attributes");
        }
        this.name=name;
        this.price=price;
        this.Inventory_Quantity=quantity;
    }

    public void reduceQuantity(int amount){
        if(amount>Inventory_Quantity){throw new IllegalArgumentException("Not enough stock");}
        Inventory_Quantity-=amount;
    }
    public boolean isOutOfStock(){return Inventory_Quantity<=0;}

    public String getName() {return name;}
    public double getPrice() {return price;}
    public int getQuantity() {return Inventory_Quantity;}

    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        this.price = price;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) throw new IllegalArgumentException("Quantity cannot be negative");
        this.Inventory_Quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }
}
