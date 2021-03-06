package com.FLGS.Actions;

import com.FLGS.Games.Games;
import com.FLGS.Store.Employees.Cashier;
import com.FLGS.Store.Wares;

import java.util.List;

public abstract class Stack{


    public void announce(Cashier cashier) {
        cashier.publish("Stacking...");
    }
    public abstract void doAction(Wares ware);
    public void announceStackOrder(Wares ware,String employeeName,Cashier cashier){
        List<Games> stack=ware.getGames();
        for (int i = 0; i < stack.size(); i++) {
            Games game = stack.get(i);
            String message=employeeName + " stacked " + game.getInventory() + " " +
                    game.getGameName() + " game(s) at shelf " +
                    "position " + (i+1) + ".";
            cashier.publish(message);
        }
    };
}
