import java.util.ArrayList;
import java.util.List;

/*
    can't implements interface method with different input, see :
    https://stackoverflow.com/questions/14921671/an-interface-with-different-method-parameters/14921692
*/
public class Arrive implements Action{
    String employeeName;
    int arriveDay;
    List<Games> gameOrderedLastnight=new ArrayList<>();
    public Arrive(String employeeName, int arriveDay){
        this.employeeName=employeeName;
        this.arriveDay=arriveDay;
    }
    public void announce() {
        System.out.println(employeeName+" the Cashier has arrived at the store on Day "+arriveDay);
    }
    public void doAction() {
        if(gameOrderedLastnight.size()>0){
            for(Games game:gameOrderedLastnight){
                System.out.println("game "+game.getGameName()+" arrived");
            }
        }
    }
    public void setOrderedGames(List<Games> games){
        this.gameOrderedLastnight=games;
    }
}
