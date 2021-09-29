//An example of encapsulation - Store.customers and Store.cashiers are encapsulated and can only be accessed
//via getter and setter. Store methods such as doDailyRollCall(), doDailyMaintenance, doDailyBusiness, doDailyClose
//are all private because they need (and should) not be accessed outside of Store.simulate().

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Store {

    // attributes
//    public List<Shelf> shelves = new ArrayList<Shelf>();
    private List<Customer> customers = new ArrayList<Customer>();
    private List<Cashier> cashiers = new ArrayList<Cashier>();

    // getters and setters
    public Cashier getCashier(){
        // only one cashier per day. no need to query further.
        // change depending on requirements in next sprint.
        return this.cashiers.get(0);
    }

    // methods
//    public void addShelf(){
//        int shelfNumber = shelves.size();
//        shelves.add(new Shelf(shelfNumber));
//    }

    public void spawnCustomer(){
        //one customer at a time in store.
        //change depending on requirements in next sprint.
        customers.add(new Customer());
    }

    public void spawnCashier(String name, int arrivalDay, int vacuumDamageRate, Stack stack){
        cashiers.add(new Cashier(name, arrivalDay, Main.register, Main.wares, vacuumDamageRate, stack));
    }

    private void doDailyRollCall(int day){
        // Which cashier arrives today? Coin toss to decide and Cashier.tasks.arrive()
        boolean burtArrives = RandomUtils.getRandomBool();

        if (burtArrives){
            String employeeName = "Burt";
            Stack widestFirstStack = new WidestFirstStack();
            this.spawnCashier(employeeName, day, 10, widestFirstStack);
        }
        else { // Ernie arrives instead!
            String employeeName = "Ernie";
            Stack highestFirstStack = new HighestFirstStack();
            this.spawnCashier(employeeName, day, 5, highestFirstStack);
        }

        for (Cashier cashier:this.cashiers){
            cashier.tasks.arrive(cashier.getName(),day,Main.wares);
        }
    }

    private void doDailyMaintainence(){
        // Employees stack and vacuum.
        for (Cashier cashier:this.cashiers){
            cashier.tasks.count(Main.register);
            cashier.tasks.vacuum(Main.wares,cashier.vacuumDamageRate);
            cashier.tasks.stack(Main.wares,cashier.getName());
            cashier.tasks.open();
        }
    }

    private void doDailyBusiness(int maxNumCustomers){
        // Employees open the shop and customers buy stuff.

        int numOfCustomers = RandomUtils.getRandomInt(maxNumCustomers);

        System.out.println(numOfCustomers+1 + " customer(s) visited the store today.");

        for (int c=0; c<=numOfCustomers; c++){
            Customer customer = new Customer();
            System.out.println("Customer named " + customer.getCustomerName() + " is inspecting the shelves.");
            customer.buyGame(Main.wares.gamesList);
        }
    }

    private void doDailyPunchOut(){
        // Employees check the registers and inventory, order new games, close shop
        for (Cashier cashier:this.cashiers){
            cashier.tasks.order(Main.wares,Main.register);
            cashier.tasks.close();
        }
        this.cashiers.clear();
    }

    public void writeSummary() {
        System.out.println("-----------------------------------");
        System.out.println("\n-----------------------------------");
        System.out.println("Games Sold and Their Generated Revenue: \n");
        for (Games game : Main.wares.getGames()) {
            System.out.println(game.getSold() + " sale(s) of " +
                    game.getGameName() + " occurred, generating $" +
                    String.format("%.2f", (float) (game.getSold() *
                            game.getPrice())) + " of revenue.");
        }
    }

    public void simulate(int days) throws FileNotFoundException {

        this.storeUtils();

        for (int day = 0; day < days; day++){
            this.doDailyRollCall(day);
            this.doDailyMaintainence();
            this.doDailyBusiness(4);
            this.doDailyPunchOut();
        }
        this.writeSummary();
    }

    public void storeUtils () throws FileNotFoundException {
        PrintStream fileStream = new PrintStream("Output.txt");
        System.setOut(fileStream);
    }


}
