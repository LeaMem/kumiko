package com.lea.leet.design.strategy;

/**
 *      算法一 无折算
 */
public class NoDiscountStrategy extends DiscountStrategy{


    public NoDiscountStrategy(int price, int copies) {
        super(price, copies);
    }

    @Override
    public int calculateDiscount() {
        return copies * price;
    }
}
