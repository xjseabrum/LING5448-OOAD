package com.FLGS.Games;
import com.FLGS.Utils.RandomUtils;

public abstract class SpecialAdd extends Games{
    public double cost = 0;
    public int randRoll;
    public Games g;

    // How much will we end up mapping to the base?
    public SpecialAdd(Games g){
        super.self = g;
        this.g = g;
        this.boxHeight = g.getBoxHeight();
        this.boxWidth = g.getBoxWidth();
        this.boxLength = g.getBoxLength();
        this.inventory = g.getInventory();
        this.sold = g.getSold();
        this.currentPosition = g.getCurrentPosition();
        this.damageContainer = g.getDamageContainer();
        this.gameName = g.getGameName();
        this.gameType = g.getGameType();
        this.extraBuyChance = g.getExtraBuyChance();
    }

    public int getRandRoll(int min, int max) {
        this.randRoll = RandomUtils.rand.nextInt((max - min) + 1) + min;
        return randRoll;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

}
