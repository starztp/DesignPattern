package com.tianyou.designpattern.Observer.GPer;

import java.util.Observable;
import java.util.Observer;

public class Teacher implements Observer {

    private String name;

    public Teacher(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        //先将被观察者与参数转化成Gper和Question对象
        Gper gper=(Gper)o;
        Question question=(Question) arg;
        System.out.println(this.name+"老师您好！");
        System.out.println("您收到一个来自"+gper.getName()+"的提问，提问者是"+question.getUsername()+"问题内容是：");
        System.out.println(question.getContext());
    }
}
