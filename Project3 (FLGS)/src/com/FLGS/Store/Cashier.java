package com.FLGS.Store;//An example of inheritance - com.FLGS.Store.Cashier has inherited from com.FLGS.Store.Employee.
// You can even see the super() constructor.

// An example of cohesion - The functionality of tasks has been delegated to com.FLGS.Store.CashierTask,
// making com.FLGS.Store.Cashier more cohesive with what it does (handling information regarding cashier.)

import com.FLGS.Actions.Stack;

public class Cashier extends Employee{

    int vacuumDamageRate;
    CashierTask tasks;

    public Cashier(String cashierName, int damageRate, Stack stack) {

        super(cashierName);
        this.vacuumDamageRate = damageRate;
        this.tasks = new CashierTask(stack);
        // TODO: Jay, please clarify 1 or many cash registers?
    }
}
