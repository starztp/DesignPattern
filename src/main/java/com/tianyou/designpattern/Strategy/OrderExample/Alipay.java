package com.tianyou.designpattern.Strategy.OrderExample;

public class Alipay extends Payment {
    @Override
    public float queryamount(int userId) {
        return 500;
    }
}
