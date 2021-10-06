package com.FLGS.Store.Employees;
import com.FLGS.Interfaces.Publisher;
import com.FLGS.Store.CookieJar;

public class Baker extends Employee implements Publisher {

    private double Pocket = 0;
    private int deliverPackages = 1;
    private Announcer subscriber;

    public Baker(String bakerName){
        super(bakerName);
    }

    public void arrive(int numDays){
        this.publish(this.getName() + " the Baker arrived on Day " + (numDays+1) + ".");
    }


    public void deliverCookies(CookieJar jar){

        if (!jar.existCookies()){
            addDeliverPackages();
        }
        else {
            deductDeliverPackages();
        }

        double soldPrice=jar.addDozen(deliverPackages);


        this.Pocket+=soldPrice;

        this.publish(this.getName() + " the Baker dropped off " +
                     deliverPackages + " packages of chocolate chip " +
                     "cookies for $" +
                     String.format("%.2f", soldPrice) + ".");

        this.publish(this.getName() + " the Baker has earned $" +
                     String.format("%.2f", this.Pocket) + " so far!");

    }

    public void leave(){
        this.publish(this.getName() + " the Baker has left for day.");
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
