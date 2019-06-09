package com.vpetkov.policyexpert.marketpricing.cashier;

import com.vpetkov.policyexpert.marketpricing.goods.Discount;
import com.vpetkov.policyexpert.marketpricing.goods.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a Supermarket cashier which role is to mark goods.
 */
public class Cashier {

    private final Map<String, Product> products;

    public Cashier() {
        this.products = new HashMap<>();
    }

    /**
     * Adds {@link Product} to list of goods
     *
     * @param product {@link Product}
     */
    public void add(Product product) {
        Product presentProduct = this.products.putIfAbsent(product.getName(), product);
        if (presentProduct != null) {
            this.products.put(product.getName(), presentProduct.increase(product));
        }
    }

    /**
     * Prints clients goods with their quantity and prices
     */
    public void print() {

        BigDecimal totalPrice = totalPrice();
        BigDecimal totalSavings = totalSavings();

        StringBuilder builder = new StringBuilder();

        products.values().stream()
                .forEach(product -> builder.append(product.printQuantityAndPrice()));

        builder.append("\n--------------------------------");
        builder.append("\nSub-total             " + Product.round(totalPrice).toString());
        builder.append("\n\nSavings");
        products.values().stream()
                .filter(product -> product instanceof Discount)
                .map(product -> ((Discount) product).printDiscount())
                .forEach(message -> builder.append(message));
        builder.append("\n--------------------------------");

        builder.append("\nTotal savings         -" + Product.round(totalSavings).toString());
        builder.append("\n--------------------------------");
        builder.append("\nTotal to Pay           " + Product.round(totalPrice.subtract(totalSavings)).toString());

        System.out.println(builder.toString());
    }

    private BigDecimal totalPrice() {
        return products.values().stream()
                .map(product -> product.totalPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal totalSavings() {
        return products.values().stream()
                .filter(product -> product instanceof Discount)
                .map(product -> ((Discount) product).discount())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
