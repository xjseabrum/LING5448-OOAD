package com.FLGS.Actions;

import com.FLGS.Games.Games;
import com.FLGS.Store.CashRegister;
import com.FLGS.Store.Employees.Cashier;
import com.FLGS.Store.Wares;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void doAction() {
        Wares ware = new Wares();
        CashRegister register = new CashRegister();
        register.addCash(1000.0);
        HighestFirstStack stack = new HighestFirstStack();
        Cashier cashier= new Cashier( "testCashier", 3, stack);


        //set some games' inventory to zero
        Games g1=ware.getGames().get(0);
        Games g2=ware.getGames().get(1);
        g1.inventory=0;
        g2.inventory=0;

        Order obj=new Order(cashier);
        obj.doAction(ware,register);
        double temp1=g1.price*3*0.5;
        double temp2=g2.price*3*0.5;
        double expectedCost=g1.price*3*0.5+g2.price*3*0.5;
        assertTrue(g1.inventory==3,"Test g1's inventory added");
        assertTrue(g2.inventory==3,"Test g2's inventory added");
        assertEquals(1000.0-expectedCost,register.cash,"Check cash register deduct the cost of games");


    }
}