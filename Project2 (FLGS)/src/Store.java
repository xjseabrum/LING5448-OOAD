import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Store {

    // attributes
    public List<Shelf> shelves = new ArrayList<Shelf>();
    public List<Customer> customers = new ArrayList<Customer>();
    public List<Cashier> cashiers = new ArrayList<Cashier>();

    // getters and setters

    // methods
    public void addShelf(){
        int shelfNumber = shelves.size();
        shelves.add(new Shelf(shelfNumber));
    }

    public void spawnCustomer(){
        customers.add(new Customer());
    }

    public void spawnCashier(String name, int arrivalDay, int vaccumDamageRate, Stack stack){
        cashiers.add(new Cashier(name, arrivalDay, Main.register, this, Main.wares, vaccumDamageRate, stack));
    }

    public void setupNewStore(int numShelves){

        // TODO: needs to be re-written after understanding init conditions.

        for (int i=0; i<=numShelves; i++) {
            this.addShelf();
        }

        for (Shelf shelf:this.shelves){
            int numGames = RandomUtils.getRandomInt(4);
            if (numGames==0){
                numGames += 1;
            }
            for (int i=0; i<= numGames; i++) {
                shelf.addToGamePile(new BoardGame());
            }
        }
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

    public void doDailyBuisness(int maxNumCustomers){
        // Employees open the shop and customers buy stuff.

        int numOfCustomers = RandomUtils.getRandomInt(maxNumCustomers);

        System.out.println(numOfCustomers+1 + " customers have visited the store today.");

        for (int c=0; c<=numOfCustomers; c++){
            // store.spawnCustomer(); (is this required?)
            Customer customer = new Customer();
            boolean customerWillBuy = RandomUtils.getRandomBool();  // they may or may not buy something
            if (customerWillBuy) {
                System.out.println("Customer named " + customer.getCustomerName() + " has bought the following game:");
                System.out.println(customer.buyGame(this.shelves));
            }
        }

    }

    public void doDailyPunchOut(){
        // Employees check the registers and inventory, order new games, close shope
        for (Cashier cashier:this.cashiers){
            cashier.tasks.close();
        }
        this.cashiers.clear();
    }
}
