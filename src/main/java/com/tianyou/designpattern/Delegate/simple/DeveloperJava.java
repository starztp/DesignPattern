package com.tianyou.designpattern.Delegate.simple;

public class DeveloperJava implements Developer{

    @Override
    public void doing(String command) {
        System.out.println("我擅长java,我来做"+command);
    }
}
