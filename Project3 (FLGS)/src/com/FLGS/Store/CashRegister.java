package com.FLGS.Store;
// Because the com.FLGS.Store.CashRegister object only cares about the amount of cash
// that exists in (1) the current cash register and (2) across all
// instantiated cash registers in the store.  As it does no other function,
// it is incredibly cohesive.

import com.FLGS.Interfaces.Robbable;
import com.FLGS.Utils.StoreUtils;

public class CashRegister implements Robbable {
    public double cash = 0;
    public int cashFairyCounter = 0;
    public double getCash(){
        return cash;
    }

    public void addCash(double addCash){
        this.cash += addCash;
    }

    public void removeCash(double remCash){
        this.cash -= remCash;
    }

    public StoreUtils.Record rob(StoreUtils.Record record) {
        record.setCashStolen(this.cash);
        this.cash = 0;

        return record;
    }

    public void settleInsurance(StoreUtils.Record record){
        this.cash = record.getCashStolen();
    }
}

