package com.vpetkov.policyexpert.marketpricing.goods;

import java.math.BigDecimal;

class Oranges extends Quantity {

    Oranges(String quantity) {
        super(quantity);
    }

    private Oranges(BigDecimal quantity) {
        super(quantity);
    }

    @Override
    public String getName() {
        return ProductMap.ORANGES.productName();
    }

    @Override
    public Product increase(Product product) {
        if (product instanceof Oranges == false) {
            throw new IncompatibleProductsException("Trying to merge product of type Oranges with incompatible one");
        }
        Oranges oranges = (Oranges) product;
        return new Oranges(this.quantity.add(oranges.quantity));
    }

}
