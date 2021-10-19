package com.FLGS.Store.Employees.commands;

import com.FLGS.Store.Employees.Demonstrator;
import com.FLGS.Store.StoreVisitors.Customer;

public class Explain extends Introduce implements Command{
    public Explain(Demonstrator demoer, Class<?> gameType, Customer customer) {
        super(demoer, gameType, customer, "explained");
    }
}
