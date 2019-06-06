package com.vpetkov.policyexpert.marketpricing.goods;

import java.math.BigDecimal;

class Oranges implements Product {

    private static final BigDecimal PRICE = new BigDecimal(1.99d);

    private final BigDecimal quantity;

    Oranges(String quantity) {

        if (null == quantity) throwNumberFormatException();
        this.quantity = BigDecimal.valueOf(Double.valueOf(quantity));
        if (this.quantity.compareTo(BigDecimal.ZERO) <= 0) throwNumberFormatException();

    }

    private Oranges(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return ProductMap.ORANGES.getProductName();
    }

    @Override
    public Product increase(Product product) {
        if (product instanceof Oranges == false) {
            throw new IncompatibleProductsException("Trying to merge product of type Oranges with incompatible one");
        }
        Oranges oranges = (Oranges) product;
        return new Oranges(this.quantity.add(oranges.quantity));
    }

    @Override
    public void printQuantityAndPrice() {

        String message = quantity.toString() + " kg x " + Product.round(PRICE).toString() + "/kg"
                + "\n" + this.getName() + "      " + totalPrice().toString();
        System.out.println(message);
    }

    @Override
    public void printDiscount() {

    }

    @Override
    public BigDecimal totalPrice() {
        return Product.round(PRICE.multiply(quantity));
    }

    @Override
    public BigDecimal discount() {
        return BigDecimal.ZERO;
    }

    private void throwNumberFormatException() {
        throw new NumberFormatException("'quantity' for Oranges product should be positive floating value");
    }
}
