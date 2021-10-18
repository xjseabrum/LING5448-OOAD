package com.FLGS.Store.Employees.commands;

import com.FLGS.Games.Games;
import com.FLGS.Store.Employees.Demonstrator;
import com.FLGS.Store.StoreVisitors.Customer;

public abstract class Introduce implements Command{
    Demonstrator demonstrator;
    Class<?> gameType;
    Customer customer;
    String approach;
    public Introduce(Demonstrator demoer, Class<?> gameType, Customer customer,String approach){
        this.demonstrator=demoer;
        this.gameType=gameType;
        this.customer=customer;
        this.approach=approach;
    }
    @Override
    public void execute() {
        Games DemonstratedGame=this.demonstrator.getRandGameByType(this.gameType);
        if(DemonstratedGame != null) {
            this.demonstrator.publish(demonstrator.getName()+" the Demonstrator "+this.approach+" "+DemonstratedGame.gameName+" for Customer "+this.customer.getCustomerName());
            this.customer.IntroducedGames.add(DemonstratedGame);
        }else{
            this.demonstrator.publish(demonstrator.getName()+" the Demonstrator didn't "+this.approach+" "+this.gameType.toString()+" for Customer "+this.customer.getCustomerName()+"because the select type is not available");
        }

    }

}