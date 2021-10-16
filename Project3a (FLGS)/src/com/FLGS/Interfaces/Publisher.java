package com.FLGS.Interfaces;

import com.FLGS.Store.Employees.Announcer;

// This interface makes a class have publisher functionality.
// Since a publisher always needs to publish to a subscriber
// we have implemented a "setSubscriber" method. This will add
// a reference of a subscriber to the class implementing the interface.
// Publish will send a String message to the "setSubscriber"
// getSubscriber is not implemented because there is no reason to call
// "which subscriber has been published to" because in this sprint - there
// is only one Announcer. In the future, with more announcer - we can use
// this function.

public interface Publisher {

    // publishes to the subscriber (announcer) who
    // can then decide what needs to be done
    void publish(String message);

    String getSubscriber();

    // adds a reference to a subscriber, through which
    // Publisher can publish messages.
    void setSubscriber(Announcer announcer);

}

