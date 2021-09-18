/*
    can't implements interface method with different input, see :
    https://stackoverflow.com/questions/14921671/an-interface-with-different-method-parameters/14921692
*/
public class Arrive implements Action{
    String employeeName;
    int arriveDay;
    public Arrive(String employeeName, int arriveDay){
        this.employeeName=employeeName;
        this.arriveDay=arriveDay;
    }
    public void announce() {
        System.out.println(employeeName+" the Cashier has arrived at the store on Day "+arriveDay);
    }
    public void doAction() {
        System.out.println("inventory arrived");
    }
}
