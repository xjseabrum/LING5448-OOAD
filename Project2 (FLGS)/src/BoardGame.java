// This is one of Games subclasses.
// It is a branch in the hierarchy,
// under which KidsGame, BoardGame, CardGame and FamilyGame
// inherit their shared attributes, functions, and methods.


public class BoardGame extends Games{
    public BoardGame(){
        BoardGame.super.gameType = "Board Game";
    }
}