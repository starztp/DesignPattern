package com.tianyou.designpattern.Decorator.Cake;

public class CakeDecorator extends Cake {

    private Cake cake;

    public CakeDecorator(Cake cake){
        this.cake=cake;
    }

    @Override
    public String getMessage() {
        return this.cake.getMessage();
    }

    @Override
    public int getPrice() {
        return this.cake.getPrice();
    }
}
