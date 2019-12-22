package com.tianyou.designpattern.Proxy.dynamicproxy.JDKproxy.OrderExample;

import java.util.Calendar;

public class OrderServiceStaticProxy {

    private IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService){
        this.orderService=orderService;
    }

    public void createOrder(Order order){
        before();
        this.orderService.createOrder(order);
        after();
    }

    private void before(){
        Calendar calendar=Calendar.getInstance();
        int currentyear=calendar.get(Calendar.YEAR);
        System.out.println("静态代理自动分配到DB_"+currentyear+"库处理");
    }

    private void after(){
        System.out.println("还原数据库默认配置");
    }
}
