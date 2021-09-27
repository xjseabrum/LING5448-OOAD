import java.util.ArrayList;
import java.util.List;

/*
    can't implement interface method with different input, see :
    https://stackoverflow.com/questions/14921671/an-interface-with-different-method-parameters/14921692
*/

public class Arrive implements Action{
    String employeeName;
    int arriveDay;
    Wares ware;

    public Arrive(String employeeName, int arriveDay, Wares ware){
        this.employeeName = employeeName;
        this.arriveDay = arriveDay;
        this.ware = ware;
    }

    public void announce() {
        System.out.println("---------------------------------------------------");
        System.out.println(employeeName +
                           " the Cashier arrived at the store on Day " +
                (arriveDay + 1) + ".");
    }
    public void doAction() {
        List<Games>gamesList = ware.gameOrderedLastNight;
        if(gamesList.size() > 0){
            for(Games game:gamesList){
                System.out.println("Three new orders of " +
                                    game.getGameName() + " have arrived.");
            }
        }
        ware.gameOrderedLastNight = new ArrayList<>();
    }
}
