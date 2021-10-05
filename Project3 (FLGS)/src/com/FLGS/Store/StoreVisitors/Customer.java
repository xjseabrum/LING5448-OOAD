package com.FLGS.Store.StoreVisitors;
import com.FLGS.Games.Deco;

//An example of identity - com.FLGS.Store.StoreVisitors.Customer.buyGame() passes a com.FLGS.Games.Games object to
//a com.FLGS.Store.Employees.Cashier.CashierTasks object. You can step in further, to see that
//the game is then passed further.

import com.FLGS.Games.Games;
import com.FLGS.Interfaces.StoreVisitor;
import com.FLGS.Main;
import com.FLGS.Store.CookieJar;
import com.FLGS.Store.Employees.Cashier;
import com.FLGS.Utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;


public class Customer implements StoreVisitor {

    // Attributes.
    private final String name;
    private double buyProbabilityModifier = 0.0;
    private int numPurchasedGames = 0; // Num of games a customer buys for a given visit

    public Customer(String name){
        this.name = name;
    }

    public Customer(){
        name = RandomUtils.getRandomName();;
    }

    //Getters and Setters.
    public String getCustomerName(){
        return name;
    }

    private void buyCookie(CookieJar cookieJar, Cashier cashier){

        int numCookies = RandomUtils.getRandomInt(2)+1;
        cashier.publish("Cashier " + cashier.getName() + " reports  : " +
                "Customer " + this.name + " is trying to buy cookies.");

        if (cookieJar.getCookiesInJar()==0){
            cashier.publish("Cashier " + cashier.getName() + " reports  : " +
                    "There are no cookies for " + this.name + " to buy!");
            this.buyProbabilityModifier -= 0.10;
            return;
        }

        numCookies = Math.min(numCookies, cookieJar.getCookiesInJar());
        cookieJar.soldCookie(numCookies);

        cashier.publish("Cashier " + cashier.getName() + " reports  : " +
                "Customer " + this.name + " bought " + numCookies + "cookies");

        this.buyProbabilityModifier += 0.20;
    }

    private void buyGames(List<Games> inInventory, Cashier cashier){
        Deco deco = new Deco();
        for (int i = 0; i<inInventory.size(); i++){

            if (RandomUtils.customerBuysFromShelf(i, this.buyProbabilityModifier)) {
                cashier.publish("Cashier " + cashier.getName() + " reports  : " +
                       "Customer" + this.name + " selected " + inInventory.get(i).getGameName() + ".");

                cashier.tasks.sold(inInventory.get(i), this.getCustomerName(), Main.register);

                if (RandomUtils.getRandomDouble() < inInventory.get(i).getExtraBuyChance()){
                    cashier.publish(deco.decorate(inInventory.get(i), Main.register));
                }
                this.numPurchasedGames ++;
            }

            if (this.numPurchasedGames >= 3){return;}
        }
    }

    public void VisitStore(CookieJar cookieJar, List<Games> shelf, Cashier cashier) {
        List<Games> inInventory = new ArrayList<>();
        // TODO: Weitung/Jay, give me an updated list of games that I can buy from!
        for (Games gameInInventory:shelf){
            if (gameInInventory.getInventory() > 0) {
                inInventory.add(gameInInventory);
            }
        }

        this.buyCookie(cookieJar, cashier);
        this.buyGames(inInventory, cashier);

        cashier.publish("Cashier " + cashier.getName() + " reports  : Customer " + this.name +
                " bought " + this.numPurchasedGames + " game(s).");

    }
}
