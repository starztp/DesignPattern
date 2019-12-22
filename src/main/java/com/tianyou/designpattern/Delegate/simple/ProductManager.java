package com.tianyou.designpattern.Delegate.simple;

public class ProductManager {

    public void command(String command,DeveloperLeader leader){
        leader.doing(command);
    }
}
