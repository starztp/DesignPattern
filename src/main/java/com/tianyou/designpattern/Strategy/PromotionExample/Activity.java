package com.tianyou.designpattern.Strategy.PromotionExample;

public class Activity {

    private Promotion promotion;

    public Activity (Promotion promotion){
        this.promotion=promotion;
    }

    public void excuteActivity(){
        promotion.doPromotion();
    }
}
