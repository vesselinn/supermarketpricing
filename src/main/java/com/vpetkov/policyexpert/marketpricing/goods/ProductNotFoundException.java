package com.vpetkov.policyexpert.marketpricing.goods;

class ProductNotFoundException extends RuntimeException {
    ProductNotFoundException(String productName) {
        super("Product '" + productName + "' was not found!");
    }
}
