public class Close implements Action{
    @Override
    public void announce() {
        System.out.println(
                 "Cashier is leaving and the store is closed."
        );
    }

    @Override
    public void doAction() {

    }
}
