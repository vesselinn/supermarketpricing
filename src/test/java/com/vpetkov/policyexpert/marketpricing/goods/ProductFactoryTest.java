package com.vpetkov.policyexpert.marketpricing.goods;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.vpetkov.policyexpert.marketpricing.goods.ProductFactory.getProduct;

class ProductFactoryTest {

    @Test
    void throwProductNotFoundExceptionForNotProvidedName() {

        Assertions.assertThrows(ProductNotFoundException.class, () -> {
            getProduct(null, null);
        });

    }

    @Test
    void throwProductNotFoundExceptionForIncompatibleName() {

        Assertions.assertThrows(ProductNotFoundException.class, () -> {
            getProduct(null, null);
        });

    }

    @Test
    void throwNumberFormatExceptionForNotProvidedQuantity() {

        Assertions.assertThrows(NumberFormatException.class, () -> {
            getProduct("Oranges", null);
        });

    }

    @Test
    void throwNumberFormatExceptionForIncompatibleTypeOfQuantity() {

        Assertions.assertThrows(NumberFormatException.class, () -> {
            getProduct("Oranges", "foo");
        });

    }

    @Test
    void successfulCreateProduct() {

        Product oranges = getProduct("Oranges", "0.900");
        Product coke = getProduct("Coke", "1");
        Product beans = getProduct("Beans", "2");

        Assertions.assertEquals("Oranges", oranges.getName());
        Assertions.assertEquals("Coke", coke.getName());
        Assertions.assertEquals("Beans", beans.getName());

    }
}