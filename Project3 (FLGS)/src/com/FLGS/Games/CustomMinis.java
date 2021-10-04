package com.FLGS.Games;

public class CustomMinis extends SpecialAdd {
    private int minRoll = 1;
    private int maxRoll = 4;
    public String desc;
    private int numBuy;
    private double addCost;
    public double totCost;

    public CustomMinis(Games g){
        super(g);
        this.price = 49.98;
    }

    public String getDesc(){
        desc = (" They also bought " + numBuy + "custom mini(s) for $" +
                String.format("%.2f", addCost) +
                " for a grand total of $" + totCost + ".");
        return desc;
    }


    public double getPrice(){
        numBuy = super.getRandRoll(minRoll, maxRoll);
        addCost = numBuy * this.price;
        totCost = g.getPrice() + addCost;
        return totCost;
    }
}
