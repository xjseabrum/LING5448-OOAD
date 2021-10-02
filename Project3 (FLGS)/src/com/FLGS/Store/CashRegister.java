package com.FLGS.Store;// Because the com.FLGS.Store.CashRegister object only cares about the amount of cash
// that exists in (1) the current cash register and (2) across all
// instantiated cash registers in the store.  As it does no other function,
// it is incredibly cohesive.

public class CashRegister {
    public double cash = 0;

    public double getCash(){
        return cash;
    }

    public void addCash(double addCash){
        this.cash += addCash;
    }

    public void removeCash(double remCash){
        this.cash -= remCash;
    }

}

