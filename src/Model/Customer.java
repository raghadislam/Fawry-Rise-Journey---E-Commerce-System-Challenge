package Model;

import Interface.IProduct;
import Service.Cart;
import Service.ShippingService;
import Utils.FormatterUtil;

public class Customer {
    private final String name;
    private double balance;
    private Cart cart;


    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.cart = new Cart();
    }

    public void deductBalance(double amount) {
        this.balance -= amount;
    }
    public double getBalance() { return balance; }
    public String getName() { return name; }
    public Cart getCart() { return cart; }

    public void clearCart() {
        this.cart = new Cart();
    }
}
