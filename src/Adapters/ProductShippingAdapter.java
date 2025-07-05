package Adapters;

import Interface.IProduct;
import Interface.IShippable;

public class ProductShippingAdapter implements IShippable {
    private final IProduct product;
    private final int quantity;

    public ProductShippingAdapter(IProduct product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public String getName() {
        return product.getName();
    }
    public double getWeight() {
        return product.getWeight() * quantity;
    }

}
