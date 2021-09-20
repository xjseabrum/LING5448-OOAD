import java.util.ArrayList;
import java.util.List;

/*
    can't implements interface method with different input, see :
    https://stackoverflow.com/questions/14921671/an-interface-with-different-method-parameters/14921692
*/
public class Arrive implements Action{
    String employeeName;
    int arriveDay;
    List<Games> gameOrderedLastNight = new ArrayList<>();
    public Arrive(String employeeName, int arriveDay){
        this.employeeName = employeeName;
        this.arriveDay = arriveDay;
    }
    public void announce() {
        System.out.println("---------------------------------------------------");
        System.out.println(employeeName +
                           " the Cashier arrived at the store on Day " +
                (arriveDay + 1) );
    }
    public void doAction() {
        if(gameOrderedLastNight.size() > 0){
            for(Games game:gameOrderedLastNight){
                System.out.println("Three new orders of " +
                                    game.getGameName() + " have been placed " +
                                    "and will be in stock tomorrow.");
            }
        }
        this.gameOrderedLastNight = new ArrayList<>();
    }
    public void setOrderedGames(List<Games> games){
        this.gameOrderedLastNight = games;
    }
}
