package com.FLGS.Store.Employees;

import com.FLGS.Games.Games;
import com.FLGS.Interfaces.Publisher;
import com.FLGS.Store.Wares;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Demonstrator extends Employee implements Publisher {
    private Wares ware;
    private Announcer subscriber = null;
    public Demonstrator(String name) {
        super.name=name;
    }
    @Override
    public void publish(String message) {
        this.subscriber.publish(message);
    }

    @Override
    public String getSubscriber() {
        return this.subscriber.getName();
    }

    @Override
    public void setSubscriber(Announcer announcer) {
        this.subscriber = announcer;
    }
    public Games getRandGameByType(Class<?> gameType){

        List<Games> gameList=this.ware.getGames();
        List<Games> targetGames=new ArrayList<Games>();
        for(Games game:gameList){
            if(gameType.isAssignableFrom(game.getClass()) && game.inventory>0){
                targetGames.add(game);
            }
        }
        Random r = new Random();
        if(targetGames.size()>0){
            int i = r.nextInt(targetGames.size());
            return targetGames.get(i);
        }
        else{
            return null;
        }
    }
    public void setWare(Wares ware){
        this.ware=ware;
    }
    public void arrive(){
        this.subscriber.publish("Demonstrator "+this.name+" arrived.");
    }
    public void screamAndRun(){
        this.subscriber.publish(this.name+": ahhhhhhh~~~~");
    }
}
