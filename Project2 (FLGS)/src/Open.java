import java.util.Random;

public class Open implements Action {
    Object store;
    Random r = new Random();
    public Open(Object store)
    {
        this.store=store;
    }
    @Override
    public void announce() {
        System.out.println("store is open");
    }
    @Override
    public void doAction() {
        int num=r.nextInt(4);
        //store.generateCustomer(num);
    }
}
