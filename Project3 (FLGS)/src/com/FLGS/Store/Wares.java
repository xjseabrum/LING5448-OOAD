package com.FLGS.Store;// This class controls and manages what is in the
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

import com.FLGS.Games.*;
import com.FLGS.Interfaces.Robbable;
import com.FLGS.Utils.StoreUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Wares implements Robbable {
    public int totalGames;
    public double totalCash;
    public List<CashRegister> listCashReg = new ArrayList<>();
    public List<Games> gamesList = new ArrayList<>();
    public List<Games> damagedList = new ArrayList<>();
    public List<Games> gameOrderedLastNight = new ArrayList<>();
    public CookieJar cookiejar;

    //////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////
    // Constructor
    public Wares(){
        this.instantiateGames();
        this.cookiejar = new CookieJar();
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

    // Instantiate the game objects.
    public void instantiateGames(){
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
    }
    public Set<Class<?>> getGameTypeSet(){
        Set<Class<?>> TypeSet = new HashSet();
        for(Games g:this.gamesList){
            TypeSet.add(g.getClass().getSuperclass());
        }
        return TypeSet;
    }

    // Robbable Interface
    public StoreUtils.Record rob(StoreUtils.Record record) {

        int numGamesStolen = 0;
        record.setGamesStolen(this.gamesList);

        for (Games games:this.gamesList){
            numGamesStolen += games.inventory;
            games.inventory = 0;
        }

        record.setNumGamesStolen(numGamesStolen);
        return record;
    }

    public void settleInsurance(StoreUtils.Record record){
        List<Games> stolenGamesList = record.getGamesStolen() ;
        for (Games game:this.gamesList){
            int gameIndex = stolenGamesList.indexOf(game);
            game.inventory = stolenGamesList.get(gameIndex).inventory;
        }
    }
}
