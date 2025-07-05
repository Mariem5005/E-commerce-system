public class CreditPayment implements PaymentService{
    @Override
    public boolean processPayment(Customer customer, double amount) {
        if (customer.hasSufficientBalance(amount)) {
            customer.deductBalance(amount);
            return true;
        }
        return false;
    }
}
