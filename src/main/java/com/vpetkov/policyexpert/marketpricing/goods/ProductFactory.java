package com.vpetkov.policyexpert.marketpricing.goods;


public class ProductFactory {

    public static Product getProduct(String productName, String quantity) {

        ProductMap productMap = ProductMap.getByName(productName);

        switch (productMap) {
            case BEANS: return new Beans(quantity);
            case COKE: return new Coke(quantity);
            case ORANGES: return new Oranges(quantity);
            default: throw new ProductNotFoundException(productName);
        }

    }

}
