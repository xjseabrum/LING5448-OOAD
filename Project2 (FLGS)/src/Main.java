public class Main {

    public static TimeLine timeLine = new TimeLine();
    public static Store store = new Store();
    public static CashRegister register = new CashRegister();
    public static Wares wares = new Wares();


    public static void main(String[] args){


        store.setupNewStore(1);
        // TODO: wares.setupWares() for init conditions of inventory


        for (int day=0; day<=30; day++){

            // Arrive
            store.doDailyRollCall(day);

            // Count, Vacuum, Stack, Open
            store.doDailyMaintainence();


            // Sell to customers
            // TODO: CashierTask "Sell()"
            store.doDailyBuisness(4);


            // Order
            // Close
            store.doDailyPunchOut();
            System.out.println("\n\n");
        }
    }
}
