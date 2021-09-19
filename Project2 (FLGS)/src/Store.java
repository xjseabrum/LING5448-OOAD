package src;

import java.util.ArrayList;
import java.util.List;

public class Store {

    // attributes
    public List<Shelf> shelves = new ArrayList<Shelf>();
    public List<Customer> customers = new ArrayList<Customer>();
    public List<Employee> employees = new ArrayList<Employee>();

    // getters and setters

    // methods
    public void addShelf(){
        int shelfNumber = shelves.size();
        shelves.add(new Shelf(shelfNumber));
    }

    public void spawnCustomer(){
        customers.add(new Customer());
    }

    public void spawnCashier(String name, double vaccumDamageRate){
        employees.add(new Cashier(name, vaccumDamageRate));
    }


}
