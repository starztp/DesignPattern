package com.tianyou.designpattern.Delegate.simple;

import java.util.HashMap;
import java.util.Map;

public class DeveloperLeader {

    private Map<String,Developer> developerMapping=new HashMap<String, Developer>();

    public DeveloperLeader(){
        developerMapping.put("Java",new DeveloperJava());
        developerMapping.put("Golang",new DeveloperGolang());
    }

    public void doing(String command){
        developerMapping.get(command).doing(command);
    }

}
