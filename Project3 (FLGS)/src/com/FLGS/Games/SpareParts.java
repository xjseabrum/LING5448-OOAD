package com.FLGS.Games;

public class SpareParts extends SpecialAdd {
    private int minRoll = 1;
    private int maxRoll = 2;

    public SpareParts(Games g){
        super(g);
        this.price = 7.00;
    }

    public double getPrice(){
        int numBuy = super.getRandRoll(minRoll, maxRoll);
        double addCost = numBuy * this.price;
        double totCost = g.getPrice() + addCost;
        System.out.println(" and " + numBuy + " spare parts kit(s) for $" +
                String.format("%.2f", addCost) +
                " for a grand total of $" + totCost + ".");
        return totCost;
    }
}
