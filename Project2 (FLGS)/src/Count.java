public class Count implements Action {

    // We should pass information through object
    // rather than method parameter,
    // see https://stackoverflow.com/questions/4367347/constructor-parameters-vs-method-parameters

    CashRegister cashRegister;
    public int cashFairyCounter = 0;

    public Count(CashRegister register){
        cashRegister = register;
    }
    public void announce(){
        double cash = Math.round(cashRegister.getCash() * 100.0) / 100.0;
        System.out.println("The cash register currently has $" +
                String.format("%.2f", cash));
    }

    public void doAction(){
        double cash = cashRegister.getCash();
        double moneyAdded = 1000;
        if(cash < 100){
            this.cashFairyCounter += 1
            cashRegister.addCash(moneyAdded);
            System.out.println(
                    "The Cash Fairy graciously and magically added $" +
                    String.format("%.2f", moneyAdded) + " to the cash register.");
            announce();
        }
    }
}
