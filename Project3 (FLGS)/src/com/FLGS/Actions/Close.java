package com.FLGS.Actions;

import com.FLGS.Store.Employees.Cashier;

public class Close{

    Cashier cashier;

    public Close(Cashier cashier){
        this.cashier = cashier;
    }

    public void announce() {
        this.cashier.publish(
                 "The Cashier" + this.cashier.getName() +  "closed the store for the night and went home."
        );
    }

    public void doAction() {

    }
}
