

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WidestFirstStack extends Stack{

    public WidestFirstStack(Wares ware, String EmployeeName) {
        super(ware,EmployeeName);
    }

    @Override
    public void doAction() {

        //reference https://stackoverflow.com/questions/33487063/java-8-sort-list-of-objects-by-attribute-without-custom-comparator
        List<Games> stack=ware.getGames();
        if(stack!=null && !stack.isEmpty()) {
            stack.sort(Comparator.comparing(a -> a.getBoxWidth()));
            for (int i = 0; i < stack.size(); i++) {
                Games game = stack.get(i);
                System.out.print(EmployeeName + "stack" + game.getInventory() + " " + game.getGameName() + " in shelf position" + i);
            }
        }

    }
}
