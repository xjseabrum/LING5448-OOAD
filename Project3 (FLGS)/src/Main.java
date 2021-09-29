import java.io.FileNotFoundException;

public class Main {

    public static Store store = new Store();
    public static CashRegister register = new CashRegister();
    public static Wares wares = new Wares();

    public static void main(String[] args) throws FileNotFoundException {
        store.simulate(30);

        // Testing decorator code.  Ignore.
//        Games gh = new Gloomhaven();
//        System.out.println("N: " + gh.getGameName() + " P: $" + gh.getPrice() +
//                "BL: " + gh.getBoxLength() + "\n");
//
////        SpecialAdd gh = new CustomMinis(gh);
//
////        gh = (SpecialAdd) new CustomMinis(gh);
//        gh = new CustomMinis(gh);
//        System.out.println("N: " + ((SpecialAdd) gh).g.getGameName() + " P: $" + gh.getPrice() +
//                "BL: " + ((SpecialAdd) gh).g.getBoxLength() + "\n");
//
//        gh = new SpecialCards(gh);
//        System.out.println("N: " + ((SpecialAdd) gh).g.getGameName() + " P: $" + gh.getPrice() +
//                "BL: " + ((SpecialAdd) gh).g.getBoxLength() + "\n");
//
//        System.out.println(gh.getPrice());
    }
}
