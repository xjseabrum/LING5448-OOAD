package com.FLGS.Store.StoreVisitors;

import java.util.Collections;

public class KidCustomer extends Customer{
    public KidCustomer(){
        super.type = "Kid";
        super.setBias();
    }
}
