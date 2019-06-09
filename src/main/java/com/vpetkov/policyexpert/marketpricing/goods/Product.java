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
     * Returns name, quantity, single and total price of a certain product, ready for print
     */
    String printQuantityAndPrice();

    /**
     *
     * @return price of all goods, from a certain product, without discount
     */
    BigDecimal totalPrice();

    static BigDecimal round(BigDecimal value){
        return value.setScale(2, RoundingMode.HALF_UP);
    }

    default BigDecimal singlePrice() {
        return ProductMap.getByName(getName()).price();
    }

}
