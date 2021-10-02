package com.FLGS.Store.Employees;
//An example of inheritance - com.FLGS.Store.Employees.Cashier has inherited from com.FLGS.Store.Employees.Employee.
// You can even see the super() constructor.

// An example of cohesion - The functionality of tasks has been delegated to com.FLGS.Store.Employees.CashierTask,
// making com.FLGS.Store.Employees.Cashier more cohesive with what it does (handling information regarding cashier.)

import com.FLGS.Actions.Stack;

public class Cashier extends Employee{

    public int vacuumDamageRate;
    public CashierTask tasks;

    public Cashier(String cashierName, int damageRate, Stack stack) {

        super(cashierName);
        this.vacuumDamageRate = damageRate;
        this.tasks = new CashierTask(stack, this);
        // TODO: Jay, please clarify 1 or many cash registers?
    }
}
