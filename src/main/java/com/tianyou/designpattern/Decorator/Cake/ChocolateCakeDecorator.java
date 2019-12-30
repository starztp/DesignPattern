package com.tianyou.designpattern.Decorator.Cake;

public class ChocolateCakeDecorator extends CakeDecorator{


    public ChocolateCakeDecorator(Cake cake) {
        super(cake);
    }

    @Override
    public String getMessage() {
        return super.getMessage()+"+1份巧克力";
    }

    @Override
    public int getPrice() {
        return super.getPrice()+20;
    }


}
