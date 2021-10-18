package com.FLGS.Test;

import com.FLGS.Actions.HighestFirstStack;
import com.FLGS.Actions.Sold;
import com.FLGS.Games.Clue;
import com.FLGS.Games.Games;
import com.FLGS.Store.CashRegister;
import com.FLGS.Store.Employees.Announcer;
import com.FLGS.Store.Employees.Cashier;
import com.FLGS.Store.Employees.CashierTask;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoldTest {

    @Test
    void doAction() {
        HighestFirstStack stack = new HighestFirstStack();
        Cashier cashier= new Cashier( "testCashier", 3, stack);
        cashier.setSubscriber(new Announcer("temp"));
        Sold obj = new Sold(cashier);
        CashRegister register=new CashRegister();
        Clue game=new Clue();
        game.inventory=3;
        double originalCash=register.cash;

        obj.doAction(game,"testCustomer",register);

        //assert game inventory decremented
        assertEquals(2,game.inventory);
        //assert cash add to the cash register
        assertEquals(originalCash+game.price,register.cash);
    }
}