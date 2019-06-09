package com.vpetkov.policyexpert.marketpricing.goods;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class BeansTest {

    @Test
    void increase() {

        Beans beans = new Beans("2");
        Product increasedBeans = beans.increase(new Beans("2"));

        BigDecimal expected = new BigDecimal("2.0");
        BigDecimal actual = increasedBeans.totalPrice();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void totalPrice() {

        Beans beans = new Beans("2");

        BigDecimal expected = new BigDecimal("1.0");
        BigDecimal actual = beans.totalPrice();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void discount() {

        Beans beans = new Beans("4");

        BigDecimal expected = new BigDecimal("0.50");
        BigDecimal actual = beans.discount();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void printQuantityAndPrice() {
        Beans beans = new Beans("4");

        String expected = "\n4 x 0.50" +
                          "\nBeans      2.00";
        String actual = beans.printQuantityAndPrice();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void printDiscount() {
        Beans beans = new Beans("4");

        String expected = "\nBeans 3 for 2        -0.50";
        String actual = beans.printDiscount();

        Assertions.assertEquals(expected, actual);
    }
}