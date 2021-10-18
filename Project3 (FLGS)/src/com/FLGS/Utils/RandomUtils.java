package com.FLGS.Utils;
import com.FLGS.Games.Games;
import com.FLGS.Store.StoreVisitors.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtils {
    public static Random rand = new Random();

    public static String getRandomName() {
        Random rand = new Random();


        int nameLength = rand.nextInt(6) + 3;

        // References
        // https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java

        char[] charsCons = {'a','b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
                'z'};
        char[] charsVowel = {'a', 'e', 'i', 'o', 'u'};

        StringBuilder name = new StringBuilder();

        while (name.length() < nameLength) {
            int r = rand.nextInt(charsCons.length);
            int s = rand.nextInt(charsVowel.length);
            char cons = charsCons[r];
            char vow = charsVowel[s];

            if (name.length() % 2 == 0) {
                name.append(cons);
            } else {
                name.append(vow);
            }
        }

        // Get the letters of the name, excluding the first letter
        // which has to be converted to uppercase
        String withoutFirst = name.substring(1);

        // Output the name where the first character is uppercase and
        // the rest is preserved.
        String nameOut = Character.toUpperCase(name.charAt(0)) + withoutFirst;
        return nameOut;
    }

    public static int getRandomInt(int higherBound) {
        return rand.nextInt(higherBound);
    }

    public static boolean getRandomBool() {
        return rand.nextBoolean();
    }

    public static double getRandomDouble() {
        return rand.nextDouble();
    }

    public static boolean customerBuysFromShelf(int shelfPos) {

        double shelfProbability = 0.2 - (0.02 * shelfPos);

        // Simplified if-else-statement as return
        // will always give back true or false.
        return getRandomDouble() <= shelfProbability && shelfProbability > 0;

    }

    public static boolean customerBuysFromShelf(int shelfPos, double probModifier, double[] b, Customer customer, List<Games> shelf) {
        // We can account for modifications to shelf probability if customer buys a cookie.
        double shelfProbability = 0.2 - (0.02 * shelfPos) + probModifier +
                                  b[shelfPos];
        //If the Demonstrator Demonstrates, Recommends, or Explains any game to a customer, the chance that customer will buy that instance of a game (Ex: Magic, Risk) increases by 10%
        if(customer.IntroducedGames.contains(shelf.get(shelfPos))){
            shelfProbability+=0.1;
        }

        double randomNum = getRandomDouble();
//        boolean valid = randomNum<=shelfProbability;
        return  randomNum <= shelfProbability ;

    }

    public static int poissonRandom(double mean){
        // code is a direct copy from
        // https://stackoverflow.com/questions/9832919/generate-poisson-arrival-in-java
        // removed the -1 on the return, because there should at least be 1 customer

        double L = Math.exp(-mean);
        int k = 0;
        double p = 1.0;
        do {
            p = p * rand.nextDouble();
            k++;
        } while (p > L);
        return k;
    }

}

