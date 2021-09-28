import java.io.FileNotFoundException;

public class Main {

    public static Store store = new Store();
    public static CashRegister register = new CashRegister();
    public static Wares wares = new Wares();

    public static void main(String[] args) throws FileNotFoundException {
        store.simulate(30);

        // Testing decorator code.  Ignore.
//        Games gh = new Gloomhaven();
//        System.out.println("N: " + gh.getGameName() + " P: $" + gh.getPrice());
//
//
//        gh = new CustomMinis(gh);
//        System.out.println("N: " + gh.getGameName() + " P: $" + gh.getPrice());
    }
}
