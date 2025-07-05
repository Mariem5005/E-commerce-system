import java.util.HashMap;
import java.util.Map;

public class InventoryService {
    private Map<Product, Integer> stock = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        if (product == null || quantity < 0) {
            throw new IllegalArgumentException("Invalid inventory addition");
        }
        stock.put(product, quantity);
    }

    public int getQuantity(Product product) {
        return stock.getOrDefault(product, 0);
    }

    public void addStock(Product product, int amount) {
        if (product == null || amount < 0) {
            throw new IllegalArgumentException("Invalid stock addition");
        }
        stock.put(product, getQuantity(product) + amount);
    }

    public void removeStock(Product product, int amount) {
        int current = getQuantity(product);
        if (product == null || amount < 0 || amount > current) {
            throw new IllegalArgumentException("Invalid stock removal");
        }
        stock.put(product, current - amount);
    }

    // Optional: check if enough stock is available
    public boolean isInStock(Product product, int requested) {
        return getQuantity(product) >= requested;
    }
}