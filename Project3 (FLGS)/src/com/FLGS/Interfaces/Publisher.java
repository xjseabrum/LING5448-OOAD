package com.FLGS.Interfaces;

import com.FLGS.Store.Employees.Announcer;

public interface Publisher {

    Announcer subscriber = null;
    // publishes to the subscriber (announcer)
    void publish(String message);

    String getSubscriber();

    void setSubscriber(Announcer announcer);

}

