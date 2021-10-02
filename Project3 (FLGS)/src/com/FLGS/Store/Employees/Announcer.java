package com.FLGS.Store.Employees;

import java.util.ArrayList;
import java.util.List;

public class Announcer extends Employee{

    public Announcer(String announcerName){
        super(announcerName);
        this.setSubscriber(this);
    }

    public void arrive(int numDay){
        this.publish(this.getName()+ " has arrived on day " + numDay);
    }

    public void leave(){
        this.publish(this.getName() + " has left for the day ");
    }

    public void update(String message){
        System.out.println(this.getName() + " Log : " + message);
    }

//  Announcer subscribes to every employee.
//  Does the Subscriber (Announcer) even need a reference of all the Publishers (Employees?)
//
//    public List<Employee> Publishers = new ArrayList<Employee>();
//
//    public void addPublisher(Employee employee) {
//        this.Publishers.add(employee);
//    }
//
//    public void removePublisher(Employee employee) {
//        this.Publishers.remove(employee);
//    }

}
