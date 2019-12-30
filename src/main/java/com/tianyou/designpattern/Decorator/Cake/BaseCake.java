package com.tianyou.designpattern.Decorator.Cake;

public class BaseCake extends Cake{

    @Override
    public String getMessage() {
        return "蛋糕";
    }

    @Override
    public int getPrice() {
        return 100;
    }
}
