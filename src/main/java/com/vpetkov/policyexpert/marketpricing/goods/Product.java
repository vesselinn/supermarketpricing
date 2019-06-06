package com.vpetkov.policyexpert.marketpricing.goods;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Represents all public functionality of a good
 */
public interface Product {

    /**
     *
     * @return the name of the product
     */
    String getName();

    /**
     * Increases the quantity of a certain product
     *
     * @param product {@link Product}
     * @return {@link Product}
     */
    Product increase(Product product);

    /**
     * Prints name, quantity, single and total price of a certain product
     */
    void printQuantityAndPrice();

    /**
     * Prints accumulated discount, if there is
     */
    void printDiscount();

    /**
     *
     * @return price of all goods, from a certain product, without discount
     */
    BigDecimal totalPrice();

    /**
     *
     * @return price of the discount
     */
    BigDecimal discount();

    static BigDecimal round(BigDecimal value){
        return value.setScale(2, RoundingMode.HALF_UP);
    }

}
