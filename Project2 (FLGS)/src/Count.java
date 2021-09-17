public class Count implements Action {
    //we should pass information through object rather than method parameter, see https://stackoverflow.com/questions/4367347/constructor-parameters-vs-method-parameters
    CashRegister cashRegister;
    public Count(CashRegister register){
        cashRegister=register;
    }
    public void announce(){
        double cash=cashRegister.getCash();
        System.out.println("cash register now have "+ cash);
    }
    public void doAction(){
        double cash =cashRegister.getCash();
        int moneyAdded=1000;
        if(cash <100){
            cashRegister.addCash(moneyAdded);
            System.out.println(moneyAdded+" dollar is added to the cash register");
            announce();
        }
    }
}
