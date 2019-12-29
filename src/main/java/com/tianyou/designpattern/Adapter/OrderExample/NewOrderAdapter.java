package com.tianyou.designpattern.Adapter.OrderExample;

/**
 * 新老订单适配
 */
public class NewOrderAdapter implements NewOrder{

    @Override
    public int generateNewOrderNumber() {
        OldOrder oldOrder=new OldOrder();
        String OldOrderNumber=oldOrder.generateOrderNumber();
        int NewOrderNumber=Integer.parseInt(OldOrderNumber);
        System.out.println("新订单号："+NewOrderNumber);
        return NewOrderNumber;
    }
}
