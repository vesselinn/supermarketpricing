package com.vpetkov.policyexpert.marketpricing.goods;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class CokeTest {

    @Test
    void increase() {

        Coke coke = new Coke("2");
        Product increasedCoke = coke.increase(new Coke("2"));

        BigDecimal expected = new BigDecimal("2.80");
        BigDecimal actual = Product.round(increasedCoke.totalPrice());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void totalPrice() {

        Coke coke = new Coke("2");

        BigDecimal expected = new BigDecimal("1.40");
        BigDecimal actual = Product.round(coke.totalPrice());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void discount() {

        Coke coke = new Coke("4");

        BigDecimal expected = new BigDecimal("0.80");
        BigDecimal actual = coke.discount();

        Assertions.assertEquals(expected, actual);
    }

}