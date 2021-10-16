package com.FLGS.Interfaces;

import com.FLGS.Games.Games;
import com.FLGS.Store.CookieJar;
import com.FLGS.Store.Employees.Cashier;

import java.util.List;

public interface StoreVisitor {

    // When anyone visits the store, you can buy a cookie/game or talk to the cashier
    void VisitStore(CookieJar cookieJar, List<Games> shelf, Cashier cashier);

}
