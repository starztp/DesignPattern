package com.tianyou.designpattern.Strategy.OrderExample;

public class WechatPay extends Payment {
    @Override
    public float queryamount(int userId) {
        return 200;
    }
}
