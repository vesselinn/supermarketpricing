package com.vpetkov.policyexpert.marketpricing.goods;

import java.math.BigDecimal;

abstract class Quantity implements Product {

    protected final BigDecimal quantity;

    protected Quantity(String quantity) {

        if (null == quantity) throwNumberFormatException();
        this.quantity = BigDecimal.valueOf(Double.valueOf(quantity));
        if (this.quantity.compareTo(BigDecimal.ZERO) <= 0) throwNumberFormatException();

    }

    protected Quantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @Override
    public String printQuantityAndPrice() {

        return "\n" + quantity.toString() + " kg x " + Product.round(singlePrice()).toString() + "/kg"
                + "\n" + getName() + "      " + Product.round(totalPrice()).toString();
    }

    @Override
    public BigDecimal totalPrice() {
        return singlePrice().multiply(quantity);
    }

    private void throwNumberFormatException() {
        throw new NumberFormatException("'quantity' for " + getName() + " product should be positive floating value");
    }
}
