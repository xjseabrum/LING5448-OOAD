/*
    We use the delegation here to perform each tasks. So when we need a different task, saying we want
    a different type of stack, we only needs to initiate a different class of stack and put it into CashierTask Object.

*/
public class CashierTask {
    Arrive arrive;
    Close close;
    Count count;
    Open open;
    Order order;
    Stack stack;
    Vacuum vacuum;
    Sold sold = new Sold();
    CashRegister cashRegister;
    public CashierTask(String employeeName, int arriveDay, CashRegister register,
                       Wares ware, int damageRate,Stack stack) {
        this.arrive = new Arrive(employeeName,arriveDay,ware);
        this.close = new Close();
        this.count = new Count(register);
        this.open = new Open();
        this.stack = stack;
        this.vacuum = new Vacuum(damageRate,ware);
        this.order = new Order(ware,register);
        this.cashRegister = register;
    }
    public void arrive(){
        arrive.announce();
        arrive.doAction();
    }
    public void count(){
        count.announce();
        count.doAction();
    }
    public void close(){
        close.announce();
        close.doAction();
    }
    public void open(){
        open.announce();
        open.doAction();
    }
    public void order(){
        order.announce();
        order.doAction();
    }
    public void stack(){
        stack.announce();
        stack.doAction();
    }
    public void vacuum(){
        vacuum.announce();
        vacuum.doAction();
    }
    public void sold(Games gameSold, String customerName){
        sold.doAction(gameSold,customerName,cashRegister);
    }



}
