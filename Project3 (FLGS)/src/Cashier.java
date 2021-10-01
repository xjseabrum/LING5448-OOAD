//An example of inheritance - Cashier has inherited from Employee.
// You can even see the super() constructor.

// An example of cohesion - The functionality of tasks has been delegated to CashierTask,
// making Cashier more cohesive with what it does (handling information regarding cashier.)

public class Cashier extends Employee{

    int vacuumDamageRate;
    CashierTask tasks;

    public Cashier(String cashierName, int arrivalDay, CashRegister register
                   , Wares ware, int damageRate, Stack stack) {

        super(cashierName);
        this.vacuumDamageRate = damageRate;
        this.tasks = new CashierTask(stack);
        // TODO: Jay, please clarify 1 or many cash registers?
    }
}
