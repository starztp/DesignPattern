package com.tianyou.designpattern.Strategy.OrderExample;

public class Order {

    private int userId;
    private int OrderId;
    private float amount;

    public Order(int userId,int OrderId,float amount){
        this.userId=userId;
        this.OrderId=OrderId;
        this.amount=amount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void pay(String paykey){
        Payment payment=PaymentStrategy.paymentMapping.get(paykey);
        payment.checkamount(this.userId,this.amount);
    }
}
