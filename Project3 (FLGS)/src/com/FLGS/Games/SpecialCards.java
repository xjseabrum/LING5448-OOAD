package com.FLGS.Games;

public class SpecialCards extends SpecialAdd{
    private int minRoll = 1;
    private int maxRoll = 6;
    public String desc;
    private int numBuy;
    private double addCost;
    public double totCost;

    public SpecialCards(Games g) {
        super(g);
        this.price = 3.00;
    }

    public String getDesc(){
        desc = " They also bought " + this.getNumBuy() + " special card(s) for $" +
                String.format("%.2f", this.getAddCost()) +
                " for a grand total of $" + String.format("%.2f", this.getPrice())
                + ".";
        return desc;
    }

    public int getNumBuy(){
        this.numBuy = super.getRandRoll(minRoll, maxRoll);
        return numBuy;
    }

    public double getAddCost(){
        this.addCost = this.numBuy * this.price;
        return addCost;
    }

    public double getPrice(){
        this.totCost = (g.getPrice() + this.addCost);
        return totCost;
    }
}
