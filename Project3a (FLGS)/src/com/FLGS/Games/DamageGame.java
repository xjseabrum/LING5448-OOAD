package com.FLGS.Games;
import com.FLGS.Store.Wares;

import java.util.List;
import java.util.Random;

public class DamageGame {
    Random r = new Random();
    public Games damageRandomGame(List<Games> gameList){
        //reference https://www.baeldung.com/java-random-list-element

        if(gameList != null && !gameList.isEmpty()){
            List<Games> gameInStock=gameList;
            gameInStock.removeIf(x->x.inventory==0);
            Games gameDamaged = gameInStock.get(r.nextInt(gameInStock.size()));
            gameDamaged.inventory -= 1;
            gameDamaged.setDamageContainer(1);
            return gameDamaged;
        } else {
            return null;
        }
    }
}
