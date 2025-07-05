# E-commerce System

This is a Java-based E-commerce System designed to demonstrate core object-oriented programming (OOP) principles and patterns, including encapsulation, inheritance, polymorphism, and composition. It features a modular design with support for multiple product types, inventory management, customer shopping carts, and extensible payment and shipping strategies.

## Features

- **Product Hierarchy**: Supports expirable, non-expirable, and shippable products.
- **Inventory Management**: Centralized inventory system for managing product stock.
- **Customer and Cart**: Each customer has a unique cart for managing their selected items.
- **Order and Checkout**: Processes cart checkout, calculates totals, handles payments, and updates inventory.
- **Extensible Design**: Easy to add new product types, shipping methods, or payment strategies using interfaces and inheritance.

## Main Classes

- `Product`: Base class for all products.
- `ExpirableProduct`, `NonExpirableProduct`, `ShippableProduct`: Specialized product types with additional behavior.
- `Inventory`: Manages product stock and updates quantities.
- `Customer`: Represents a user with a unique cart and account balance.
- `Cart` & `CartItem`: Manage products selected by a customer and their quantities.
- `Order`: Represents a finalized purchase.

## Example Usage

```java
ShippableProduct phone = new ShippableProduct("Phone", 500, 0.4);
ExpirableProduct milk = new ExpirableProduct();
milk.setName("Milk");
milk.setPrice(2.5);
inventory.addProduct(milk,10); //add product milk to inventory with quantity 10
milk.setExpiryDate(LocalDate.now().plusDays(5));

Customer customer = new Customer("Alice", 1000);

Cart cart = customer.getCart();
CartItem item1=new CartItem(milk);
item1.setQuantity(9); //quantity needed to bought by customer
cart.addItem(item1);
cart.addItem(phone, 1);

// Proceed to checkout...
```

## Design Principles

- **Encapsulation**: Product and inventory data are managed via dedicated classes.
- **Abstraction**: Interfaces for product types abstract away implementation details.
- **Inheritance**: Product subclasses extend base functionality.
- **Polymorphism**: Cart and inventory interact with products through their base type/interface.
- **Composition**: Cart contains cart items; inventory contains products with quantities.

## Getting Started

1. Clone the repository:
   ```sh
   git clone https://github.com/Mariem5005/E-commerce-system.git
   ```
2. Open the project in your Java IDE.
3. Run the `Main` class or your test cases.

## Extending the System

- Add new product types by subclassing `Product`.
- Implement new payment or shipping strategies via interfaces.
- Customize customer or order logic as needed.

