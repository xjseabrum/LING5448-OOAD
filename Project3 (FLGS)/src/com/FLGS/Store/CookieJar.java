package com.FLGS.Store;
import static com.FLGS.Main.register;
// Has to access the cash register
// so that when a cookie is sold, we add the
// price to the register
// and that when a cookie is bought (as restock),
// we subtract the price from the register.


public class CookieJar {

    // fields
    public double priceDozen = 12.24;
    public double priceCookie = 1.02;
    public int cookiesInJar = 0;

    public int getCookiesInJar() {
        return cookiesInJar;
    }

    // Law-abiding customers will buy a cookie, and we will call this
    // method.
    public void soldCookie(int cookies) {
        this.cookiesInJar -= cookies;
        register.addCash(cookies * priceCookie);
    }

    public double addDozen(int dozen){
        this.cookiesInJar += (dozen * 12);
        double price= dozen * priceDozen * 0.5;
        register.removeCash(price);
        return price;
    }

    // Cookie Monster!
    public void devour(){
        this.cookiesInJar = 0;
    }
}
