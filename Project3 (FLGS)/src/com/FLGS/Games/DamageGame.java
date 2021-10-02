package com.FLGS.Games;

import com.FLGS.Store.Wares;

import java.util.List;
import java.util.Random;

public class DamageGame {
    Random r = new Random();
    public void damageRandomGame(Wares ware){
        //reference https://www.baeldung.com/java-random-list-element

        List<Games> gameList=ware.getGames();
        if(gameList!=null && !gameList.isEmpty()){
            Games gameDamaged=gameList.get(r.nextInt(gameList.size()));
            gameDamaged.inventory -= 1;
            System.out.println("An in-stock order of " +
                    gameDamaged.getGameName() +
                    " got damaged while vacuuming!");
        }
    }
}
