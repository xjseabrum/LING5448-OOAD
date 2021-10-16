package com.FLGS.Store;
// An example of encapsulation - com.FLGS.Store.Store.customers and
// com.FLGS.Store.Store.cashiers are encapsulated and can only be accessed
// via getter and setter. com.FLGS.Store.Store methods such as doDailyRollCall(),
// doDailyMaintenance, doDailyBusiness, doDailyClose
// are all private because they need (and should) not be accessed
// outside of com.FLGS.Store.Store.simulate().

import com.FLGS.Store.Employees.Announcer;
import com.FLGS.Store.Employees.Baker;
import com.FLGS.Store.Employees.Cashier;
import com.FLGS.Store.Employees.Demonstrator;
import com.FLGS.Store.Employees.commands.Command;
import com.FLGS.Store.StoreVisitors.CookieMonster;
import com.FLGS.Store.StoreVisitors.Customer;
import com.FLGS.Utils.*;
import com.FLGS.Main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Store {

    // attributes
    private List<Customer> customers = new ArrayList<Customer>();
    private List<Cashier> cashiers = new ArrayList<Cashier>();
    private final Announcer announcer = EmployeeUtils.spawnAnnouncer();;
    private final Baker baker = EmployeeUtils.spawnBaker(announcer);
    private Demonstrator demonstrator=EmployeeUtils.spawnDemonstrator(announcer);

    // getters and setters
    public Cashier getCashier(){
        return this.cashiers.get(0);
    }

    public Baker getBaker(){
        return this.baker;
    }

    public void spawnCustomer(){
        this.customers = StoreUtils.spawnCustomers();
    }

    public void spawnCashiers(Announcer announcer){
        cashiers.add(EmployeeUtils.spawnCashier(announcer));
    }


    private void doDailyRollCall(int day){

        this.announcer.arrive(day);

        spawnCashiers(this.announcer);
        for (Cashier cashier:this.cashiers){
            cashier.tasks.arrive(day, Main.wares);
        }
    }

    private void doDailyMaintainence(int day){
        // Employees stack and vacuum.
        for (Cashier cashier:this.cashiers){
            cashier.tasks.count(Main.register);}

        this.baker.arrive(day);
        this.baker.deliverCookies(Main.wares.cookiejar);

        for (Cashier cashier:this.cashiers){
            cashier.tasks.vacuum(Main.wares,cashier.vacuumDamageRate);
            cashier.tasks.stack(Main.wares,cashier.getName());
            cashier.tasks.open();
        }
    }

    private void doDailyBusiness(){
        // Employees open the shop and customers buy stuff.


        this.spawnCustomer();

        this.getCashier().publish( "Cashier " + this.getCashier().getName() +" reports: " +
                this.customers.size() + " customer(s) visited the store today.");
        CookieMonster cookieMonster = StoreUtils.spawnCookieMonster();

        this.demonstrator.arrive();
        this.demonstrator.setWare(Main.wares);

        if (!(cookieMonster==null)){
            this.demonstrator.screamAndRun();
            this.demonstrator=EmployeeUtils.spawnDemonstrator(announcer);
            this.demonstrator.setWare(Main.wares);

            cookieMonster.VisitStore(Main.wares.cookiejar, Main.wares.gamesList, this.getCashier());
        }

        for (Customer customer:this.customers){
            Random r = new Random();
            int requestTimes = r.nextInt(2);// random number from 0~2
            for(int i=0;i<=requestTimes;i++){
                Command cmd=customer.requestRandomCommand(this.demonstrator);
                if(cmd!=null){
                    this.getCashier().setCommand(cmd);
                    this.getCashier().excuteCommands();
                }
            }

            this.getCashier().publish("Cashier " + this.getCashier().getName() +" reports: " +
                    customer.type + " Gamer " + customer.getCustomerName() + " is inspecting the shelves.");
            customer.VisitStore(Main.wares.cookiejar, Main.wares.gamesList, this.getCashier());
        }
    }

    private void doDailyPunchOut(){
        // Employees check the registers and inventory, order new games, close shop
        for (Cashier cashier:this.cashiers){
            cashier.tasks.order(Main.wares, Main.register);
            cashier.tasks.close();
        }

        this.baker.updateCookieRequirements(Main.wares.cookiejar);
        this.baker.leave();

        this.cashiers.clear();

        this.announcer.leave();
    }


    public void simulate(int days) throws FileNotFoundException {

        PublishUtils.setupPublishing();

        for (int day = 0; day < days; day++){
            System.out.println("-".repeat(80));
            this.doDailyRollCall(day);
            this.doDailyMaintainence(day);
            this.doDailyBusiness();
            this.doDailyPunchOut();
        }
        PublishUtils.publishSummary();
    }




}
