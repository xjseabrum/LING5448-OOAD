package com.FLGS.Store.StoreVisitors;

import com.FLGS.Games.DamageGame;
import com.FLGS.Games.Games;
import com.FLGS.Interfaces.StoreVisitor;
import com.FLGS.Store.CookieJar;
import com.FLGS.Store.Employees.Cashier;
import com.FLGS.Utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

import static com.FLGS.Main.wares;

public class CookieMonster implements StoreVisitor {

    private final String name = "Cookie Monster";

    private void breakGames(List<Games> shelf, Cashier cashier){

        int numGamesToDamage = RandomUtils.getRandomInt(5)+1;
        DamageGame dg = new DamageGame();
        Games damagedGame;

        cashier.publish("COOKIEMONSTERALERT!!! Cashier " + cashier.getName() + " reports  : " +
                "Cookie Monster wants to damage " + numGamesToDamage + " game(s)!");

        for (int i=0; i<numGamesToDamage; i++) {

            damagedGame = dg.damageRandomGame(shelf);
            if (damagedGame==null){
                cashier.publish("COOKIEMONSTERALERT!!! Cashier " + cashier.getName() + " reports  : " +
                        "Cookie Monster tried to  damage games, but the shelf was empty!");
            }

            else {
                cashier.publish("COOKIEMONSTERALERT!!! Cashier " + cashier.getName() + " reports  : " +
                        "Cookie monster ");
            }
        }
    }

    private boolean terrorize(CookieJar cookiejar, Cashier cashier){
        cashier.publish("Customer Log: Cookie Monster has arrived to terrorize!");

        if(!cookiejar.existCookies()) {
            cashier.publish("COOKIEMONSTERALERT!!! Cashier " + cashier.getName() + " reports  : " +
                    "Customer Log: Cookie Monster notices there are no cookies and leaves dejectedly.");
            return false;
        }

        else {
            cookiejar.devour();
            cashier.publish("COOKIEMONSTERALERT!!! Cashier " + cashier.getName() + " reports  : " +
                    "Customer Log: Cookie Monster has eaten all the cookies!");
            return true;
        }
    }

    public void VisitStore(CookieJar cookieJar, List<Games> shelf, Cashier cashier) {

        boolean foundCookies;

        List<Games> inInventory = new ArrayList<>();
        // TODO: Weitung/Jay, give me an updated list of games that I can buy from!
        for (Games gameInInventory:shelf){
            if (gameInInventory.getInventory() > 0) {
                inInventory.add(gameInInventory);
            }
        }

        foundCookies = this.terrorize(cookieJar, cashier);

        if (foundCookies){
            breakGames(inInventory, cashier);
        }
    }
}
