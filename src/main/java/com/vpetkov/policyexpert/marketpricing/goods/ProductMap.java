package com.vpetkov.policyexpert.marketpricing.goods;

import java.math.BigDecimal;

enum ProductMap {

    BEANS   ("Beans", new BigDecimal(0.50d)),
    COKE    ("Coke", new BigDecimal(0.70d)),
    ORANGES ("Oranges", new BigDecimal(1.99d));

    private final String productName;
    private final BigDecimal price;
    ProductMap(String productName, BigDecimal price) {
        this.productName = productName;
        this.price = price;
    }

    static ProductMap getByName(String productName) {
        for (ProductMap productMap : ProductMap.values()) {
            if (productMap.productName.equals(productName)) return productMap;
        }

        throw new ProductNotFoundException(productName);
    }

    String productName() {
        return this.productName;
    }

    BigDecimal price() {
        return this.price;
    }
}
