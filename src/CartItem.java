public class CartItem {
    private Product product;
    private int quantity_needed;
    public CartItem(Product product, int quantity) {
        if (product == null || quantity <= 0){
            throw new IllegalArgumentException("Invalid cart item");}
        this.product = product;
        this.quantity_needed = quantity;
    }
    public CartItem(Product product) {
        this(product, 1);
    }

    public Product getProduct() {return product;}
    public int getQuantity() {return quantity_needed;}

    public void setQuantity(int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive");
        this.quantity_needed = quantity;
    }

    public void setProduct(Product product) {
        if (product == null) throw new IllegalArgumentException("Product cannot be null");
        this.product = product;
    }
}
