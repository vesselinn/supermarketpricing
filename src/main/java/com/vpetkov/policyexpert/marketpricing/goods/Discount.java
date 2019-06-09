package com.vpetkov.policyexpert.marketpricing.goods;

import java.math.BigDecimal;

public interface Discount extends Product {

    /**
     * Prints accumulated discount, if there is
     */
    String printDiscount();

    /**
     * @return price of the discount
     */
    BigDecimal discount();

    default void throwNumberFormatException() {
        throw new NumberFormatException("'quantity' for " + getName() + " product should be positive integer value");
    }
}
