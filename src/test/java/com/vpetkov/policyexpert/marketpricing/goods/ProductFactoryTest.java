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
}