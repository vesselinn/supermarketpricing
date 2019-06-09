package com.vpetkov.policyexpert.marketpricing.goods;

import java.math.BigDecimal;

class Coke extends OfferBuyXForY {

    private static final int X = 2;
    private static final BigDecimal Y = BigDecimal.ONE;

    Coke(String quantity) {
        super(X, Y, quantity);
    }

    private Coke(int quantity) {
        super(X, Y, quantity);
    }

    @Override
    public String getName() {
        return ProductMap.COKE.productName();
    }

    @Override
    public Product increase(Product product) {
        if (product instanceof Coke == false) {
            throw new IncompatibleProductsException("Trying to merge product of type Coke with incompatible one");
        }
        Coke coke = (Coke) product;
        return new Coke(this.quantity + coke.quantity);
    }

}
