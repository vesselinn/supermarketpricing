package com.vpetkov.policyexpert.marketpricing.goods;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.vpetkov.policyexpert.marketpricing.goods.ProductFactory.getProduct;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductFactoryTest {

    @Test
    void throwProductNotFoundExceptionForNotProvidedName() {

        ProductNotFoundException exception =  Assertions.assertThrows(ProductNotFoundException.class, () -> {
            getProduct(null, null);
        });

        String expectedMessage = "Product 'null' was not found!";

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void throwProductNotFoundExceptionForIncompatibleName() {

        ProductNotFoundException exception = Assertions.assertThrows(ProductNotFoundException.class, () -> {
            getProduct("Chocolate", null);
        });

        String expectedMessage = "Product 'Chocolate' was not found!";

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void throwNumberFormatExceptionForNotProvidedQuantity() {

        NumberFormatException exception = Assertions.assertThrows(NumberFormatException.class, () -> {
            getProduct("Oranges", null);
        });

        String expectedMessage = "'quantity' for Oranges product should be positive floating value";

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void throwNumberFormatExceptionForIncompatibleTypeOfQuantity() {

        NumberFormatException exception = Assertions.assertThrows(NumberFormatException.class, () -> {
            getProduct("Oranges", "foo");
        });

        String expectedMessage = "For input string: \"foo\"";

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void throwNumberFormatExceptionForNegativeQuantity() {

        NumberFormatException exception = Assertions.assertThrows(NumberFormatException.class, () -> {
            getProduct("Oranges", "-1");
        });

        String expectedMessage = "'quantity' for Oranges product should be positive floating value";

        assertEquals(expectedMessage, exception.getMessage());

    }

    @Test
    void successfulCreateProduct() {

        Product oranges = getProduct("Oranges", "0.900");
        Product coke = getProduct("Coke", "1");
        Product beans = getProduct("Beans", "2");

        assertEquals("Oranges", oranges.getName());
        assertEquals("Coke", coke.getName());
        assertEquals("Beans", beans.getName());

    }
}