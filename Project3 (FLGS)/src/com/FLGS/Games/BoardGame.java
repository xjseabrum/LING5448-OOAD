package com.FLGS.Games;// This is one of com.FLGS.Games.Games subclasses.
// It is a branch in the hierarchy,
// under which com.FLGS.Games.KidsGame, com.FLGS.Games.BoardGame, com.FLGS.Games.CardGame and com.FLGS.Games.FamilyGame
// inherit their shared attributes, functions, and methods.

// For now, the subclass isn't different from the other subclasses.
// The only place that they explicitly differ across subclasses is
// in the value "gameType", by which all objects under this subclass
// take on this specific value.  This is an example of identity.

// The same types of methods can be used across all the subclasses,
// representing polymorphism.


public class BoardGame extends Games{
    public BoardGame(){
        super.gameType = "Board Game";
    }
}