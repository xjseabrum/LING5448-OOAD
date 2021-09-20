

public abstract class Stack implements Action {
    Wares ware;
    String EmployeeName;
    public Stack(Wares ware, String employeeName){
        this.ware=ware;
        this.EmployeeName=employeeName;
    }

    @Override
    public void announce() {
        System.out.println("stacking");
    }
}
