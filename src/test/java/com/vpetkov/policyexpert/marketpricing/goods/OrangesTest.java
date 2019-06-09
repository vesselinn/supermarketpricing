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

        BigDecimal actual = increasedOranges.totalPrice();
        BigDecimal expected = new BigDecimal("1.98999999999999999111821580299874767661094665527343750");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void totalPrice() {

        Oranges oranges = new Oranges("0.500");

        BigDecimal actual = oranges.totalPrice();
        BigDecimal expected = new BigDecimal(1.99).multiply(new BigDecimal(0.500));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void printQuantityAndPrice() {
        Oranges oranges = new Oranges("4");

        String expected = "\n4.0 kg x 1.99/kg" +
                          "\nOranges      7.96";
        String actual = oranges.printQuantityAndPrice();

        Assertions.assertEquals(expected, actual);
    }

}