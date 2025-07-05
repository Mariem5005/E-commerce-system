import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity_needed){
        items.add(new CartItem(product,quantity_needed));
    }
    public void addItem(CartItem item){
        items.add(item);
    }

    public void removeItem(Product product){
        items.removeIf(item -> item.getProduct().equals(product));
    }

    public double getSubtotal(){
        double total = 0;
        for(CartItem item : items){
            total+=item.getProduct().getPrice()*item.getQuantity();
        }
        return total;
    }

    public List<Shippable> getShippableItems(){
        return items.stream()
                .map(CartItem::getProduct)
                .filter(p -> p instanceof Shippable)
                .map(p -> (Shippable) p)
                .collect(Collectors.toList());
    }

    public List<CartItem> getItems() {
        return items;
    }
}
