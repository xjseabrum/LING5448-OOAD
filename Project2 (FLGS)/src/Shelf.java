package src;

import java.util.ArrayList;
import java.util.List;

public class Shelf {

    // Attributes.
    private List<Games> gamePile = new ArrayList<>();
    private double shelfProbability;
    int shelfNumber;

    public Shelf(int shelfNumber, double shelfProbability){
        this.shelfNumber = shelfNumber;
        this.shelfProbability = shelfProbability;
    }

    public Shelf(int shelfNumber){
        this.shelfNumber = shelfNumber;
        this.shelfProbability = 0.20;
    }

    //Getters and Setters.
    public List<Games> getGamePile(){
        return gamePile;
    }

    public double getShelfProbability(){
        return shelfProbability;
    }

    public void setShelfProbability(double shelfProbability) {
        this.shelfProbability = shelfProbability;
    }

    // Methods.
    public void addToGamePile(Games game){
        gamePile.add(game);
    }

    public boolean removeFromGamePile(Games gameToRemove){

        // Returns false if the game was not present in the pile.

        // References:
        // https://www.geeksforgeeks.org/remove-element-arraylist-java/

        int i = 0;

        for (Games game : gamePile) {

            if (game.getGameName().equals(gameToRemove.getGameName())) {
                gamePile.remove(i);
                return true;
            }
            i += 1;
        }

        // return false if game is not found.
        return false;
    }
}
