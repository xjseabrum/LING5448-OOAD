// Add notes as to why this is OO
// as in, the purpose of the code (cohesion)
// what the code takes in
// what the code outputs for other objects to use.

import java.util.HashMap;
import java.util.Map;

public class CashRegister {
    public double cash = 0;
//    public HashMap<String, Double> priceTable = new HashMap<>();
//
//    public HashMap<String, Double> getPriceTable(){
//        return priceTable;
//    }
//
//    public void setPriceTable(String inputName, double inputVal) {
//        priceTable.put(inputName, inputVal);
//    }

    public double getCash(){
        return cash;
    }

    public void addCash(double addCash){
        this.cash += addCash;
    }

    public void removeCash(double remCash){
        this.cash -= remCash;
    }

}

