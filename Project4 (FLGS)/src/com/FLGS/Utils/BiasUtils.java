package com.FLGS.Utils;
// This Utils class helps assign the correct prob modifier
// based on the customer's type and the game-type currently in stock
// the values generated here are called in RandomUtils once a customer
// goes to buy a game.

// Yes, the implementation here isn't the most efficient, but considering
// that we only have 12 types, this method of assigning bias will suffice.


import com.FLGS.Games.Games;
import com.FLGS.Store.StoreVisitors.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BiasUtils {
    public static double biasList[] = {0.0, 0.0, 0.0, 0.0,
                                0.0, 0.0, 0.0, 0.0,
                                0.0, 0.0, 0.0, 0.0};

    public static double[] assignCustomerBias(Customer c, List<Games> inv){

        List<String> invGameTypes = new ArrayList<String>();

        // Gather the current order of game types.
        for (Games games : inv) {
            invGameTypes.add(games.getGameType());
        }

        // Compare the types to the Customer's bias

        List<Integer> biasInv = new ArrayList<Integer>();
        int k = 0;
        for (int i = 0; i < inv.size(); i++){
            if(Objects.equals(invGameTypes.get(i), c.type)){
                biasInv.add(k);
                k++;
            } else {
                biasInv.add(-1);
            }

        }

        // Get indexes for when 0, 1, 2 occur in the biasInv list.
        // Yes, the search complexity is O(n), but the list is
        // currently size 12, so it doesn't matter so much for now.
        int maxIdx = Collections.max(biasInv);

        for (int m = 0; m <= maxIdx; m++){
            biasList[biasInv.indexOf(m)] = c.bonusBias[m];
        }

        return biasList;
    }

    public static void reset(){
        biasList = new double[]{0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0};
    }
}
