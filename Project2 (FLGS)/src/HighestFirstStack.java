import java.util.Comparator;
import java.util.List;

public class HighestFirstStack extends Stack{

    public HighestFirstStack(Wares ware, String EmployeeName) {
        super(ware,EmployeeName);
    }

    @Override
    public void doAction() {

        //reference https://stackoverflow.com/questions/33487063/java-8-sort-list-of-objects-by-attribute-without-custom-comparator
        List<Games> stack=ware.getGames();
        if(stack!=null && !stack.isEmpty()) {
            stack.sort(Comparator.comparing(a -> a.getBoxHeight()));
            for (int i = 0; i < stack.size(); i++) {
                Games game = stack.get(i);
                System.out.print(EmployeeName);
                int position=i+1;
                System.out.println(" stack " + game.getInventory() + " " + game.getGameName() + "game at shelf position " + position);
            }
        }
    }
}
