package com.FLGS.Actions;

import com.FLGS.Games.Games;
import com.FLGS.Store.Wares;

import java.util.ArrayList;
import java.util.List;

public class SingleLastStack extends Stack{

    @Override
    public void doAction(Wares ware) {
        Stack WFS=new WidestFirstStack();
        WFS.doAction(ware);
        List<Games> stack = ware.getGames();
        moveToLastByInventory(stack,1);
        moveToLastByInventory(stack,0);
    }
    private void moveToLastByInventory(List<Games> stack,int num){
        List<Games> OneInventoryGames=new ArrayList<>();
        for(Games g:stack){
            if(g.inventory==num){
                OneInventoryGames.add(g);
            }
        }
        stack.removeIf(x->x.inventory==num);
        stack.addAll(OneInventoryGames);
    }
}
