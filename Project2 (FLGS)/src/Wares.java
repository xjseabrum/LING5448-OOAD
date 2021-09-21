// Add notes as to why this is OO
// as in, the purpose of the code (cohesion)
// what the code takes in
// what the code outputs for other objects to use.
//

import java.util.ArrayList;
import java.util.List;

public class Wares {
    public int totalGames;
    public double totalCash;
    public List<CashRegister> listCashReg = new ArrayList<>();
    public List<Games> gamesList = new ArrayList<>();
    public List<Games> damagedList = new ArrayList<>();
    public List<Games> gameOrderedLastNight=new ArrayList<>();
    //////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////
    // Constructor
    public Wares(){
        this.instantiateGames();
    }


    //////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////

    // Non-getter-setter methods
    public void addGame(Games obj){
        gamesList.add(obj);
    }
    public void removeGame(Games obj){
      gamesList.remove(obj);
    }

    public void addListCashReg(CashRegister obj){
        listCashReg.add(obj);
    }

    public void removeListCashReg(CashRegister obj){
        listCashReg.remove(obj);
    }

    public void addDamagedList(Games obj) {
        damagedList.add(obj);
    }

    public void removeDamagedList(Games obj) {
        damagedList.remove(obj);
    }

    //////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////

    // Explicit getters for (all) vars
    private double getTotalGames(){
        return gamesList.size();
    }

    public double getTotalCash(){
        totalCash = 0;
        for (int i = 0; i < listCashReg.size(); i++){
            totalCash += listCashReg.get(i).getCash();
        }
        return totalCash;
    }

    public List<CashRegister> getListCashReg(){
        return listCashReg;
    }

    public List<Games> getGames(){
        return gamesList;
    }

    public List<Games> getDamaged(){
        return damagedList;
    }

    //////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////

    // Instantiate the game objects that are specified in the assignment
    public void instantiateGames(){
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

        this.addGame(monopoly);
        this.addGame(clue);
        this.addGame(life);

        this.addGame(mousetrap);
        this.addGame(candyland);
        this.addGame(connectFour);

        this.addGame(magic);
        this.addGame(pokemon);
        this.addGame(netrunner);

        this.addGame(catan);
        this.addGame(risk);
        this.addGame(gloomhaven);
    }
}
