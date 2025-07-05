public class CheckoutService {
    private ShippingService shippingService;
    private PaymentService paymentService;
    private InventoryService inventoryService;

    public CheckoutService(ShippingService shippingService, PaymentService paymentService, InventoryService inventoryService) {
        this.shippingService = shippingService;
        this.paymentService = paymentService;
        this.inventoryService = inventoryService;
    }

    public boolean checkout(Customer customer, Cart cart) {
        // Validate stock and expiry
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            if (!inventoryService.isInStock(product, item.getQuantity()))
                throw new IllegalStateException("Product out of stock: " + product.getName());
            if (product instanceof ExpirableProduct) {
                if (((ExpirableProduct) product).isExpired())
                    throw new IllegalStateException("Product expired: " + product.getName());
            }
        }

        double subtotal = cart.getSubtotal();
        double shipping = shippingService.calculateShippingFee(cart.getShippableItems());
        double total = subtotal + shipping;

        if (!customer.hasSufficientBalance(total))
            throw new IllegalStateException("balance less than subtotal: " + total);

        // Payment
        if (!paymentService.processPayment(customer, total))
            throw new IllegalStateException("Payment failed");

        // Update inventory
        for (CartItem item : cart.getItems()) {
            inventoryService.updateStock(item.getProduct(), item.getQuantity());
        }

        // Ship items
        shippingService.shipItems(cart,cart.getShippableItems());
        return true;
    }
}