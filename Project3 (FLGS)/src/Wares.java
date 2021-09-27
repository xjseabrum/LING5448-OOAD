// This class controls and manages what is in the
// ware-room of the store. It provides a great example of
// encapsulation as it takes care of the information that
// will vary with the games in the store in the background

// It has the following related responsibilities:
// 1. Get a list of games (those that are in-stock, broken, and ordered
// the previous night.)
// 2. Get a list of cashRegisters so that total cash in store can be
// calculated. (for now, there is only one register, but there is a
// possibility that a register could break in the future and need to be
// ordered.)

// Because this class controls what games are in the store, it
// is instantiates the games and assigns them their prices.

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
    public Wares() throws Exception{
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
    public void instantiateGames() throws Exception {
        this.addGame(new Monopoly());
        this.addGame(new Clue());
        this.addGame(new Life());

        this.addGame(new Mousetrap());
        this.addGame(new Candyland());
        this.addGame(new ConnectFour());

        this.addGame(new Magic());
        this.addGame(new Pokemon());
        this.addGame(new Netrunner());

        this.addGame(new Catan());
        this.addGame(new Risk());
        this.addGame(new Gloomhaven());

//        FamilyGame monopoly = new Monopoly();
//        FamilyGame clue = new Clue();
//        FamilyGame life = new Life();
//
//        KidsGame mousetrap = new Mousetrap();
//        KidsGame candyland = new Candyland();
//        KidsGame connectFour = new ConnectFour();
//
//        CardGame magic = new Magic();
//        CardGame pokemon = new Pokemon();
//        CardGame netrunner = new Netrunner();
//
//        BoardGame catan = new Catan();
//        BoardGame risk = new Risk();
//        BoardGame gloomhaven = new Gloomhaven();

//        monopoly.setGameName("Monopoly");
//        clue.setGameName("Clue");
//        life.setGameName("Life");
//
//        mousetrap.setGameName("Mousetrap");
//        candyland.setGameName("Candyland");
//        connectFour.setGameName("Connect Four");
//
//        magic.setGameName("Magic");
//        pokemon.setGameName("Pokemon");
//        netrunner.setGameName("Netrunner");
//
//        catan.setGameName("Catan");
//        risk.setGameName("Risk");
//        gloomhaven.setGameName("Gloomhaven");

//        this.addGame(monopoly);
//        this.addGame(clue);
//        this.addGame(life);
//
//        this.addGame(mousetrap);
//        this.addGame(candyland);
//        this.addGame(connectFour);
//
//        this.addGame(magic);
//        this.addGame(pokemon);
//        this.addGame(netrunner);
//
//        this.addGame(catan);
//        this.addGame(risk);
//        this.addGame(gloomhaven);
    }
}
