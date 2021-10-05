package com.FLGS.Store.Employees;
import com.FLGS.Store.CookieJar;

import com.FLGS.Store.CookieJar;

public class Baker extends Employee {

    private int Pocket = 0;
    private int deliverPackages = 1;

    public Baker(String bakerName, Announcer subscriber){
        super(bakerName);
        this.setSubscriber(subscriber);
    }

    public void arrive(int numDays){
        this.publish(this.getName() + " the Baker has arrived on day " + (numDays+1));
    }


    public void deliverCookies(CookieJar jar){
        double soldPrice=jar.addDozen(deliverPackages);
        this.Pocket+=soldPrice;

        this.publish(this.getName() + " the baker has dropped "+deliverPackages+" packages of cookies for $"+soldPrice);

    }

    public void leave(int numDays){
        this.publish(this.getName() + " the baker has left for day " + (numDays+1));
    }
    public void addDeliverPackages(){
        deliverPackages=deliverPackages+1;
    }
    public void deductDeliverPackages(){
        //baker has a minimum of 1 package delivered)
        if(deliverPackages>1){
            deliverPackages=deliverPackages-1;
        }
    }
}
