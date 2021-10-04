package com.FLGS;
import com.FLGS.Store.CashRegister;
import com.FLGS.Store.CookieJar;
import com.FLGS.Store.Store;
import com.FLGS.Store.Wares;

import java.io.FileNotFoundException;

public class Main {

    public static Store store = new Store();
    public static CashRegister register = new CashRegister();
    public static Wares wares = new Wares();

    public static void main(String[] args) throws FileNotFoundException {

        store.simulate(30);
     //  System.out.println("-".repeat(45));
    }
}
