package com.tianyou.designpattern.Strategy.PromotionExample;

import java.util.HashMap;
import java.util.Map;

public class PromotionFactory {

    private PromotionFactory(){

    }

    public static Map<String,Promotion> PromotionMapping=new HashMap<String, Promotion>();

    static {
        PromotionMapping.put(PromotionKey.CashOff,new CashOff());
        PromotionMapping.put(PromotionKey.FlashSales,new FlashSales());
        PromotionMapping.put(PromotionKey.FriendsDeal,new FriendsDeal());
    }

    public static Promotion getPromotion(String PromotionKey){
        if(PromotionKey.equals("")){
            return null;
        }
        return PromotionMapping.get(PromotionKey);
    }

    private interface PromotionKey{
        String CashOff="CashOff";
        String FlashSales="FlashSales";
        String FriendsDeal="FriendsDeal";
    }


}
