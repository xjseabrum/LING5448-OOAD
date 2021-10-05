package com.FLGS;
import com.FLGS.Games.*;
import com.FLGS.Store.CashRegister;
import com.FLGS.Store.Store;
import com.FLGS.Store.Wares;
import com.FLGS.Utils.RandomUtils;

import java.io.FileNotFoundException;

public class Main {

    public static Store store = new Store();
    public static CashRegister register = new CashRegister();
    public static Wares wares = new Wares();

    public static void main(String[] args) throws FileNotFoundException {

        store.simulate(30);

// Testing decorator code.  This is the syntax to call deco:
//        Games gh = new Gloomhaven();
//        Games pk = new Pokemon();
//        Games mt = new Mousetrap();
//        Games mo = new Monopoly();
//        System.out.println(RandomUtils.getRandomDouble() < mo.getExtraBuyChance());
//        Deco deco = new Deco();
//
//        String l = deco.decorate(gh);
//        System.out.println(l);
//
//        String ll = deco.decorate(pk);
//        System.out.println(ll);
//
//        String lll = deco.decorate(mt);
//        System.out.println(lll);
//
//        String llll = deco.decorate(mo);
//        System.out.println(llll);
    }
}
