// This is game info.
// This contains the constants that we
// set for price, and size of the games.

// Because these are constants, they have been implemented via
// a hashmap, where the name of the game is the key for the
// gameDimensions and priceTable hashmaps.

import java.util.HashMap;

public class GameInfo {
    public HashMap<String, double[]> gameDimensions = new HashMap<>();
    public HashMap<String, Double> priceTable = new HashMap<>();

    //////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////
    // List of games and prices:
    // Prices for all games roughly reflect current real life prices.
    // (via Amazon listings)
    public String[] gameList =
            {"Monopoly", "Clue", "Life",
                    "Mousetrap", "Candyland", "Connect Four",
                    "Magic", "Pokemon", "Netrunner",
                    "Catan", "Risk", "Gloomhaven"};

    // Instantiate the sizes of the games, in order of
    // {LENGTH, WIDTH, HEIGHT} in inches.
    // Values roughly reflect real life dimensions. (via Amazon listings)
    public double[][] gameSize =
            {{15.91, 13.86, 2.36}, {15.75, 10.51, 2.01}, {15.75, 10.50, 1.63},
                    {15.90, 10.60, 3.50}, {15.76, 10.52, 1.46}, {10.51, 10.98, 1.61},
                    {3.47, 7.36, 6.50}, {3.00, 2.00, 0.75}, {5.00, 2.75, 1.00},
                    {11.63, 9.50, 3.00}, {15.75, 10.50, 1.97}, {11.50, 9.10, 4.50}};

    public double[] gamePrices = {28.00, 19.00, 20.00,
            24.90, 24.40, 12.00,
            39.88, 10.00, 12.00,
            41.90, 31.50, 50.00};

    //////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////

    // Constructor for gameDimensions and priceTable

    public HashMap<String, double[]> gameDimensions(){
        for (int i = 0; i < gameList.length; i++) {
            gameDimensions.put(gameList[i], gameSize[i]);
        }
        return gameDimensions;
    }

    public HashMap<String, Double> priceTable(){
        for (int i = 0; i < gameList.length; i++) {
            priceTable.put(gameList[i], gamePrices[i]);
        }
        return priceTable;
    }

}

