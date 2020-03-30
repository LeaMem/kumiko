package com.lea.leet.design.strategy;

/**
 *      算法三
 *      打8折
 */
public class PercentStrategy extends DiscountStrategy {

    //折扣比例
    private float percent = 0.8f;

    public PercentStrategy(int price, int copies) {
        super(price, copies);
    }

    @Override
    public int calculateDiscount() {
        return (int)(copies * price * percent);
    }

    public static void main(String[] args) {

        //第一种算法
        DiscountStrategy strategy = new NoDiscountStrategy(60, 5);
        System.out.println("total(60,5) = " + strategy.calculateDiscount());

        strategy = new FlatRateStrategy(80, 5);
        System.out.println("total(80,5)="+strategy.calculateDiscount());

        strategy = new PercentStrategy(100, 3);
        System.out.println("total(100,4)="+strategy.calculateDiscount());

    }
}
