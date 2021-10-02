package com.FLGS.Actions;

import com.FLGS.Games.Games;
import com.FLGS.Store.Wares;

import java.util.ArrayList;
import java.util.List;

/*
    can't implement interface method with different input, see :
    https://stackoverflow.com/questions/14921671/an-interface-with-different-method-parameters/14921692
*/

public class Arrive{
    public void announce(String employeeName, int arriveDay) {
        System.out.println("---------------------------------------------------");
        System.out.println(employeeName +
                           " the com.FLGS.Store.Cashier arrived at the store on Day " +
                (arriveDay + 1) + ".");
    }
    public void doAction(Wares ware) {
        List<Games>gamesList = ware.gameOrderedLastNight;
        if(gamesList.size() > 0){
            for(Games game:gamesList){
                System.out.println("Three new orders of " +
                                    game.getGameName() + " have arrived.");
            }
        }
        ware.gameOrderedLastNight = new ArrayList<>();
    }
}
