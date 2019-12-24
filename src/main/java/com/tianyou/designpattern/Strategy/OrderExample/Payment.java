package com.tianyou.designpattern.Strategy.OrderExample;

public abstract class Payment {

    public abstract float queryamount(int userId);


    /**
     * 校验用户余额
     * @param userId    用户Id
     * @param amount    订单金额
     */
    public void checkamount(int userId,float amount){
        if (queryamount(userId)<amount){
            System.out.println("余额不足，支付失败");
        }else {
            System.out.println("支付成功");
        }
    }
}
