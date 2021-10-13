package com.FLGS.Store.Employees;
//An example of inheritance - com.FLGS.Store.Employees.Cashier has inherited from com.FLGS.Store.Employees.Employee.
// You can even see the super() constructor.

// An example of cohesion - The functionality of tasks has been delegated to com.FLGS.Store.Employees.CashierTask,
// making com.FLGS.Store.Employees.Cashier more cohesive with what it does (handling information regarding cashier.)

import com.FLGS.Actions.Stack;
import com.FLGS.Interfaces.Publisher;

public class Cashier extends Employee implements Publisher {

    public int vacuumDamageRate;
    public CashierTask tasks;
    private Announcer subscriber = null;

    public Cashier(String cashierName, int damageRate, Stack stack) {

        super(cashierName);
        this.vacuumDamageRate = damageRate;
        this.tasks = new CashierTask(stack, this);
    }

    public void publish(String message) {
        this.subscriber.publish(message);

    }

    public String getSubscriber(){ return this.subscriber.getName(); }

    public void setSubscriber(Announcer announcer){
        this.subscriber = announcer;
    }



}
