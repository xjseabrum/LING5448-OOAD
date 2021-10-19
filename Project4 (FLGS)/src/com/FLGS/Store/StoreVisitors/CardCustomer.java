package com.FLGS.Store.StoreVisitors;

public class CardCustomer extends Customer{
    public CardCustomer(){
        super.type = "Card";
        super.setBias();
    }
}
