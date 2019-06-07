package com.vpetkov.policyexpert.marketpricing.goods;

import java.math.BigDecimal;

class Beans implements Product {

    private static final BigDecimal PRICE = new BigDecimal(0.50d);

    private final int quantity;

    Beans(String quantity) {

        if (null == quantity) throwNumberFormatException();
        this.quantity = Integer.valueOf(quantity);
        if (this.quantity <= 0) throwNumberFormatException();
    }

    private Beans(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return ProductMap.BEANS.getProductName();
    }

    @Override
    public Product increase(Product product) {
        if (product instanceof Beans == false) {
            throw new IncompatibleProductsException("Trying to merge product of type Beans with incompatible one");
        }
        Beans beans = (Beans) product;
        return new Beans(this.quantity + beans.quantity);
    }

    @Override
    public void printQuantityAndPrice() {
        String message = quantity + " x " + Product.round(PRICE).toString()
                + "\n" + this.getName() + "      " + Product.round(totalPrice()).toString();
        System.out.println(message);
    }

    @Override
    public void printDiscount() {

        String message = this.getName() + " 2 for £1        -" + Product.round(discount());
        System.out.println(message);
    }

    @Override
    public BigDecimal totalPrice() {
        return PRICE.multiply(BigDecimal.valueOf(quantity));
    }

    @Override
    public BigDecimal discount() {
        BigDecimal discount = totalPrice().subtract(
                PRICE.multiply(BigDecimal.valueOf(quantity / 3 * 2))
                        .add(PRICE.multiply(BigDecimal.valueOf(quantity % 3))));
        return Product.round(discount);
    }

    private void throwNumberFormatException() {
        throw new NumberFormatException("'quantity' for Beans product should be positive integer value");
    }

}
