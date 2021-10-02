package com.FLGS.Store;

import com.FLGS.Utils.RandomUtils;

public class Employee {

    protected String name;

    public Employee(String name){
        this.name = name;
    }

    public Employee(){
        this.name = RandomUtils.getRandomName();
    }

    // Getters and Setters.
    public String getName(){
        return this.name;
    }
}
