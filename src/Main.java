import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        InventoryService inventory = new InventoryService();

        //ExpirableProduct milk = new ExpirableProduct("Milk", 2.5, 10, LocalDate.now().plusDays(5));
        ShippableProduct phone = new ShippableProduct("Phone", 500, 0.4);
        ExpirableProduct milk = new ExpirableProduct();
        milk.setName("Milk");
        milk.setPrice(2.5);
        inventory.addProduct(milk,10);
        inventory.addStock(phone,10);
        milk.setExpiryDate(LocalDate.now().plusDays(5));

        Customer customer = new Customer("Alice", 1000);
        Cart cart = customer.getCart();

        CartItem item1= new CartItem(milk);
        item1.setQuantity(9);
        //cart.addItem(milk, 2);
        cart.addItem(item1);

        cart.addItem(phone, 1);

        ShippingService shippingService = new BasicShippingService();
        PaymentService paymentService = new CreditPayment();

        CheckoutService checkout = new CheckoutService(shippingService, paymentService, inventory);

        double subtotal = cart.getSubtotal();
        double shipping = shippingService.calculateShippingFee(cart.getShippableItems());
        double total = subtotal + shipping;

        // Checkout and print shipment notice
        try {
            checkout.checkout(customer, cart);

            // Receipt output
            System.out.println("** Checkout receipt **");
            for (CartItem item : cart.getItems()) {
                String prodType = item.getProduct().getName().split(" ")[0];
                System.out.println(item.getQuantity() + "x " + prodType + " " + (double)item.getProduct().getPrice());
            }
            System.out.println("----------------------");
            System.out.println("Subtotal " + (double)subtotal);
            System.out.println("Shipping " + (double)shipping);
            System.out.println("Amount " + (double)total);

        } catch (Exception e) {
            System.err.println("Checkout failed: " + e.getMessage());
        }
        System.out.println("Checkout successful. Remaining balance: $" + customer.getBalance());
    }
}