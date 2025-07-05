import java.time.LocalDate;

public class ExpirableProduct extends Product implements Expirable {
    private LocalDate expiryDate;

    public ExpirableProduct() {
        super("Unnamed", 0.01, 0);
        this.expiryDate = null;
    }
    public ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }
    public LocalDate getExpiryDate() {return expiryDate;}
}
