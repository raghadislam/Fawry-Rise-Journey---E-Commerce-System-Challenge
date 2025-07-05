package Interface;

public interface IProduct {
    String getName();
    double getPrice();
    int getStock();
    boolean isExpired();
    boolean isShippable();
    double getWeight();
    boolean isStockInsufficient(int qty);
    void reduceQuantity(int amount);
}
