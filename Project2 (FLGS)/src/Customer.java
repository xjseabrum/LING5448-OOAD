import java.util.ArrayList;
import java.util.List;

public class Customer {

    // Attributes.
    private String name;
    private List<Double> shelfPreferenceProbability = new ArrayList<>();

    public Customer(String name){
        this.name = name;
    }

    public Customer(){
        this.name = RandomUtils.getRandomName(10);
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

    public Games selectGame(Shelf shelf){

        int selectedGameIndex = RandomUtils.getRandomInt(shelf.getGamePile().size());
        return shelf.getGamePile().get(selectedGameIndex);
    }

    public Games buyGame(List<Shelf> shelves){

        Shelf shelf = selectShelf(shelves);
        Games game = selectGame(shelf);
//        boolean ifGameBought = shelf.removeFromGamePile(game);

        // TODO: Check if game is not found and then raiseError?
        // TODO: Collab with Wei Tung on how to inform employee about the game

        return game;
    }
}
