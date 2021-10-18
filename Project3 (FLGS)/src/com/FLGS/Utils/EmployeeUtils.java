package com.FLGS.Utils;


import com.FLGS.Store.Employees.*;
import com.FLGS.Actions.WidestFirstStack;
import com.FLGS.Actions.HighestFirstStack;
import com.FLGS.Actions.SingleLastStack;
import com.FLGS.Store.Store;
import com.FLGS.Store.Wares;

public class EmployeeUtils {

    public static Announcer spawnAnnouncer(){
        if (Store.announcerType == "Eager"){
            return EagerAnnouncer.getInstance();
        } else {
            return LazyAnnouncer.getInstance();
        }
    }

    public static Cashier spawnCashier(Announcer announcer){
        int cashierSelector = RandomUtils.getRandomInt(3)+1;
        Cashier cashier;

        if (cashierSelector==1){
            cashier = new Cashier("Burt", 10, new WidestFirstStack());
        }

        else if (cashierSelector==2) {
            cashier = new Cashier("Ernie", 5, new HighestFirstStack());
        }

        else {
            cashier = new Cashier("Bart", 2, new SingleLastStack());
        }
        cashier.setSubscriber(announcer);
        return cashier;
    }

    public static Baker spawnBaker(Announcer announcer){
        Baker baker = new Baker("Gonger");
        baker.setSubscriber(announcer);
        return baker;
    }
    public static Demonstrator spawnDemonstrator(Announcer announcer){
        String name=RandomUtils.getRandomName();
        Demonstrator demonstrator=new Demonstrator(name);
        demonstrator.setSubscriber(announcer);
        return demonstrator;
    }


}
