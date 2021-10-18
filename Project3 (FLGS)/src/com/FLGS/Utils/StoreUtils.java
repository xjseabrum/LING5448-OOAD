package com.FLGS.Utils;

import com.FLGS.Games.Games;
import com.FLGS.Store.StoreVisitors.CookieMonster;
import com.FLGS.Store.StoreVisitors.Customer;
import com.FLGS.Store.StoreVisitors.GenerateCustomer;

import java.util.ArrayList;
import java.util.List;

public class StoreUtils {

    public static double chanceOfStoreGettingRobbed = 0.033333; // 1 / 30 days

    public static List<Customer> spawnCustomers(){

        int numCustomers = RandomUtils.poissonRandom(3);
        List<Customer> customers = new ArrayList<Customer>();

        for (int i=0; i<numCustomers; i++){
            customers.add(new GenerateCustomer().createCustomer());
        }

        return customers;
    }

    public static CookieMonster spawnCookieMonster(){
        if (RandomUtils.getRandomDouble() >= 0.98){
            return new CookieMonster();
        }
        return null;
    }

    public static boolean attemptToRobIsSuccessful(){

        chanceOfStoreGettingRobbed += chanceOfStoreGettingRobbed;
        return RandomUtils.getRandomDouble() <= chanceOfStoreGettingRobbed;
    }

    public static class Record {

        int numCookiesStolen;
        double cashStolen;
        List<Games> gameList;
        int numGamesStolen;

        public int getNumCookiesStolen(){
            return this.numCookiesStolen;
        }

        public double getCashStolen(){
            return this.cashStolen;
        }

        public List<Games> getGamesStolen(){
            return this.gameList;
        }

        public int getNumGamesStolen(){
            return this.numGamesStolen; }

        public void setNumCookiesStolen(int numCookiesStolen){
            this.numCookiesStolen = numCookiesStolen;
        }

        public void setCashStolen(double cashStolen){
            this.cashStolen = cashStolen;
        }

        public void setGamesStolen(List<Games> gameList){
            this.gameList = gameList;
        }

        public void setNumGamesStolen(int numGamesStolen){
            this.numGamesStolen = numGamesStolen;
        }

    }


}
