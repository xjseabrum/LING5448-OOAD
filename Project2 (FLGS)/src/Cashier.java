package src;

public class Cashier extends Employee{

    double vaccumDamageRange;
    CashierTask cashierTask;

    public Cashier(String name, double vaccumDamageRange){
        super(name);
        this.vaccumDamageRange = vaccumDamageRange;

        // need clarification from Wei Tung over how to implement cashier tasks.
    }



}
