import java.util.List;
import java.util.Random;

public class Vacuum {
    private DamageGame dg =new DamageGame();
    Random r = new Random();
    public void announce() {
        System.out.println("Vacuuming... ");
    }

    public void doAction(int damageRate,Wares ware) {
        //reference https://stackoverflow.com/questions/38838172/percentage-using-random/38838299
        int num=r.nextInt(100);

        if(num<=damageRate){
            dg.damageRandomGame(ware);

        }
    }
}
