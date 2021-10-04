package com.FLGS.Actions;

import com.FLGS.Games.DamageGame;
import com.FLGS.Games.Games;
import com.FLGS.Store.Employees.Cashier;
import com.FLGS.Store.Wares;

import java.util.Random;

public class Vacuum {

    Cashier cashier;

    public Vacuum(Cashier cashier){
        this.cashier = cashier;
    }
    private DamageGame dg =new DamageGame();
    Random r = new Random();
    public void announce() {
        this.cashier.publish("Vacuuming... ");
    }

    public void doAction(int damageRate, Wares ware) {
        //reference https://stackoverflow.com/questions/38838172/percentage-using-random/38838299
        int num=r.nextInt(100);

        if(num<=damageRate){
            Games gameDamaged =dg.damageRandomGame(ware);
            if(gameDamaged!=null){
                this.cashier.publish("An in-stock order of " +
                        gameDamaged.getGameName() +
                        " got damaged while vacuuming!");
            }
        }
    }
}
