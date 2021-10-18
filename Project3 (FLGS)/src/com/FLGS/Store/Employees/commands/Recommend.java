package com.FLGS.Store.Employees.commands;

import com.FLGS.Games.Games;
import com.FLGS.Store.Employees.Demonstrator;
import com.FLGS.Store.StoreVisitors.Customer;

public class Recommend extends Introduce implements Command {
    public Recommend(Demonstrator demoer, Class<?> gameType, Customer customer) {
        super(demoer, gameType, customer,"recommended");
    }
}
