package com.FLGS.Store.Employees;

public class Baker extends Employee {

    int Pocket = 0;

    public Baker(String bakerName, Announcer subscriber){
        super(bakerName);
        this.setSubscriber(subscriber);
    }

    public void arrive(int numDays){
        this.publish(this.getName() + " the baker has arrived on day " + numDays);
    }

    public void deliverCookies(){

        // Some logic for delivering cookies
        this.publish(this.getName() + " the baker has dropped of 0 cookies for $0");
    }

    public void leave(int numDays){
        this.publish(this.getName() + " the baker has left for day " + numDays);
    }

}
