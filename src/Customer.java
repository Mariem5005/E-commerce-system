public class Customer {
    String name;
    double balance;

    public Customer(String name, double balance) {
        if (name == null || name.isEmpty() || balance < 0){
            throw new IllegalArgumentException("Invalid customer attributes");}
        this.name = name;
        this.balance = balance;
    }
    public void deductBalance(double amount){if (amount > balance) throw new IllegalArgumentException("Insufficient balance");
        balance -= amount;}
    public boolean hasSufficientBalance(double amount){return balance >= amount;}
    public double getBalance(){return balance;}
    public String getName() {return name;}
    public void setBalance(double balance) {
        if (balance < 0) throw new IllegalArgumentException("Balance cannot be negative");
        this.balance = balance;
    }

    // Setter for name (optional, if you want to allow name change)
    public void setName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Name cannot be null or empty");
        this.name = name;
    }
}
