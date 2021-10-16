package com.FLGS.Utils;


import com.FLGS.Store.Employees.Announcer;
import com.FLGS.Store.Employees.Baker;
import com.FLGS.Store.Employees.Cashier;
import com.FLGS.Actions.WidestFirstStack;
import com.FLGS.Actions.HighestFirstStack;
import com.FLGS.Actions.SingleLastStack;
import com.FLGS.Store.Employees.Demonstrator;
import com.FLGS.Store.Wares;

public class EmployeeUtils {

    public static Announcer spawnAnnouncer(){
        return new Announcer("Guy");
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
