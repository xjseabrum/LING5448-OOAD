// import java.util.Arrays;
import java.util.List;

public class Wares {
    public int totalGames;
//    public double totalCash;
//    public List<CashRegister> cashRegisters;
    public List<Games> games;
    public List<Games> damaged;

    public void setTotalGames(int numGames){
        this.totalGames = numGames;
    }

    public int getTotalGames(){
        return totalGames;
    }

//    public double getTotalCash(){
//        return totalCash;
//    }
//
//    public List<CashRegister> getCashRegisters(){
//        return cashRegisters;
//    }

    public List<Games> getGames(){
        return games;
    }

    public List<Games> getDamaged(){
        return damaged;
    }

//    public void setTotalCash(int startCash){
//        this.totalCash = startCash;
//    }

//    public void setCashRegisters(List<CashRegister> listReg){
//        this.cashRegisters = listReg;
//    }

    public void setGames(List<Games> listGames){
        this.games = listGames;
    }

    public void setDamaged(List<Games> listDmg){
        this.damaged = listDmg;
    }

//    private double calculateTotalCash(){
//        double sumCash = 0;
//        int listSize = this.cashRegisters.size();
//
//        for (i = 0, i < listSize, i++) {
//            sumCash += listReg[i].getCash();
//        }
//
//        return sumCash;
//    }

//    private double calculateTotalGames(){
//
//    }
//
//    public void addCashRegister(String crName){
//        crName = new CashRegister();
//        this.cashRegisters.add(crName);
//    }
//
//    public void addGame(){
//
//    }
//
//    public void removeGame(){
//
//    }
//
//    public void removeCashRegister(){
//
//    }
}
