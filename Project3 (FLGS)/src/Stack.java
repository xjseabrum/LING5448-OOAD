import java.util.List;

public abstract class Stack{

    public void announce() {
        System.out.println("Stacking...");
    }
    public abstract void doAction(Wares ware);
    public void announceStackOrder(Wares ware,String employeeName){
        List<Games> stack=ware.getGames();
        for (int i = 0; i < stack.size(); i++) {
            Games game = stack.get(i);
            System.out.println(employeeName + " stacked " + game.getInventory() + " " +
                    game.getGameName() + " game(s) at shelf " +
                    "position " + (i+1) + ".");
        }
    };
}
