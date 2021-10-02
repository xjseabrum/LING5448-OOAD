package com.FLGS.Store;//An example of identity - com.FLGS.Store.Customer.buyGame() passes a com.FLGS.Games.Games object to
//a com.FLGS.Store.Employees.Cashier.CashierTasks object. You can step in further, to see that
//the game is then passed further.



import com.FLGS.Games.Games;
import com.FLGS.Games.DamageGame;
import com.FLGS.Main;
import com.FLGS.Utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Customer {

    // Attributes.
    private final String name;
    private final List<Double> shelfPreferenceProbability = new ArrayList<>();
    private final boolean isCookieMonster = RandomUtils.getRandomDouble()<=0.01;
    private final double buyProbabilityModifier = 0.0;
    private int numPurchasedGames = 0; // Num of games a customer buy for a given visit

    public Customer(String name){
        if (this.isCookieMonster){
            this.name = "Cookie Monster";
        }
        else {
            this.name = name;
        }
//        shelfPreferenceProbability.addAll(Arrays.asList(0.8, 0.82, 0.84, 0.86, 0.88, 0.90, 0.92, 0.94, 0.96, 0.98, 1.0));
    }

    public Customer(){
        name = RandomUtils.getRandomName();
//        shelfPreferenceProbability.addAll(Arrays.asList(0.8, 0.82, 0.84, 0.86, 0.88, 0.90, 0.92, 0.94, 0.96, 0.98, 1.0));

    }

    //Getters and Setters.
    public String getCustomerName(){
        return name;
    }

    public List<Double> getShelfPreferenceProbability(){
        return shelfPreferenceProbability;
    }

    //Methods.
    public Shelf selectShelf(List<Shelf> shelves){
        // unused in this implementation. plans to implement next sprint.

        int selectedShelfIndex = RandomUtils.getRandomInt(shelves.size());
        return shelves.get(selectedShelfIndex);
    }

    public int selectGame(List<Games> shelf){
        // customer preference in choosing game goes here.
        // unused in this implementation. plans to implement next sprint.

        double probabilityOfBuy = RandomUtils.getRandomDouble();
        int i = 0;

        while (i < shelfPreferenceProbability.size()){
            if (probabilityOfBuy <= shelfPreferenceProbability.get(i)){
                return i-1;
            }
            i++;
        }
        return -1;
    }

    private void terrorize(){
        System.out.println("Customer Log : Cookie Monster has arrived to terrorize!");
        // if there are cookies
        // eat all the cookies
        // else leave the store
        // exit subroutine
        System.out.println("Customer Log : Cookie Monster has eaten all the cookies!");

        int numGamesToDamage = RandomUtils.getRandomInt(5)+1;
        DamageGame dg = new DamageGame();

        for (int i=0; i<numGamesToDamage; i++) {
            // TODO : @Jay The cookie monster needs to give a new message
            // Would like to add an extra signature for the cookie
            // monster.
            dg.damageRandomGame(Main.wares);
        }

        System.out.println("Customer Log : Cookie Monster has damaged " + numGamesToDamage + " !");
    }

    private void buyCookie(){

        int numCookies = RandomUtils.getRandomInt(2)+1;
        // if cookies in cookieJar
        // buyCookies
        // adjust buyProbabilityModifier accordingly
        System.out.println("Customer Log : Customer is trying to buy cookies.");
    }

    private void buyGames(List<Games> inInventory){

        for (int i = 0; i<=inInventory.size(); i++){

            if (RandomUtils.customerBuysFromShelf(i, this.buyProbabilityModifier)) {
                System.out.println("Customer Log : Customer " + this.name + " selected " + inInventory.get(i).getGameName() + ".");
                Main.store.getCashier().tasks.sold(inInventory.get(i), this.getCustomerName(), Main.register);
                this.numPurchasedGames ++;
            }

            if (this.numPurchasedGames >= 3){return;}
        }
    }


    public void visitShop(List<Games> shelf){

        List<Games> inInventory = new ArrayList<>();
        // TODO: Weitung/Jay, give me an updated list of games that I can buy from!
        for (Games gameInInventory:shelf){
            if (gameInInventory.getInventory() > 0) {
                inInventory.add(gameInInventory);
            }
        }

        if (this.isCookieMonster){
            this.terrorize();
        }

        else{
            this.buyCookie();
            this.buyGames(inInventory);

        }


        System.out.println("Customer Log : Customer " + this.name + " did has bought" + this.numPurchasedGames + "game(s).");
    }
}
