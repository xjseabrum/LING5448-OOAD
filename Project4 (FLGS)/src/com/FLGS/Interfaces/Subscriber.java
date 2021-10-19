package com.FLGS.Interfaces;

import com.FLGS.Store.Employees.Employee;

// This interface just makes a class implement subscriber in the observer pattern.
// Currently, subscribers don't need references of their publisher to function.
// We feel that it is more cohesive to not force this relation - so we have left
// functions adding and removing publishers unimplemented.


public interface Subscriber {


    void addPublisher(Employee employee);  // Adds a reference to a publisher.

    void removePublisher(Employee employee);  // Removes a given publisher from its references

    void removeAllPublishers(); // Removes all publishers from its references

    void publish(String message); // Actions to do when a publisher publishes a message to the subscriber.
}
