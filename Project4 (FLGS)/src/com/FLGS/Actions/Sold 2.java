package com.FLGS.Actions;

import com.FLGS.Games.Games;
import com.FLGS.Store.CashRegister;
import com.FLGS.Store.CookieJar;
import com.FLGS.Store.Employees.Baker;
import com.FLGS.Store.Employees.Cashier;

public class Sold {
    // Output the price with the decorators.

    Cashier cashier;

    public Sold(Cashier cashier){
        this.cashier = cashier;
    }

    public void doAction(Games gameSold, String customerName,
                         CashRegister cashRegister) {
        double income = gameSold.getPrice();

        gameSold = gameSold.self;
        gameSold.inventory -= 1;
        gameSold.sold += 1;

        cashRegister.addCash(income);
        this.cashier.publish(customerName + " bought " + gameSold.getGameName() +
                           " for $"+ String.format("%.2f", income) + ".");
    }

}
