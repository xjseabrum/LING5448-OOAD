package com.FLGS.Store.StoreVisitors;
import com.FLGS.Games.BoardGame;
import com.FLGS.Games.Deco;

//An example of identity - com.FLGS.Store.StoreVisitors.Customer.buyGame() passes a com.FLGS.Games.Games object to
//a com.FLGS.Store.Employees.Cashier.CashierTasks object. You can step in further, to see that
//the game is then passed further.

import com.FLGS.Games.Games;
import com.FLGS.Interfaces.StoreVisitor;
import com.FLGS.Main;
import com.FLGS.Store.CookieJar;
import com.FLGS.Store.Employees.Cashier;
import com.FLGS.Store.Employees.Demonstrator;
import com.FLGS.Store.Employees.commands.*;
import com.FLGS.Utils.BiasUtils;
import com.FLGS.Utils.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;


public abstract class Customer implements StoreVisitor {

    // Attributes.
    private final String name;
    private double buyProbabilityModifier = 0.0;
    private int numPurchasedGames = 0; // Num of games a customer buys for a given visit
    public String type = "No-Type";
    public Double bonusBias[] = {0.0, 0.0, 0.0};
    public List<Games>IntroducedGames=new ArrayList();

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

    public void setBias(){
        Double bias[] = {0.2, 0.1, 0.0};
        List<Double> dblList = Arrays.asList(bias);
        Collections.shuffle(dblList);
        dblList.toArray(bias);
        this.bonusBias = bias;
    }

    private void buyCookie(CookieJar cookieJar, Cashier cashier){

        int numCookies = RandomUtils.getRandomInt(3)+1;
        cashier.publish("Cashier " + cashier.getName() + " reports: " +
                this.type + " Gamer " + this.name + " is trying to buy cookies.");

        if (!cookieJar.existCookies()){
            cashier.publish("Cashier " + cashier.getName() + " reports: " +
                    "There are no cookies for " + this.name + " to buy!");
            this.buyProbabilityModifier = -0.10;
            return;
        }

        numCookies = Math.min(numCookies, cookieJar.getCookiesInJar());
        cookieJar.soldCookie(numCookies);

        cashier.publish("Cashier " + cashier.getName() + " reports: " +
                this.type + " Gamer " + this.name + " bought " + numCookies + " cookie(s).");

        this.buyProbabilityModifier = 0.20;
    }

    private void buyGames(List<Games> inInventory, Cashier cashier){
        Deco deco = new Deco();

        for (int i = 0; i<inInventory.size(); i++){
            double[] b = BiasUtils.assignCustomerBias(this, inInventory);
            if (RandomUtils.customerBuysFromShelf(i, this.buyProbabilityModifier, b,this,inInventory)) {
                cashier.publish("Cashier " + cashier.getName() + " reports: " +
                        this.type + " Gamer " +  this.name + " selected " +
                        inInventory.get(i).getGameName() + ".");

                cashier.tasks.sold(inInventory.get(i), this.getCustomerName(), Main.register);

                if (RandomUtils.getRandomDouble() < inInventory.get(i).getExtraBuyChance()){
                    // Here, delegation to deco occurs.
                    // allowing it to assign the correct decorator
                    // to the game that the customer buys.
                    cashier.publish(deco.decorate(inInventory.get(i), Main.register));
                }
                this.numPurchasedGames ++;
                BiasUtils.reset();
            }

            if (this.numPurchasedGames >= 3){return;}
        }
    }

    public void VisitStore(CookieJar cookieJar, List<Games> shelf, Cashier cashier) {
        List<Games> inInventory = new ArrayList<>();
        for (Games gameInInventory:shelf){
            if (gameInInventory.getInventory() > 0) {
                inInventory.add(gameInInventory);
            }
        }

        this.buyCookie(cookieJar, cashier);
        this.buyGames(inInventory, cashier);

        cashier.publish("Cashier " + cashier.getName() + " reports: " + this.type + " Gamer " + this.name +
                " bought " + this.numPurchasedGames + " game(s) in all.");

    }
    public Command requestRandomCommand(Demonstrator demonstrator){
        Set gameTypeSet=Main.wares.getGameTypeSet();
        // convert HashSet to an array
        Class<?>[] typeArray = (Class<?>[]) gameTypeSet.toArray(new Class<?>[gameTypeSet.size()]);
        Random r = new Random();
        int rndmNumber = r.nextInt(gameTypeSet.size());
        Class<?> interestedType=typeArray[rndmNumber];
        int c = r.nextInt(100);
        Command cmd=null;
        if (c < 25){ // 25%
            cmd=new Demonstrate(demonstrator, interestedType,this);
        }
        else if (c < 50){ // 30%
            cmd=new Recommend(demonstrator, interestedType,this);
        }
        else if (c < 70){ // 20%
            cmd=new Explain(demonstrator, interestedType,this);
        }
        else { // 25%
        }

        return cmd;
    }
}
