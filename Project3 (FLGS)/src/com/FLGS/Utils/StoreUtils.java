package com.FLGS.Utils;

import com.FLGS.Store.StoreVisitors.CookieMonster;
import com.FLGS.Store.StoreVisitors.Customer;
import com.FLGS.Store.StoreVisitors.GenerateCustomer;

import java.util.ArrayList;
import java.util.List;

public class StoreUtils {

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
}
