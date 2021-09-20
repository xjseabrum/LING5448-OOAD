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
        System.out.println("The store is open for business.");
    }

    @Override
    public void doAction() {
        //Here would do nothing because customer coming and customer buying is implemented in Store.java
    }
}
