package com.tianyou.designpattern.Strategy.OrderExample;

import java.util.HashMap;
import java.util.Map;

public class PaymentStrategy {

    private static String ALIPAY="Alipay";
    private static String WECHAT="WechatPay";
    public static Map<String,Payment> paymentMapping=new HashMap<String, Payment>();

    static {
        paymentMapping.put(ALIPAY,new Alipay());
        paymentMapping.put(WECHAT,new WechatPay());
    }
}
