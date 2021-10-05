package com.FLGS.Utils;

import com.FLGS.Store.StoreVisitors.CookieMonster;
import com.FLGS.Store.StoreVisitors.Customer;

import java.util.ArrayList;
import java.util.List;

public class StoreUtils {

    public static List<Customer> spawnCustomers(){

        int numCustomers = RandomUtils.poissonRandom(3);
        List<Customer> customers = new ArrayList<Customer>();

        for (int i=0; i<numCustomers; i++){
            customers.add(new Customer());
        }

        return customers;
    }

    public static CookieMonster spawnCookieMonster(){
        if (RandomUtils.getRandomDouble() <= 0.01){
            return new CookieMonster();
        }
        return null;
    }
}
