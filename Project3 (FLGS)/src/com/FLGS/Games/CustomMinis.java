package com.FLGS.Games;

// One of the concrete decorator subclasses

public class CustomMinis extends SpecialAdd {
    private int minRoll = 1;
    private int maxRoll = 4;
    public String desc = "";
    private int numBuy;
    private double addCost;
    public double totCost;

    public CustomMinis(Games g){
        super(g);
        this.price = 49.98;
    }

    public String getDesc(){
        desc = "They also bought " + this.getNumBuy() + " custom mini(s) for $" +
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
