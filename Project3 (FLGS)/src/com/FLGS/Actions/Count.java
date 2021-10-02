package com.FLGS.Actions;

import com.FLGS.Store.CashRegister;
import com.FLGS.Store.Employees.Cashier;

public class Count {

    // We should pass information through object
    // rather than method parameter,
    // see https://stackoverflow.com/questions/4367347/constructor-parameters-vs-method-parameters

    Cashier cashier;
    public Count(Cashier cashier){
        this.cashier = cashier;
    }

    public void announce(CashRegister register){
        double cash = Math.round(register.getCash() * 100.0) / 100.0;
        this.cashier.publish("The cash register currently has $" +
                String.format("%.2f", cash) + ".");
    }

    public void doAction(CashRegister register){
        double cash = register.getCash();
        double moneyAdded = 1000;
        if(cash < 100){
            register.addCash(moneyAdded);
            this.cashier.publish(
                    "The Cash Fairy graciously and magically added $" +
                    String.format("%.2f", moneyAdded) + " to the cash register.");
            announce(register);
        }
    }
}
