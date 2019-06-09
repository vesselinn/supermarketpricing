package com.vpetkov.policyexpert.marketpricing.goods;

import java.math.BigDecimal;

public abstract class OfferBuyXGetY implements Discount {

    protected final int x;
    protected final int y;
    protected final int quantity;

    protected OfferBuyXGetY(int x, int y, String quantity) {

        if (null == quantity) throwNumberFormatException();
        this.quantity = Integer.valueOf(quantity);
        if (this.quantity <= 0) throwNumberFormatException();

        this.x = x;
        this.y = y;
    }

    protected OfferBuyXGetY(int x, int y, int quantity) {
        this.x = x;
        this.y = y;
        this.quantity = quantity;
    }

    @Override
    public BigDecimal discount() {
        BigDecimal discount = totalPrice().subtract(
                singlePrice().multiply(BigDecimal.valueOf(quantity / y * x))
                        .add(singlePrice().multiply(BigDecimal.valueOf(quantity % y))));
        return Product.round(discount);
    }

    @Override
    public String printDiscount() {

        return "\n" + getName() + " " + y + " for " + x + "        -" + Product.round(discount());
    }

    @Override
    public String printQuantityAndPrice() {
        return "\n" + quantity + " x " + Product.round(singlePrice()).toString()
                + "\n" + this.getName() + "      " + Product.round(totalPrice()).toString();
    }

    @Override
    public BigDecimal totalPrice() {
        return singlePrice().multiply(BigDecimal.valueOf(quantity));
    }
}
