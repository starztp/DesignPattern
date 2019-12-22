package com.tianyou.designpattern.Delegate.simple;

public class DeveloperGolang implements Developer {
    @Override
    public void doing(String command) {
        System.out.println("我擅长Golang，我来做"+command);
    }
}
