package com.FLGS.Store.Employees;

//import java.util.ArrayList;
//import java.util.List;

import com.FLGS.Interfaces.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class Announcer extends Employee implements Subscriber {

    public Announcer(String announcerName){
        super(announcerName);
    }

    public void arrive(int numDay){
        this.publish(this.getName()+ " has arrived on day " + (numDay+1) + ".");
    }

    public void leave(){
        this.publish(this.getName() + " has left for the day ");
    }

    public void update(String message){
        System.out.println(this.getName() + " Log: " + message);
    }



//  Announcer subscribes to every employee.
//  Does the Subscriber (Announcer) even need a reference of all the Publishers (Employees?)
//
    public List<Employee> Publishers = new ArrayList<Employee>();
//
    public void addPublisher(Employee employee) {
        this.Publishers.add(employee);
    }

    public void removePublisher(Employee employee) {
        this.Publishers.remove(employee);
    }


    public void removeAllPublishers(){
        this.Publishers.clear();
    }

    public void publish(String message) {
        System.out.println("Guy's Announcement : " + message);
    }


}
