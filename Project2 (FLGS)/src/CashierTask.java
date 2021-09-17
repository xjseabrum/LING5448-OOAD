public class CashierTask {
    Arrive arrive;
    Close close;
    Count count;
    Open open;
    Stack stack;
    Vacuum vacuum;
    public CashierTask(String employeeName, int arriveDay,CashRegister register,Object store,Wares ware, int damageRate,Stack stack){
        this.arrive=new Arrive(employeeName,arriveDay);
        this.close=new Close();
        this.count=new Count(register);
        this.open=new Open(store);
        this.stack=stack;
        this.vacuum=new Vacuum(damageRate,ware);
    }


}
