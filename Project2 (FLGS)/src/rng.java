// This code is cohesive as it only deals with
// returning a random value.  This random value is then
// used to determine one of the following:

// How many customers arrive to the store that day
// The chance that one of the cashiers breaks a game
// The chance that one of the shelves is chosen.

// Refined random generator code for integers inspired from:
// https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java

import java.lang.Math;
import java.util.Random;

public class rng{
    Random rand = new Random();
    public double randomChance;
    public int randomInt;

    // Returns a random number between [0, 1).
    public double getRandomChance(){
        this.randomChance = Math.random();
        return randomChance;
    }

    // Returns a random integer between [0, Max].
    public int getRandomInt(int maxVal){
        this.randomInt = rand.nextInt(maxVal + 1);
        return randomInt;
    }




}


