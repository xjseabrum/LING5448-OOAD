package com.FLGS.Test;

import com.FLGS.Actions.HighestFirstStack;
import com.FLGS.Games.*;
import com.FLGS.Store.Wares;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HighestFirstStackTest {

    @org.junit.jupiter.api.Test
    void doAction() {
        HighestFirstStack obj=new HighestFirstStack();

        Wares testWare=new Wares();
        obj.doAction(testWare);

        for(int i=1;i<testWare.getGames().size();i++){
            List<Games>GameList=testWare.getGames();
            Games cur=GameList.get(i);
            Games pre=GameList.get(i-1);
            assertTrue(cur.boxHeight>=pre.boxHeight,"check if gamebox height is higher than previous game");
            System.out.println("");
        }

    }
}