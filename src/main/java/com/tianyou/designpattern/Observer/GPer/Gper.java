package com.tianyou.designpattern.Observer.GPer;

import java.util.Observable;

public class Gper extends Observable {

    private String name="咕泡生态圈";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void askQuestion(Question question){
        System.out.println(question.getUsername()+"在"+this.getName()+"提交了一个问题");
        setChanged();
        //通知所有观察者
        notifyObservers(question);
    }
}
