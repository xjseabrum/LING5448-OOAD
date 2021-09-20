public class Main {

    public static Store store = new Store();
    public static CashRegister register = new CashRegister();
    public static Wares wares = new Wares();


    public static void main(String[] args){

        FamilyGame monopoly = new FamilyGame();
        FamilyGame clue = new FamilyGame();
        FamilyGame life = new FamilyGame();


        CardGame magic = new CardGame();
        CardGame pokemon = new CardGame();
        CardGame netrunner = new CardGame();

        BoardGame catan = new BoardGame();
        BoardGame risk = new BoardGame();
        BoardGame gloomhaven = new BoardGame();

        wares.addGame(monopoly);
        wares.addGame(monopoly);
        wares.addGame(clue);
        wares.addGame(life);
        wares.addGame(pokemon);
        wares.addGame(netrunner);
        wares.addGame(catan);
        wares.addGame(risk);
        wares.addGame(gloomhaven);
        wares.addGame(magic);

       store.simulate(30);
    }
}
