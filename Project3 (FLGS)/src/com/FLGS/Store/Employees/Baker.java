package com.FLGS.Store.Employees;
import com.FLGS.Interfaces.Publisher;
import com.FLGS.Store.CookieJar;

public class Baker extends Employee implements Publisher {

    private int Pocket = 0;
    private int deliverPackages = 1;
    private Announcer subscriber;

    public Baker(String bakerName){
        super(bakerName);
    }

    public void arrive(int numDays){
        this.publish(this.getName() + " the Baker has arrived on day " + (numDays+1));
    }


    public void deliverCookies(CookieJar jar){
        double soldPrice=jar.addDozen(deliverPackages);
        this.Pocket+=soldPrice;

        this.publish(this.getName() + " the baker has dropped "+deliverPackages+" packages of cookies for $"+soldPrice);
        this.publish(this.getName() + " the baker has earned $"+this.Pocket+" so far!");

    }

    public void leave(){
        this.publish(this.getName() + " the baker has left for day ");
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

    public void publish(String message) {
        this.subscriber.publish(message);
    }

    public String getSubscriber() {
        return this.subscriber.getName();
    }

    public void setSubscriber(Announcer announcer) {
        this.subscriber = announcer;
    }
}
