// Add notes as to why this is OO
// as in, the purpose of the code (cohesion)
// what the code takes in
// what the code outputs for other objects to use.

// Refined random generator code for integers inspired from:
// https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java

import java.lang.Math;
import java.util.Random;

public class rng{
    Random rand = new Random();
    public double randomChance;
    public int randomInt;

    public double getRandomChance(){
        return randomChance;
    }
    
    public int getrandomInt(){
        return randomInt;
    }

    public void setRandomChance(){
        this.randomChance = Math.random();
    }
    
    public void setRandomInt(int maxVal){
        this.randomInt = rand.nextInt(maxVal + 1);
    }




}


