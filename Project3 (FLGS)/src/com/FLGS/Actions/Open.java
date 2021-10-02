package com.FLGS.Actions;

import com.FLGS.Store.Employees.Cashier;

import java.util.Random;

public class Open{

    Cashier cashier;

    public Open(Cashier cashier){
        this.cashier = cashier;
    }
    public void announce() {
        this.cashier.publish("The store is open for business.");
    }

    public void doAction() {
        //Here would do nothing because customer coming and customer buying is implemented in com.FLGS.Store.Store.java
    }
}
