import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WidestFirstStack extends Stack{

    public WidestFirstStack(Wares ware, String EmployeeName) {
        super(ware, EmployeeName);
    }

    @Override
    public void doAction() {

        //reference https://stackoverflow.com/questions/33487063/java-8-sort-list-of-objects-by-attribute-without-custom-comparator
        List<Games> stack = ware.getGames();
        if( stack!=null && !stack.isEmpty()) {
            stack.sort(Comparator.comparing(a -> a.getBoxWidth()));
            Collections.reverse(stack);
            for (int i = 0; i < stack.size(); i++) {
                Games game = stack.get(i);
                System.out.println(EmployeeName + " stacked " + game.getInventory() + " " +
                        game.getGameName() + " game(s) at shelf " +
                        "position " + (i+1) + ".");
            }
        }

    }
}
