import java.util.ArrayList;
import java.util.List;

public class FLGS {

    public static TimeLine timeLine = new TimeLine();
    public static Store store = new Store();

    public static void kickoff() throws Exception {
        Wares waresTest = new Wares();
        Games testGame=new CardGame();
        testGame.setGameName("poker");
//        waresTest.setTotalGames(0);
        System.out.println(testGame.gameName);

        //Testing section for EmployeeTask
        String employeeName="Jay";
        int arriveDay=1;
        CashRegister testRegister=new CashRegister();
        Object store=new Object();
        Wares testWare=new Wares();
        Games g1=new CardGame();
        g1.setGameName("t1");
        g1.setBoxHeight(1);
        g1.setBoxLength(1);
        g1.setBoxWidth(1);
        Games g2=new BoardGame();
        g2.setGameName("t2");
        g2.setBoxHeight(2);
        g2.setBoxLength(2);
        g2.setBoxWidth(2);
        Games g3=new FamilyGame();
        g3.setGameName("t3");
        g3.setBoxHeight(3);
        g3.setBoxLength(3);
        g3.setBoxWidth(3);
        List<Games> gameList=new ArrayList<Games>();
        gameList.add(g1);
        gameList.add(g3);
        gameList.add(g2);
//        testWare.setGames(gameList);

        int damageRate=50;
        Stack stack=new HighestFirstStack(testWare,employeeName);
        CashierTask testTask=new CashierTask(employeeName,arriveDay,testRegister,store,testWare,damageRate,stack);

        testTask.arrive();
        testTask.count();
        testTask.open();
        testTask.vacuum();
        testTask.stack();
        testTask.order();
        testTask.close();

        //Test End

    }

    public static void main(String[] args) throws Exception {
        kickoff();
    }
}
