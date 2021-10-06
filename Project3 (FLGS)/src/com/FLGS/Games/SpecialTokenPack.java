package com.FLGS.Games;

public class SpecialTokenPack extends SpecialAdd {
    public String desc;
    private int numBuy;
    private double addCost;
    public double totCost;

    public SpecialTokenPack(Games g){
        super(g);
        this.price = 6.00;
    }

    public String getDesc(){
        desc = "They also bought " + this.getNumBuy() + " special token pack for $" +
                String.format("%.2f", this.getAddCost()) +
                " for a grand total of $" + String.format("%.2f", this.getPrice())
                + ".";
        return desc;
    }

    public int getNumBuy(){
        this.numBuy = 1;
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
