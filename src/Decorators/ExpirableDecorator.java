package Decorators;

import Interface.IProduct;

import java.time.LocalDate;

public class ExpirableDecorator implements IProduct {
    private final IProduct product;
    private final LocalDate expiryDate;

    public ExpirableDecorator(IProduct product, LocalDate expiryDate) {
        this.product = product;
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override public String getName() { return product.getName(); }
    @Override public double getPrice() { return product.getPrice(); }
    @Override public int getStock() { return product.getStock(); }
    @Override public boolean isShippable() { return product.isShippable(); }
    @Override public double getWeight() { return product.getWeight(); }
    @Override public void reduceQuantity(int amount) { product.reduceQuantity(amount); }
    @Override public boolean isStockInsufficient(int amount) { return product.isStockInsufficient(amount); }
}
