// Add notes as to why this is OO
// as in, the purpose of the code (cohesion)
// what the code takes in
// what the code outputs for other objects to use.

import java.util.Arrays;
import java.util.HashMap;

public class FLGS {
    public static void kickoff() throws Exception {

        // Instantiate the store's storeroom
        Wares storeroom = new Wares();

        // Instantiate the store's cash register
        CashRegister cashRegister = new CashRegister();
        CashRegister cr = new CashRegister();

        // Testing to see if addCash adds to separate registers
        cashRegister.addCash(500.7);
        cr.addCash(897.61);

        // Testing: adding regs to list
        storeroom.addListCashReg(cashRegister);
        storeroom.addListCashReg(cr);

        // Testing: calling method to add across objects in list
        System.out.println(storeroom.getTotalCash());

        // Testing: getting list of registers
        // Currently only gives a pointer because we don't name
        // our cash registers (not that we need to)
        System.out.println(storeroom.getListCashReg());

        // List of games and prices:
        // Prices for all games roughly reflect current real life prices.
        // (via Amazon listings)
        String[] gameList = {"Monopoly", "Clue", "Life",
                             "Mousetrap", "Candyland", "Connect Four",
                             "Magic", "Pokemon", "Netrunner",
                             "Catan", "Risk", "Gloomhaven"};

        double[] gamePrices = {28.00, 19.00, 20.00,
                              24.90, 24.40, 12.00,
                              39.88, 10.00, 12.00,
                              41.90, 31.50, 50.00};

        // Instantiate the sizes of the games, in order of
        // {LENGTH, WIDTH, HEIGHT} in inches.
        // Values roughly reflect real life dimensions. (via Amazon listings)

        double[][] gameSize = {{15.91, 13.86, 2.36}, {15.75, 10.51, 2.01}, {15.75, 10.50, 1.63},
                               {15.90, 10.60, 3.50}, {15.76, 10.52, 1.46}, {10.51, 10.98, 1.61},
                               {3.47, 7.36, 6.50}, {3.00, 2.00, 0.75}, {5.00, 2.75, 1.00},
                               {11.63, 9.50, 3.00}, {15.75, 10.50, 1.97}, {11.50, 9.10, 4.50}};

        // Create the hashmap for name - price
        for (int i = 0; i < gameList.length; i++){
            cashRegister.setPriceTable(gameList[i], gamePrices[i]);
        }

        // Create the hashmap for name - size
        for (int i = 0; i < gameList.length; i++){
            storeroom.setGameDimensions(gameList[i], gameSize[i]);
        }

        // Instantiate the game objects that are specified in the assignment:

        // Instantiate the games.
        FamilyGame monopoly = new FamilyGame();
        FamilyGame clue = new FamilyGame();
        FamilyGame life = new FamilyGame();

        KidsGame mousetrap = new KidsGame();
        KidsGame candyland = new KidsGame();
        KidsGame connectFour = new KidsGame();

        CardGame magic = new CardGame();
        CardGame pokemon = new CardGame();
        CardGame netrunner = new CardGame();

        BoardGame catan = new BoardGame();
        BoardGame risk = new BoardGame();
        BoardGame gloomhaven = new BoardGame();

        // Setting the game name manually and then using that key to set the
        // price from the hashmap.  Unsure if this is a best practice
        // so if you want to edit it, please do so.
        monopoly.setGameName("Monopoly"); monopoly.setPrice(cashRegister.getPriceTable().get("Monopoly"));
        clue.setGameName("Clue"); clue.setPrice(cashRegister.getPriceTable().get("Clue"));
        life.setGameName("Life"); life.setPrice(cashRegister.getPriceTable().get("Life"));

        // Instantiate the kids games
        mousetrap.setGameName("Mousetrap"); mousetrap.setPrice(cashRegister.getPriceTable().get("Mousetrap"));
        candyland.setGameName("Candyland"); candyland.setPrice(cashRegister.getPriceTable().get("Candyland"));
        connectFour.setGameName("Connect Four"); connectFour.setPrice(cashRegister.getPriceTable().get("Connect Four"));

        // Instantiate the card games
        magic.setGameName("Magic"); magic.setPrice(cashRegister.getPriceTable().get("Magic"));
        pokemon.setGameName("Pokemon"); pokemon.setPrice(cashRegister.getPriceTable().get("Pokemon"));
        netrunner.setGameName("Netrunner"); netrunner.setPrice(cashRegister.getPriceTable().get("Netrunner"));

        // Instantiate the boardgames
         catan.setGameName("Catan"); catan.setPrice(cashRegister.getPriceTable().get("Catan"));
         risk.setGameName("Risk"); risk.setPrice(cashRegister.getPriceTable().get("Risk"));
         gloomhaven.setGameName("Gloomhaven"); gloomhaven.setPrice(cashRegister.getPriceTable().get("Gloomhaven"));

        for (int i = 0; i < gameList.length; i++){
            System.out.println(gameList[i]);
            System.out.println("Price: $" + cashRegister.getPriceTable().get(gameList[i]));
            System.out.println("Dim: " + Arrays.toString(storeroom.getGameDimensions().get(gameList[i])));
        }

    }

    public static void main(String[] args) throws Exception {
        kickoff();
    }
}
