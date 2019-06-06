package com.vpetkov.policyexpert.marketpricing.goods;

import java.math.BigDecimal;

class Coke implements Product {

    private static final BigDecimal PRICE = new BigDecimal(0.70d);
    private final int quantity;

    Coke(String quantity) {

        if (null == quantity) throwNumberFormatException();
        this.quantity = Integer.valueOf(quantity);
        if (this.quantity <= 0) throwNumberFormatException();

    }

    private Coke(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return ProductMap.COKE.getProductName();
    }

    @Override
    public Product increase(Product product) {
        if (product instanceof Coke == false) {
            throw new IncompatibleProductsException("Trying to merge product of type Coke with incompatible one");
        }
        Coke coke = (Coke) product;
        return new Coke(this.quantity + coke.quantity);
    }

    @Override
    public void printQuantityAndPrice() {
        String message = quantity + " x " + Product.round(PRICE).toString()
                + "\n" + this.getName() + "      " + totalPrice().toString();
        System.out.println(message);
    }

    @Override
    public void printDiscount() {

        String message = this.getName() + " 2 for £1        -" + Product.round(discount());
        System.out.println(message);
    }

    @Override
    public BigDecimal totalPrice() {
        return Product.round(PRICE.multiply(BigDecimal.valueOf(quantity)));
    }

    @Override
    public BigDecimal discount() {
        BigDecimal discount = totalPrice().subtract(
                PRICE.multiply(BigDecimal.valueOf(quantity % 2))
                        .add(BigDecimal.valueOf(quantity / 2 * 1)));
        return Product.round(discount);
    }

    private void throwNumberFormatException() {
        throw new NumberFormatException("'quantity' for Coke product should be positive integer value");
    }
}
