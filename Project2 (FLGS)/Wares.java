// Add notes as to why this is OO
// as in, the purpose of the code (cohesion)
// what the code takes in
// what the code outputs for other objects to use.

// import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Wares {
    public int totalGames;
    public double totalCash;
    public List<CashRegister> listCashReg = new ArrayList<>();
    public List<Games> gamesList = new ArrayList<>();
    public List<Games> damagedList = new ArrayList<>();
//    public HashMap<String, double[]> gameDimensions = new HashMap<>();

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

//    public HashMap<String, double[]> getGameDimensions(){
//        return gameDimensions;
//    }

    //////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////

    // Explicit setters for (all) vars
//    public void setGameDimensions(String inputName, double[] vals){
//        gameDimensions.put(inputName, vals);
//    }

    public void removeListCashReg(CashRegister obj){
        listCashReg.remove(obj);
    }

    public void addDamagedList(Games obj) {
        damagedList.add(obj);
    }
}
