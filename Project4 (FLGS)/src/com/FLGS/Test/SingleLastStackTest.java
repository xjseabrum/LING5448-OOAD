package com.FLGS.Test;

import com.FLGS.Actions.SingleLastStack;
import com.FLGS.Games.Games;
import com.FLGS.Store.Wares;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SingleLastStackTest {

    @Test
    void doAction() {
        SingleLastStack obj=new SingleLastStack();

        Wares testWare=new Wares();
        //set 0~3 random games' inventory into 1
        Random r=new Random();
        for(int i=1; i<r.nextInt(4);i++){
            testWare.getGames().get(r.nextInt(testWare.getGames().size())).inventory=1;
        }

        obj.doAction(testWare);
        int split=testWare.getGames().size();
        for(int i=1;i<testWare.getGames().size();i++){
            List<Games> GameList=testWare.getGames();
            Games cur=GameList.get(i);
            Games pre=GameList.get(i-1);

            if(cur.inventory!=1){
                assertTrue(cur.boxWidth<=pre.boxWidth,"check if gamebox width is lower than previous game");
            }else{
                //detect game that only have 1 inventory, will use this index to check list of games which after this index all have single inventory.
                split=i;
                break;
            }
        }
        //check rest of the game has 1 inventory

        for(int i=split;i<testWare.getGames().size();i++){
            List<Games> GameList=testWare.getGames();
            Games cur=GameList.get(i);
            assertTrue(cur.inventory<=1,"check if games in the last sequence have single inventory");
        }


    }
}