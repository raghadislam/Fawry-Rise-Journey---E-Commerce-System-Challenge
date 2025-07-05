package Service;

import Model.CartItem;
import Model.Customer;
import Interface.IProduct;
import Utils.FormatterUtil;


public class CheckoutService {
    private final ShippingService shippingService = new ShippingService();

    public void checkout(Customer customer) {
        Cart cart = customer.getCart();

        if (cart.isEmpty()) throw new RuntimeException("Cart is empty");

        for (CartItem item : cart.getItems()) {
            if (item.getProduct().isExpired()) throw new RuntimeException("Product is expired: " + item.getProduct().getName());
            if (item.getProduct().isStockInsufficient(item.getQuantity()))
                throw new RuntimeException("Insufficient stock for: " + item.getProduct().getName());
        }

        double subtotal = cart.getSubtotal();
        double shipping = cart.getShippingFees();
        double total = subtotal + shipping;

        if (customer.getBalance() < total)
            throw new RuntimeException("Insufficient balance");

        customer.deductBalance(total);
        System.out.println("********* Checkout receipt **********");

        for (CartItem item : cart.getItems()) {
            IProduct product = item.getProduct();
            System.out.printf("%-2dx %-15s %8.2f EGP\n", item.getQuantity(), product.getName(), item.getQuantity()*product.getPrice());
            product.reduceQuantity(item.getQuantity());
        }

        if (!cart.getShippableItems().isEmpty()) {
            shippingService.ship(cart.getShippableItems());
        }

        System.out.println("*************************************");
        System.out.println("Subtotal: " + FormatterUtil.formatMoney(subtotal));
        System.out.println("Shipping: " + FormatterUtil.formatMoney(shipping));
        System.out.println("Total Paid: " + FormatterUtil.formatMoney(total));
        System.out.println("Remaining Balance: " + FormatterUtil.formatMoney(customer.getBalance()));
        System.out.println("*************************************");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Date: " + FormatterUtil.formatDateTimeNow());

        customer.clearCart();
    }
}

