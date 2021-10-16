package com.FLGS.Store.StoreVisitors;

public class FamilyCustomer extends Customer{
    public FamilyCustomer(){
        super.type = "Family";
        super.setBias();
    }
}
