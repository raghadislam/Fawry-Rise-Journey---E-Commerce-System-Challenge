package Factories;

import Decorators.BaseProductDecorator;
import Decorators.ExpirableDecorator;
import Decorators.ShippableDecorator;
import Interface.IProduct;
import Utils.ValidatorUtil;

import java.time.LocalDate;

public class ProductFactory {

    public static IProduct createBasic(String name, double price, int quantity) {
        ValidatorUtil.validateProduct(name, price, quantity);
        return new BaseProductDecorator(name, price, quantity);
    }

    public static IProduct createShippable(String name, double price, int quantity, double weight) {
        ValidatorUtil.validateShippable(name, price, quantity, weight);
        return new ShippableDecorator(createBasic(name, price, quantity), weight);
    }

    public static IProduct createExpirable(String name, double price, int quantity, LocalDate expiry) {
        ValidatorUtil.validateProduct(name, price, quantity);
        ValidatorUtil.validateExpiry(expiry);
        return new ExpirableDecorator(createBasic(name, price, quantity), expiry);
    }

    public static IProduct createShippableExpirable(String name, double price, int quantity, double weight, LocalDate expiry) {
        ValidatorUtil.validateShippable(name, price, quantity, weight);
        ValidatorUtil.validateExpiry(expiry);
        return new ExpirableDecorator(createShippable(name, price, quantity, weight), expiry);
    }
}
