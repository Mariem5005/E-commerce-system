import java.util.List;

public class BasicShippingService implements ShippingService {
    private static final double FLAT_FEE = 10.0;

    @Override
    public void shipItems(Cart cart, List<Shippable> items) {
        System.out.println("** Shipment notice **");
        for (CartItem item : cart.getItems()) {
            if (item.getProduct() instanceof Shippable) {
                System.out.println(item.getQuantity() + "x " + item.getProduct().getName());
            }
        }
        double totalWeight = 0;
        for (CartItem item : cart.getItems()) {
            if (item.getProduct() instanceof Shippable) {
                totalWeight += ((Shippable) item.getProduct()).getWeight() * item.getQuantity();
            }
        }
        System.out.printf("Total package weight %.1fkg%n", totalWeight);
    }

    @Override
    public double calculateShippingFee(List<Shippable> items) {
        return FLAT_FEE;
    }
}