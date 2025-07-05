package Model;

import Interface.IProduct;

public class CartItem {
    private final IProduct product;
    private int quantity;

    public CartItem(IProduct product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return quantity * product.getPrice();
    }
    public IProduct getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void increaseQuantity(int amount) { this.quantity += amount; }
}
