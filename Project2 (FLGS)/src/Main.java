import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {

    public static Store store = new Store();
    public static CashRegister register = new CashRegister();
    public static Wares wares = new Wares();

    public static void main(String[] args) throws FileNotFoundException {
        wares.instantiateGames();
        PrintStream fileStream = new PrintStream("Output.txt");
        System.setOut(fileStream);
        store.simulate(30);
    }
}
