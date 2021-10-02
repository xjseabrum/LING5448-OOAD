package com.FLGS.Utils;

import com.FLGS.Store.Customer;

import java.util.ArrayList;
import java.util.List;

public class StoreUtils {

    public static List<Customer> spawnCustomer(){

        int numCustomers = 5;
        List<Customer> customers = new ArrayList<Customer>();

        for (int i=0; i<5; i++){
            customers.add(new Customer());
        }

        return customers;
    }

}
