import Factories.ProductFactory;
import Interface.IProduct;
import Model.*;
import Service.CheckoutService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        IProduct cheese = ProductFactory.createShippableExpirable("Cheese", 10.0, 5,0.1, LocalDate.now().plusDays(1));
        IProduct tv = ProductFactory.createShippable("TV", 500.0, 2,  1.5);
        IProduct scratchCard = ProductFactory.createBasic("Scratch Card", 2.0, 10);

        Customer customer = new Customer("Raghad", 1600.0);

        customer.getCart().addItem(cheese, 1);
        customer.getCart().addItem(cheese, 1);
        customer.getCart().addItem(tv, 2);
        customer.getCart().addItem(scratchCard, 3);

        CheckoutService checkoutService = new CheckoutService();
        checkoutService.checkout(customer);
    }
}
