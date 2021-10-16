package com.FLGS.Store.Employees.commands;

import com.FLGS.Games.Games;
import com.FLGS.Store.Employees.Demonstrator;

public abstract class Introduce implements Command{
    Demonstrator demonstrator;
    Class<?> gameType;
    String customerName;
    String approach;
    public Introduce(Demonstrator demoer, Class<?> gameType, String customerName,String approach){
        this.demonstrator=demoer;
        this.gameType=gameType;
        this.customerName=customerName;
        this.approach=approach;
    }
    @Override
    public void execute() {
        Games DemonstratedGame=this.demonstrator.getRandGameByType(this.gameType);
        if(DemonstratedGame != null) {
            this.demonstrator.publish(demonstrator.getName()+" the Demonstrator "+this.approach+" "+DemonstratedGame.gameName+" for Customer "+this.customerName);
        }else{
            this.demonstrator.publish(demonstrator.getName()+" the Demonstrator didn't "+this.approach+" "+this.gameType.toString()+" for Customer "+this.customerName+"because the select type is not available");
        }

    }

}
