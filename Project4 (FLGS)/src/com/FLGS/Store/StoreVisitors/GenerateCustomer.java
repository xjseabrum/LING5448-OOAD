// This is the customer factory pattern. 
// Now that customer has a fleshed out class structure, 
// the factory, when called, will generate a customer of a 
// random type.  

package com.FLGS.Store.StoreVisitors;

import com.FLGS.Utils.RandomUtils;

import java.util.Arrays;
import java.util.List;

public class GenerateCustomer {
    List<String> types = Arrays.asList("Family", "Kid", "Card", "Board");
    protected String chosenType = "No Type Chosen";

    public Customer createCustomer(){

        int randInt = RandomUtils.getRandomInt(4);
        this.chosenType = types.get(randInt);

        return switch (chosenType) {
            case "Family" -> new FamilyCustomer();
            case "Kid" -> new KidCustomer();
            case "Card" -> new CardCustomer();
            case "Board" -> new BoardCustomer();
            default -> null;
        };

    }
}
