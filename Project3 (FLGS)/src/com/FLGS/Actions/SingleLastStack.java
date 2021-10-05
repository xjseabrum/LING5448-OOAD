package com.FLGS.Actions;

import com.FLGS.Games.Games;
import com.FLGS.Store.Wares;

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
        for(int i=0;i<stack.size();i++){
            if(stack.get(i).inventory==num){
                stack.add(stack.get(i));
                stack.remove(i);
            }else{i+=1;}
        }
    }
}
