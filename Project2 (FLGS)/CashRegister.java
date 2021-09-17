public class CashRegister {
    public double cash = 0;

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

