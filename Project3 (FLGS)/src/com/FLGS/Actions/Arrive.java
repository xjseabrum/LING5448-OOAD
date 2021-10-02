package com.FLGS.Actions;

import com.FLGS.Games.Games;
import com.FLGS.Store.Employees.Cashier;
import com.FLGS.Store.Wares;

import java.util.ArrayList;
import java.util.List;

/*
    can't implement interface method with different input, see :
    https://stackoverflow.com/questions/14921671/an-interface-with-different-method-parameters/14921692
*/

public class Arrive{
    Cashier cashier;
    public Arrive(Cashier cashier){
        this.cashier = cashier;
    }

    public void announce(int arriveDay) {
        this.cashier.publish(this.cashier.getName() +
                " the Cashier arrived at the store on Day " +
                (arriveDay + 1) + ".");
    }
    public void doAction(Wares ware) {
        List<Games>gamesList = ware.gameOrderedLastNight;
        if(gamesList.size() > 0){
            for(Games game:gamesList){
                this.cashier.publish("Three new orders of " +
                                    game.getGameName() + " have arrived.");
            }
        }
        ware.gameOrderedLastNight = new ArrayList<>();
    }
}
