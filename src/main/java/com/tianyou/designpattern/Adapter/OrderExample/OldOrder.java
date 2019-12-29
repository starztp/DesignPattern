package com.tianyou.designpattern.Adapter.OrderExample;

/**
 * 老订单号
 */
public class OldOrder {

    private String OrderNumber;

    public String getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        OrderNumber = orderNumber;
    }

    public String generateOrderNumber(){
        this.OrderNumber="1111";
        return OrderNumber;
    }
}
