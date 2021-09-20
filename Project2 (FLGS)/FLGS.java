// Add notes as to why this is OO
// as in, the purpose of the code (cohesion)
// what the code takes in
// what the code outputs for other objects to use.

import java.util.Arrays;
import java.util.HashMap;

public class FLGS {

    public static void kickoff() throws Exception {

        // Instantiate the game info containing game prices and dimensions.
        GameInfo gameInfo = new GameInfo();

        // Create the hashmap for name - price
        for (int i = 0; i < gameInfo.gameList.length; i++){
            gameInfo.setPriceTable(gameInfo.gameList[i], gameInfo.gamePrices[i]);
        }

        // Create the hashmap for name - size
        for (int i = 0; i < gameInfo.gameList.length; i++){
            gameInfo.setGameDimensions(gameInfo.gameList[i], gameInfo.gameSize[i]);
        }

        // Instantiate the store's storeroom
        Wares storeroom = new Wares();

        // Instantiate the store's cash register
        CashRegister cashRegister = new CashRegister();
        CashRegister cr = new CashRegister();

        // Instantiate the game objects that are specified in the assignment:
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
        monopoly.setGameName("Monopoly"); monopoly.setPrice(gameInfo.getPriceTable().get("Monopoly"));
        clue.setGameName("Clue"); clue.setPrice(gameInfo.getPriceTable().get("Clue"));
        life.setGameName("Life"); life.setPrice(gameInfo.getPriceTable().get("Life"));

        mousetrap.setGameName("Mousetrap"); mousetrap.setPrice(gameInfo.getPriceTable().get("Mousetrap"));
        candyland.setGameName("Candyland"); candyland.setPrice(gameInfo.getPriceTable().get("Candyland"));
        connectFour.setGameName("Connect Four"); connectFour.setPrice(gameInfo.getPriceTable().get("Connect Four"));

        magic.setGameName("Magic"); magic.setPrice(gameInfo.getPriceTable().get("Magic"));
        pokemon.setGameName("Pokemon"); pokemon.setPrice(gameInfo.getPriceTable().get("Pokemon"));
        netrunner.setGameName("Netrunner"); netrunner.setPrice(gameInfo.getPriceTable().get("Netrunner"));

        catan.setGameName("Catan"); catan.setPrice(gameInfo.getPriceTable().get("Catan"));
        risk.setGameName("Risk"); risk.setPrice(gameInfo.getPriceTable().get("Risk"));
        gloomhaven.setGameName("Gloomhaven"); gloomhaven.setPrice(gameInfo.getPriceTable().get("Gloomhaven"));

        // Testing: Making sure all prices and dimensions print to console.
        for (int i = 0; i < gameInfo.gameList.length; i++){
            System.out.println(gameInfo.gameList[i]);
            System.out.println("Price: $" + gameInfo.getPriceTable().get(gameInfo.gameList[i]));
            System.out.println("Dim: " + Arrays.toString(gameInfo.getGameDimensions().get(gameInfo.gameList[i])));
        }
    }

    public static void main(String[] args) throws Exception {
        kickoff();
    }
}