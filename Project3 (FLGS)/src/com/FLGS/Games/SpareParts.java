package com.FLGS.Games;

public class SpareParts extends SpecialAdd {
    private int minRoll = 1;
    private int maxRoll = 2;
    public String desc;
    private int numBuy;
    private double addCost;
    public double totCost;


    public SpareParts(Games g){
        super(g);
        this.price = 7.00;
    }

    public String getDesc(){
        desc = (" They also bought " + numBuy + " spare parts kit(s) for $" +
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
