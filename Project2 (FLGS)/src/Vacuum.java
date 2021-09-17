import java.util.List;
import java.util.Random;

public class Vacuum implements Action {
    private int damageRate;
    private Wares ware;
    Random r = new Random();
    public Vacuum(int damageRate, Wares ware){
        this.damageRate=damageRate;
        this.ware=ware;
    }
    @Override
    public void announce() {
        System.out.println("Vacuuming...");
    }

    @Override
    public void doAction() {
        //reference https://stackoverflow.com/questions/38838172/percentage-using-random/38838299
        int num=r.nextInt(100);
        if(num<=damageRate){

            //reference https://www.baeldung.com/java-random-list-element
            List<Games> gameList=ware.getGames();
            Games gameDamaged=gameList.get(r.nextInt(gameList.size()));
            //ware.removeGame(gameDamaged);
            System.out.println("game "+gameDamaged.getGameName()+" is damaged");
        }
    }
}
