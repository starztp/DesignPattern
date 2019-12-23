package com.tianyou.designpattern.Strategy.PromotionExample;



public class CashOff implements Promotion {
    @Override
    public void doPromotion() {
        System.out.println("满件减活动");
    }
}
