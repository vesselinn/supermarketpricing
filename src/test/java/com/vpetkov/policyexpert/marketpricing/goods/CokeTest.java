package com.vpetkov.policyexpert.marketpricing.goods;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class CokeTest {

    @Test
    void increase() {

        Coke coke = new Coke("2");
        Product increasedCoke = coke.increase(new Coke("2"));

        BigDecimal expected = new BigDecimal("2.7999999999999998223643160599749535322189331054687500");
        BigDecimal actual = increasedCoke.totalPrice();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void totalPrice() {

        Coke coke = new Coke("2");

        BigDecimal expected = new BigDecimal("1.3999999999999999111821580299874767661094665527343750");
        BigDecimal actual = coke.totalPrice();

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