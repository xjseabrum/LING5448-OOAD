import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {

    public static Store store = new Store();
    public static CashRegister register = new CashRegister();
    public static Wares wares = new Wares();

    public static void main(String[] args) throws FileNotFoundException {

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

    // Setting the game name manually
    // Surely there is a way to do this more automatically.
        monopoly.setGameName("Monopoly");
        clue.setGameName("Clue");
        life.setGameName("Life");

        mousetrap.setGameName("Mousetrap");
        candyland.setGameName("Candyland");
        connectFour.setGameName("Connect Four");

        magic.setGameName("Magic");
        pokemon.setGameName("Pokemon");
        netrunner.setGameName("Netrunner");

        catan.setGameName("Catan");
        risk.setGameName("Risk");
        gloomhaven.setGameName("Gloomhaven");

        wares.addGame(monopoly);
        wares.addGame(clue);
        wares.addGame(life);

        wares.addGame(pokemon);
        wares.addGame(netrunner);
        wares.addGame(catan);

        wares.addGame(risk);
        wares.addGame(gloomhaven);
        wares.addGame(magic);

        PrintStream fileStream = new PrintStream("Output.txt");
        System.setOut(fileStream);
       store.simulate(30);
    }
}
