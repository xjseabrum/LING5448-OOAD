package com.FLGS.Store;

import com.FLGS.Games.Games;

import java.util.ArrayList;
import java.util.List;

public class Shelf {

    // Attributes.
    private List<Games> gamePile = new ArrayList<>();
    private double shelfProbability;
    int shelfNumber;

    // Commented out as we have com.FLGS.Actions.Sold.java as getits own class.
    // Kept here on the chance that we might have to implement it
    // here in the future.
    
//    public com.FLGS.Store.Shelf(int shelfNumber){
//        this.shelfNumber = shelfNumber;
//        this.shelfProbability = 0.20 - (0.02)*(shelfNumber);
//        if (this.shelfProbability <= 0){
//         this.shelfProbability = 0;
//        }
//    }

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
