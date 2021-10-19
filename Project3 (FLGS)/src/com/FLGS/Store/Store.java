package com.FLGS.Store;
// An example of encapsulation - com.FLGS.Store.Store.customers and
// com.FLGS.Store.Store.cashiers are encapsulated and can only be accessed
// via getter and setter. com.FLGS.Store.Store methods such as doDailyRollCall(),
// doDailyMaintenance, doDailyBusiness, doDailyClose
// are all private because they need (and should) not be accessed
// outside of com.FLGS.Store.Store.simulate().

import com.FLGS.Interfaces.Robbable;
import com.FLGS.Store.Employees.Announcer;
import com.FLGS.Store.Employees.Baker;
import com.FLGS.Store.Employees.Cashier;
import com.FLGS.Store.Employees.Demonstrator;
import com.FLGS.Store.Wares;
import com.FLGS.Store.Employees.commands.Command;
import com.FLGS.Store.StoreVisitors.CookieMonster;
import com.FLGS.Store.StoreVisitors.Customer;
import com.FLGS.Utils.*;
import com.FLGS.Main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Store implements Robbable {

    // attributes
    private List<Customer> customers = new ArrayList<Customer>();
    private List<Cashier> cashiers = new ArrayList<Cashier>();
    private final Announcer announcer = EmployeeUtils.spawnAnnouncer();
    public static String announcerType = "Eager";
    private final Baker baker = EmployeeUtils.spawnBaker(announcer);
    private Demonstrator demonstrator=EmployeeUtils.spawnDemonstrator(announcer);

    // related to Robbable interface
    private StoreUtils.Record storeRecord = new  StoreUtils.Record();
    private boolean hasBeenRobbed = false;
    private boolean insuranceSettled = false;

    public StoreUtils.Record rob(StoreUtils.Record record) {

        record = Main.wares.rob(record);
        record = Main.register.rob(record);
        record = Main.wares.cookiejar.rob(record);

        this.hasBeenRobbed = true;

        return record;
    }

    public void settleInsurance(StoreUtils.Record record){

        Main.wares.settleInsurance(record);
        Main.register.settleInsurance(record);
        Main.wares.cookiejar.settleInsurance(record);
        record.settleGames();
        Wares.gameOrderedLastNight = new ArrayList<>();

        this.insuranceSettled = true;
    }
    // End of Robbable interface.


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
            this.demonstrator = EmployeeUtils.spawnDemonstrator(announcer);
            this.demonstrator.setWare(Main.wares);

            cookieMonster.VisitStore(Main.wares.cookiejar, Main.wares.gamesList, this.getCashier());
        }

        for (Customer customer:this.customers){
            Random r = new Random();
            int requestTimes = r.nextInt(2);// Request 0~3 commands
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

            if (this.hasBeenRobbed & !this.insuranceSettled){
                this.announcer.arrive(day);
                this.announcer.publish("Looks like the store got robbed last night!" +
                        " The Insurance Company has sent their agent.");

                int numGamesStolen;



                this.announcer.publish("We lost: " +
                        storeRecord.getNumGamesStolen() + " game(s), $" +
                        String.format("%.2f", storeRecord.getCashStolen()) +
                        " from the" + " cash " + "register, and " +
                        storeRecord.getNumCookiesStolen() + " cookie(s).");
                this.settleInsurance(storeRecord);

                this.announcer.publish("The store will remain closed while the insurance settles the claim.");
                this.announcer.publish("The Insurance Company states that they " +
                        "will restore $1000, all of the cookies, and some of the stolen " +
                        "games.");

                this.announcer.leave();
            }

            else {
                this.doDailyRollCall(day);
                this.doDailyMaintainence(day);
                this.doDailyBusiness();
                this.doDailyPunchOut();
            }

            if (!this.hasBeenRobbed){
                if (StoreUtils.attemptToRobIsSuccessful()){
                    this.storeRecord = this.rob(storeRecord);
                }

            }

        }
        PublishUtils.publishSummary();
    }
}
