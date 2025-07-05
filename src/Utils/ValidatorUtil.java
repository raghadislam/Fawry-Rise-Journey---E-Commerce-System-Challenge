package Utils;
import java.time.LocalDate;

public class ValidatorUtil {
    private static void validateName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Product name cannot be null or empty");
    }

    private static void validatePrice(double price) {
        if (price < 0)
            throw new IllegalArgumentException("Price must be non-negative");
    }

    private static void validateQuantity(int quantity) {
        if (quantity < 0)
            throw new IllegalArgumentException("Quantity must be non-negative");
    }

    private static void validateWeight(double weight) {
        if (weight <= 0)
            throw new IllegalArgumentException("Weight must be greater than zero");
    }

    public static void validateExpiry(LocalDate expiry) {
        if (expiry == null) throw new IllegalArgumentException("Expiry date cannot be null");
    }

    public static void validateProduct(String name, double price, int quantity) {
        validateName(name);
        validatePrice(price);
        validateQuantity(quantity);
    }

    public static void validateShippable(String name, double price, int quantity, double weight) {
        validateProduct(name, price, quantity);
        validateWeight(weight);
    }

}
