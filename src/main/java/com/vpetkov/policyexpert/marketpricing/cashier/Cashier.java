package com.vpetkov.policyexpert.marketpricing.cashier;

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
     * @return instance of current {@link Cashier}
     */
    public Cashier add(Product product) {
        Product presentProduct = this.products.putIfAbsent(product.getName(), product);
        if (presentProduct != null) {
            this.products.put(product.getName(), presentProduct.increase(product));
        }
        return this;
    }

    /**
     * Prints clients goods with their quantity and prices
     */
    public void print() {
        products.values().stream().forEach(product -> product.printQuantityAndPrice());
        BigDecimal totalPrice = products.values().stream()
                .map(product -> product.totalPrice())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("--------------------------------");
        System.out.println("Sub-total             " + totalPrice);
        System.out.println("\nSavings");
        products.values().stream().forEach(product -> product.printDiscount());
        System.out.println("--------------------------------");
        BigDecimal totalSavings = products.values().stream()
                .map(product -> product.discount())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total savings         -" + Product.round(totalSavings));
        System.out.println("--------------------------------");
        System.out.println("Total to Pay           " + Product.round(totalPrice.subtract(totalSavings)));

    }
}
