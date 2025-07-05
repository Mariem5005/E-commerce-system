public class InventoryService {
    public boolean isInStock(Product product, int quantity) {
        return product.getQuantity() >= quantity && !product.isOutOfStock();
    }

    public void updateStock(Product product, int quantity) {
        product.reduceQuantity(quantity);
    }
}