package com.FLGS.Games;

public class SpecialTokenPack extends SpecialAdd {
    public String desc;
    private double addCost;
    public double totCost;

    public SpecialTokenPack(Games g){
        super(g);
        this.price = 6.00;
    }

    public String getDesc(){
        desc = (" They also bought 1 special token pack for $" +
                String.format("%.2f", addCost) +
                " for a grand total of $" + totCost + ".");
        return desc;
    }

    public double getPrice(){
        totCost = g.getPrice() + this.price;
        return totCost;
    }
}
