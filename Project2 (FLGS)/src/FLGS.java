public class FLGS {
    public static void kickoff() throws Exception {
        Wares waresTest = new Wares();
        Games testGame=new CardGame();
        testGame.setGameName("poker");
        waresTest.setTotalGames(0);
        System.out.println(testGame.gameName);
    }

    public static void main(String[] args) throws Exception {
        kickoff();
    }
}
