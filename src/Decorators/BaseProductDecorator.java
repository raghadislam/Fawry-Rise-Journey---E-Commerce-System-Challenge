package Decorators;

import Interface.IProduct;

public class BaseProductDecorator implements IProduct {
    private final String name;
    private final double price;
    private int stock;

    public BaseProductDecorator(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    @Override
    public String getName() { return name; }

    @Override
    public boolean isExpired() { return false;}

    @Override
    public boolean isShippable() {
        return false;
    }

    @Override
    public double getWeight() { return 0.0; }

    @Override
    public void reduceQuantity(int amount) {
        stock -= amount;
    }

    @Override
    public boolean isStockInsufficient(int amount) { return stock < amount; }

    @Override
    public double getPrice() { return price; }

    @Override
    public int getStock() { return stock; }

}
