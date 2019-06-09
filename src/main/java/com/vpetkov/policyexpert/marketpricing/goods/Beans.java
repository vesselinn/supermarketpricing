package com.vpetkov.policyexpert.marketpricing.goods;

class Beans extends OfferBuyXGetY {

    private static final int X = 2;
    private static final int Y = 3;

    Beans(String quantity) {
        super(X, Y, quantity);
    }

    private Beans(int quantity) {
        super(X, Y, quantity);
    }

    @Override
    public String getName() {
        return ProductMap.BEANS.productName();
    }

    @Override
    public Product increase(Product product) {
        if (product instanceof Beans == false) {
            throw new IncompatibleProductsException("Trying to merge product of type Beans with incompatible one");
        }
        Beans beans = (Beans) product;
        return new Beans(this.quantity + beans.quantity);
    }

}
