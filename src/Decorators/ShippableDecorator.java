package Decorators;

import Interface.IProduct;

public class ShippableDecorator implements IProduct {
    private final IProduct product;
    private final double weightPerUnit;
    public static final double costPerKg = 50.0;

    public ShippableDecorator(IProduct product, double weight) {
        this.product = product;
        this.weightPerUnit = weight;
    }

    @Override
    public boolean isShippable() {
        return true;
    }

    @Override
    public double getWeight() {
        return weightPerUnit;
    }

    // Delegate the rest
    @Override public String getName() { return product.getName(); }
    @Override public double getPrice() { return product.getPrice(); }
    @Override public int getStock() { return product.getStock(); }
    @Override public boolean isExpired() { return product.isExpired(); }
    @Override public void reduceQuantity(int qty) { product.reduceQuantity(qty); }
    @Override public boolean isStockInsufficient(int qty) { return product.isStockInsufficient(qty); }

}
