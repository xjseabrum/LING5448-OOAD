import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {

    public static Store store = new Store();
    public static CashRegister register = new CashRegister();
    public static Wares wares = new Wares();


    public static void main(String[] args) throws FileNotFoundException {
        PrintStream fileStream = new PrintStream("Output.txt");
        System.setOut(fileStream);
        store.simulate(30);
        System.out.println("-----------------------------------");
        System.out.println("-----------------------------------");
        System.out.println("Games Sold and Their Generated Revenue: \n");
        for (Games game:wares.getGames()){
            System.out.println(game.getSold() + " sale(s) of " +
                               game.getGameName() + " occurred resulting in $" +
                    (float)(game.getSold() * game.getPrice()) + " of revenue.");

        }
    }

}
