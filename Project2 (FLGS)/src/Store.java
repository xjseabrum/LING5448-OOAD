import java.util.ArrayList;
import java.util.List;

public class Store {

    // attributes
//    public List<Shelf> shelves = new ArrayList<Shelf>();
    public List<Customer> customers = new ArrayList<Customer>();
    public List<Cashier> cashiers = new ArrayList<Cashier>();

    // getters and setters
    public Cashier getCashier(){
        return this.cashiers.get(0);
    }

    // methods
//    public void addShelf(){
//        int shelfNumber = shelves.size();
//        shelves.add(new Shelf(shelfNumber));
//    }

    public void spawnCustomer(){
        customers.add(new Customer());
    }

    public void spawnCashier(String name, int arrivalDay, int vaccumDamageRate, Stack stack){
        cashiers.add(new Cashier(name, arrivalDay, Main.register, this, Main.wares, vaccumDamageRate, stack));
    }

    public void doDailyRollCall(int day){
        boolean burtArrives = RandomUtils.getRandomBool();

        if (burtArrives){
            String employeeName = "Burt";
            Stack widestFirstStack = new WidestFirstStack(Main.wares, employeeName);
            this.spawnCashier(employeeName, day, 10, widestFirstStack);
        }
        else { // Ernie arrives instead!
            String employeeName = "Ernie";
            Stack highestFirstStack = new HighestFirstStack(Main.wares, employeeName);
            this.spawnCashier(employeeName, day, 5, highestFirstStack);
        }

        for (Cashier cashier:this.cashiers){
            cashier.tasks.arrive();
        }
    }

    public void doDailyMaintainence(){
        // Employees stack and vacuum.
        for (Cashier cashier:this.cashiers){
            cashier.tasks.count();
            cashier.tasks.vacuum();
            cashier.tasks.stack();
            cashier.tasks.open();
        }
    }

    public void doDailyBusiness(int maxNumCustomers){
        // Employees open the shop and customers buy stuff.

        int numOfCustomers = RandomUtils.getRandomInt(maxNumCustomers);

        System.out.println(numOfCustomers+1 + " customer(s) visited the store today.");

        for (int c=0; c<=numOfCustomers; c++){
            Customer customer = new Customer();
            System.out.println("Customer named " + customer.getCustomerName() + " is inspecting the shelves.");
            customer.buyGame(Main.wares.gamesList);
        }
    }

    public void doDailyPunchOut(){
        // Employees check the registers and inventory, order new games, close shop
        for (Cashier cashier:this.cashiers){
            cashier.tasks.order();
            cashier.tasks.close();
        }
        this.cashiers.clear();
    }

    public void simulate(int days){

        for (int day = 0; day < days; day++){
            this.doDailyRollCall(day);
            this.doDailyMaintainence();
            this.doDailyBusiness(4);
            this.doDailyPunchOut();
        }
    }


}
