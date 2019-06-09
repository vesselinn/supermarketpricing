package com.vpetkov.policyexpert.marketpricing.goods;

import java.math.BigDecimal;

public abstract class OfferBuyXForY implements Discount {

    protected final int x;
    protected final BigDecimal y;
    protected final int quantity;

    protected OfferBuyXForY(int x, BigDecimal y, String quantity) {

        if (null == quantity) throwNumberFormatException();
        this.quantity = Integer.valueOf(quantity);
        if (this.quantity <= 0) throwNumberFormatException();

        this.x = x;
        this.y = y;
    }

    protected OfferBuyXForY(int x, BigDecimal y, int quantity) {
        this.x = x;
        this.y = y;
        this.quantity = quantity;
    }

    @Override
    public String printDiscount() {

        return "\n" + getName() + " " + x + " for £" + y.toString() + "        -" + Product.round(discount());
    }

    @Override
    public BigDecimal discount() {
        BigDecimal discount = totalPrice().subtract(
                singlePrice().multiply(BigDecimal.valueOf(quantity % x))
                        .add(BigDecimal.valueOf(quantity / x).multiply(y)));
        return Product.round(discount);
    }

    @Override
    public String printQuantityAndPrice() {

        return "\n" + quantity + " x " + Product.round(singlePrice()).toString()
                + "\n" + getName() + "      " + Product.round(totalPrice()).toString();
    }

    @Override
    public BigDecimal totalPrice() {
        return singlePrice().multiply(BigDecimal.valueOf(quantity));
    }

}
