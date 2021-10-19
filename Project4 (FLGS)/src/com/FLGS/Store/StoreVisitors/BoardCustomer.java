package com.FLGS.Store.StoreVisitors;

public class BoardCustomer extends Customer{
    public BoardCustomer(){
        super.type = "Board";
        super.setBias();
    }
}
