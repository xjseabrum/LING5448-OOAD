package com.FLGS.Store.Employees.commands;

import com.FLGS.Store.Employees.Demonstrator;

public class Explain extends Introduce implements Command{
    public Explain(Demonstrator demoer, Class<?> gameType, String customerName) {
        super(demoer, gameType, customerName, "explain");
    }
}
