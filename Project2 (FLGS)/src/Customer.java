import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Customer {

    // Attributes.
    private String name;
    private List<Double> shelfPreferenceProbability = new ArrayList<>();

    public Customer(String name){
        this.name = name;
//        shelfPreferenceProbability.addAll(Arrays.asList(0.8, 0.82, 0.84, 0.86, 0.88, 0.90, 0.92, 0.94, 0.96, 0.98, 1.0));
    }

    public Customer(){
        name = RandomUtils.getRandomName(6);
//        shelfPreferenceProbability.addAll(Arrays.asList(0.8, 0.82, 0.84, 0.86, 0.88, 0.90, 0.92, 0.94, 0.96, 0.98, 1.0));

    }

    //Getters and Setters.
    public String getCustomerName(){
        return name;
    }

    public List<Double> getShelfPreferenceProbability(){
        return shelfPreferenceProbability;
    }

    //Methods.
    public Shelf selectShelf(List<Shelf> shelves){

        int selectedShelfIndex = RandomUtils.getRandomInt(shelves.size());
        return shelves.get(selectedShelfIndex);
    }

    public int selectGame(){

        double probabilityOfBuy = RandomUtils.getRandomDouble();
        int i = 0;

        while (i < shelfPreferenceProbability.size()){
            if (probabilityOfBuy <= shelfPreferenceProbability.get(i)){
                return i-1;
            }
            i++;
        }
        return -1;
    }

    public void buyGame(List<Games> shelf){

        List<Games> inInventory = new ArrayList<>();
        for (Games gameInInventory:shelf){
            if (gameInInventory.getInventory() > 0) {
                inInventory.add(gameInInventory);
            }
        }

        for (int i = 0; i<=inInventory.size(); i++){

            if (RandomUtils.customerBuysFromShelf(i)) {
                System.out.println("Customer " + this.name + " selected " + inInventory.get(i).getGameName() + ".");
                Main.store.getCashier().tasks.sold(inInventory.get(i), this.getCustomerName());
                return;
            }
        }
        System.out.println("Customer " + this.name + " did not purchase anything and left the store.");
    }
}
