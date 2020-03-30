package com.lea.leet.design.strategy;

/**
 *      优惠5元
 */
public class FlatRateStrategy extends DiscountStrategy {

    private int discount = 5;

    public FlatRateStrategy(int price, int copies) {
        super(price, copies);
    }

    @Override
    public int calculateDiscount() {
        return copies * (price - discount);
    }
}
