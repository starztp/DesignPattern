package com.tianyou.designpattern.Proxy.staticproxy;

import com.tianyou.designpattern.Proxy.Person;

public class GoldProxy {

    private Person person;

    public GoldProxy(Person person){
        this.person=person;
    }

    public void BuyGold(){
        person.BuyGold();
    }

    public void before(){
        System.out.println("买金币前");
    }

    public void after(){
        System.out.println("买金币后");
    }
}
