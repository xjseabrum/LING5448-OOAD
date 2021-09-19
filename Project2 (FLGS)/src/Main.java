package src;

public class Main {

    public static TimeLine timeLine = new TimeLine();
    public static Store store = new Store();

    public static void main(){
//        I dont think timeline object is required.
//        TimeLine timeLine = new TimeLine();

        Store store = new Store();
        store.addShelf();
        store.addShelf();
        store.addShelf();

        store.spawnCashier("Burt", 0.05);
        store.spawnCashier("Ernie", 0.10);

        for (int i=0; i<=30; i++){

            int numOfCustomers = RandomUtils.getRandomInt(4);

            for (int c=0; c<=numOfCustomers; c++){
                // store.spawnCustomer(); (is this required?)
                Customer customer = new Customer();
                boolean customerWillBuy = RandomUtils.getRandomBool();
                if (customerWillBuy) {
                    customer.buyGame();
                }
            }
        }
    }
}
