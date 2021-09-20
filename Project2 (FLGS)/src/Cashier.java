//

public class Cashier extends Employee{

    int vacuumDamageRate;
    CashierTask tasks;

    public Cashier(String cashierName, int arrivalDay, CashRegister register,
                   Store store, Wares ware, int damageRate, Stack stack) {

        super(cashierName);
        this.vacuumDamageRate = damageRate;
        this.tasks = new CashierTask(cashierName, arrivalDay, register, store, ware, damageRate, stack);
        // need clarification from Jay : 1 or many cash registers?
    }
}
