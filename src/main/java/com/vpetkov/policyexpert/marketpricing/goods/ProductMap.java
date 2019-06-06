package com.vpetkov.policyexpert.marketpricing.goods;

enum ProductMap {

    BEANS   ("Beans"),
    COKE    ("Coke"),
    ORANGES ("Oranges");

    private final String productName;

    ProductMap(String productName) {
        this.productName = productName;
    }

    static ProductMap getByName(String productName) {
        for (ProductMap productMap : ProductMap.values()) {
            if (productMap.productName.equals(productName)) return productMap;
        }

        throw new ProductNotFoundException(productName);
    }

    String getProductName() {
        return this.productName;
    }

}
