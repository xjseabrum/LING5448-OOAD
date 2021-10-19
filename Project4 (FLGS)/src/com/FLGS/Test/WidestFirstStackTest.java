package com.FLGS.Test;

import com.FLGS.Actions.WidestFirstStack;
import com.FLGS.Games.Games;
import com.FLGS.Store.Wares;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WidestFirstStackTest {
    @Test
    void doAction() {
        WidestFirstStack obj=new WidestFirstStack();

        Wares testWare=new Wares();
        obj.doAction(testWare);

        for(int i=1;i<testWare.getGames().size();i++){
            List<Games>GameList=testWare.getGames();
            Games cur=GameList.get(i);
            Games pre=GameList.get(i-1);
            assertTrue(cur.boxWidth<=pre.boxWidth,"check if gamebox width is lower than previous game");
            System.out.println("");
        }

    }

}