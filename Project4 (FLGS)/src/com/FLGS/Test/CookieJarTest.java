package com.FLGS.Test;

import com.FLGS.Store.CookieJar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CookieJarTest {

    @Test
    void soldCookie() {
        CookieJar jar=new CookieJar();
        jar.addDozen(1);
        int numberOfCookieSold=3;
        int cookiesInJarBeforeSold=jar.cookiesInJar;
        jar.soldCookie(numberOfCookieSold);
        assertEquals(cookiesInJarBeforeSold-numberOfCookieSold,jar.cookiesInJar);
    }

    @Test
    void addDozen() {
        CookieJar jar=new CookieJar();
        int cookiesInJarBeforeSold=jar.cookiesInJar;
        jar.addDozen(1);
        assertEquals(cookiesInJarBeforeSold+12,jar.cookiesInJar);
    }

    @Test
    void existCookies() {
        CookieJar jar=new CookieJar();
        Boolean result=jar.existCookies();
        assertEquals(false,result);

        jar.addDozen(1);
        result=jar.existCookies();
        assertEquals(true,result);
    }

    @Test
    void devour() {
        CookieJar jar=new CookieJar();
        jar.addDozen(1);
        jar.devour();
        assertEquals(0,jar.cookiesInJar);
        assertEquals(12,jar.totCMAteToday);
        assertEquals(12,jar.totCMAte);
    }
}