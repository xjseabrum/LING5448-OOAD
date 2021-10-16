package com.FLGS.Store.Employees.commands;

import com.FLGS.Games.Games;
import com.FLGS.Store.Employees.Demonstrator;

public class Recommend extends Introduce implements Command {
    public Recommend(Demonstrator demoer, Class<?> gameType, String customerName) {
        super(demoer, gameType, customerName,"recommend");
    }
}
