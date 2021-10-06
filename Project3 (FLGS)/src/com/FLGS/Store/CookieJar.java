package com.FLGS.Store;
import static com.FLGS.Main.register;

// Has to access the cash register
// so that when a cookie is sold, we add the
// price to the register
// and that when a cookie is bought (as restock),
// we subtract the price from the register.
// It also has a class that CookieMonster calls
// when he comes to visit the store.

public class CookieJar {

    // fields
    public double priceDozen = 12.24;
    public double priceCookie = 1.02;
    public int cookiesInJar = 0;
    public int totCookiesSold = 0;
    public int totCookiesSoldToday = 0;
    public int totCMAte = 0;
    public int totCMAteToday = 0;


    public int getCookiesInJar() {
        return cookiesInJar;
    }

    // Law-abiding customers will buy a cookie, and we will call this
    // method.
    public void soldCookie(int cookies) {
        this.cookiesInJar -= cookies;
        this.totCookiesSold += cookies;
        this.totCookiesSoldToday += cookies;
        register.addCash(cookies * priceCookie);
    }

    public int getTotCookiesSold(){
        return this.totCookiesSold;
    }

    public int getTotCMAte(){
        return this.totCMAte;
    }

    public int getTotCookiesSoldToday(){
        int soldToday = this.totCookiesSoldToday;
        this.totCookiesSoldToday = 0;
        return soldToday;
    }

    public int getTotCMAteToday(){
        int cmAte = this.totCMAteToday;
        this.totCMAteToday = 0;
        return cmAte;
    }

    public double addDozen(int dozen){
        this.cookiesInJar += (dozen * 12);
        double price= dozen * priceDozen * 0.5;
        register.removeCash(price);
        return price;
    }

    public boolean existCookies(){
        return (this.cookiesInJar > 0);

    }

    // Cookie Monster!
    public void devour(){
        this.totCMAte += this.getCookiesInJar();
        this.totCMAteToday += this.getCookiesInJar();
        this.cookiesInJar = 0;
    }
}
