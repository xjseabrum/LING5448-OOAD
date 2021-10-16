package com.FLGS.Test;

import com.FLGS.Games.DamageGame;
import com.FLGS.Games.Games;
import com.FLGS.Store.Wares;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DamageGameTest {

    @Test
    void damageRandomGame() {
        Wares testWare=new Wares();
        DamageGame obj= new DamageGame();

        Games gamesBeforeDamaged;
        Games gameDamaged=obj.damageRandomGame(testWare.getGames());
        int after=testWare.getGames().size();

        assertTrue(after==before-1);

    }
}