package com.FLGS.Store.Employees;

import com.FLGS.Utils.RandomUtils;

public class Employee {

    // Every employee is now a publisher, and changes are published to a subscriber (Announcer).
    // In a typical pub-sub model - there are usually more subscribers than publishers. But
    // here there is only one subscriber and many publishers. Hence, updating becomes easier.
    // (no for loops necessary to implement all subscribers)

    protected String name;
    private Announcer subscriber;

    public Employee(String name){
        this.name = name;
    }

    public Employee(){
        this.name = RandomUtils.getRandomName();
    }

    public Employee(String name, Announcer subscriber){
        this.name = name;
        this.subscriber = subscriber;
    }

    // Getters and Setters.
    public String getName(){
        return this.name;
    }

    public String getSubscriber(){ return this.subscriber.getName(); }

    public void setSubscriber(Announcer announcer){
        this.subscriber = announcer;
    }

    // Methods.
    public void publish(String message){
        this.subscriber.update(message);
    }
}
