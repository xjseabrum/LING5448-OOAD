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

        FamilyGame monopoly = new FamilyGame();
        FamilyGame clue = new FamilyGame();
        FamilyGame life = new FamilyGame();


        CardGame magic = new CardGame();
        CardGame pokemon = new CardGame();
        CardGame netrunner = new CardGame();

        BoardGame catan = new BoardGame();
        BoardGame risk = new BoardGame();
        BoardGame gloomhaven = new BoardGame();

        List<Games> gameList=new ArrayList<Games>();
        gameList.add(monopoly);
        gameList.add(clue);
        gameList.add(life);
        gameList.add(pokemon);
        gameList.add(netrunner);
        gameList.add(catan);
        gameList.add(risk);
        gameList.add(gloomhaven);
        gameList.add(magic);

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
