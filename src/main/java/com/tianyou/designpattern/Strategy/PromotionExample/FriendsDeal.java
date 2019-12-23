package com.tianyou.designpattern.Strategy.PromotionExample;

public class FriendsDeal implements Promotion {
    @Override
    public void doPromotion() {
        System.out.println("我是拼团");
    }
}
