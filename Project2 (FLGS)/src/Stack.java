

public abstract class Stack implements Action {
    Wares ware;
    String EmployeeName;
    GameInfo gameInfo;
    public Stack(Wares ware, String employeeName){
        this.ware=ware;
        this.EmployeeName=employeeName;
        this.gameInfo=new GameInfo();
    }

    @Override
    public void announce() {
        System.out.println("stacking");
    }
}
