package com.tianyou.designpattern.Decorator.Cake;

public class FruitCakeDecorator extends CakeDecorator {

    public FruitCakeDecorator(Cake cake) {
        super(cake);
    }

    @Override
    public String getMessage() {
        return super.getMessage()+"+1份水果";
    }

    @Override
    public int getPrice() {
        return super.getPrice()+10;
    }
}
