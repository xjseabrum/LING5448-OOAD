package com.FLGS.Interfaces;

import com.FLGS.Store.Employees.Employee;

import java.util.List;

public interface Subscriber {

    List<Employee> publishers = null;

    void addPublisher(Employee employee);

    void removePublisher(Employee employee);

    void removeAllPublishers();

    void publish(String message);
}
