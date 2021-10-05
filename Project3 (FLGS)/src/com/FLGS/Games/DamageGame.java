package com.FLGS.Games;
import com.FLGS.Store.Wares;

import java.util.List;
import java.util.Random;

public class DamageGame {
    Random r = new Random();
    public String notice = "";
    public Games damageRandomGame(List<Games> gameList){
        //reference https://www.baeldung.com/java-random-list-element

        if(gameList != null && !gameList.isEmpty()){
            Games gameDamaged = gameList.get(r.nextInt(gameList.size()));
            gameDamaged.inventory -= 1;
            return gameDamaged;
        }else{
            return null;
        }
    }
}
