package com.tianyou.designpattern.Strategy.PromotionExample;

public class FlashSales implements Promotion {
    @Override
    public void doPromotion() {
        System.out.println("我是闪购");
    }
}
