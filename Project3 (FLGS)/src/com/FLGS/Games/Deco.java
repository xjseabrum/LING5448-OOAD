package com.FLGS.Games;
import java.util.Objects;
import com.FLGS.Store.CashRegister;

public class Deco {
    public String special = "";

    public Deco() {
    }

    public String decorate(Games g, CashRegister r) {

        if (Objects.equals(g.gameName, "Monopoly")) {
            Games g2 = g;
            g2 = new SpecialTokenPack(g2);
            this.special = g2.getDesc();
            r.addCash(g2.getAddCost());
            return special;

        } else if (Objects.equals(g.gameType, "Card Game")) {
            Games g2 = g;
            g2 = new SpecialCards(g2);
            this.special = g2.getDesc();
            r.addCash(g2.getAddCost());
            return special;

        } else if (Objects.equals(g.gameName, "Mousetrap")) {
            Games g2 = g;
            g2 = new SpareParts(g2);
            this.special = g2.getDesc();
            r.addCash(g2.getAddCost());
            return special;

        } else if (Objects.equals(g.gameName, "Gloomhaven")) {
            Games g2 = g;
            g2 = new CustomMinis(g2);
            this.special = g2.getDesc();
            r.addCash(g2.getAddCost());
            return special;

        } else {
            this.special = "";
            r.addCash(0);
            return special;
        }
    }
}
