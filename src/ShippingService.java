import java.util.List;

public interface ShippingService {
    void shipItems(Cart cart,List<Shippable> items);
    double calculateShippingFee(List<Shippable> items);
}
