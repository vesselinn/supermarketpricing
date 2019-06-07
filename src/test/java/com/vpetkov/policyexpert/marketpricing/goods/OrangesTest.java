package com.vpetkov.policyexpert.marketpricing.goods;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class OrangesTest {

    @Test
    void increase() {

        Oranges oranges = new Oranges("0.500");
        Oranges increaseWith = new Oranges("0.500");
        Product increasedOranges = oranges.increase(increaseWith);

        BigDecimal actual = Product.round(increasedOranges.totalPrice());
        BigDecimal expected = Product.round(new BigDecimal(1.99));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void totalPrice() {

        Oranges oranges = new Oranges("0.500");

        BigDecimal actual = oranges.totalPrice();
        BigDecimal expected = new BigDecimal(1.99).multiply(new BigDecimal(0.500));

        Assertions.assertEquals(expected, actual);
    }

}