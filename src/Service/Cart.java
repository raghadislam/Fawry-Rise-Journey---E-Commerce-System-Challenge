package Service;

import Adapters.ProductShippingAdapter;
import Decorators.ShippableDecorator;
import Interface.IProduct;
import Interface.IShippable;
import Model.*;

import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Cart {
    private List<CartItem> items = new ArrayList<>();
    private final Map<IProduct, CartItem> itemMap = new LinkedHashMap<>();

    public void addItem(IProduct product, int quantity) {
        if(product.isExpired())
            throw new RuntimeException("Cannot add expired product: " + product.getName());
        if(product.isStockInsufficient(quantity))
            throw new RuntimeException("There is no enough stock for: " + product.getName());

        if (itemMap.containsKey(product)) {
            CartItem existing = itemMap.get(product);
            existing.increaseQuantity(quantity);
        } else {
            itemMap.put(product, new CartItem(product, quantity));
        }
        items.add(new CartItem(product, quantity));
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getSubtotal() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public double getShippingFees() {
        return getShippableItems().stream().mapToDouble(IShippable::getWeight).sum() * ShippableDecorator.costPerKg;
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(itemMap.values());
    }

    public List<IShippable> getShippableItems() {
        List<IShippable> ShippableItems = new ArrayList<>();

        for(CartItem item : items) {
            IProduct product = item.getProduct();
            if(product.isShippable()) {
                ShippableItems.add(new ProductShippingAdapter(product, item.getQuantity()));
            }
        }
        return ShippableItems;
    }

}
