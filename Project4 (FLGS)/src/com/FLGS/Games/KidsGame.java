package com.FLGS.Games;
// This is one of Games subclasses.
// It is a branch in the hierarchy,
// under which KidsGame, BoardGame, CardGame and FamilyGame
// inherit their shared attributes, functions, and methods.

// For now, the subclass isn't different from the other subclasses.
// The only place that they explicitly differ across subclasses is
// in the value "gameType", by which all objects under this subclass
// take on this specific value.  This is an example of identity.

// The same types of methods can be used across all the subclasses,
// representing polymorphism.

public class KidsGame extends Games{
    public KidsGame(){
        KidsGame.super.gameType = "Kid";
    }
}