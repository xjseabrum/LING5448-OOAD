public class CustomMinis extends SpecialAdd{
    private int minRoll = 1;
    private int maxRoll = 4;

    public CustomMinis(Games g){
        this.g = g;
        this.price = 49.98;
        this.gameName = g.getGameName();
    }

    public double getPrice(){
        int numBuy = super.getRandRoll(minRoll, maxRoll);
        double addCost = numBuy * this.price;
        double totCost = g.getPrice() + addCost;
        System.out.println(" and " + numBuy + " custom mini(s) for $" +
                           String.format("%.2f", addCost) +
                           " for a grand total of $" + totCost + ".");
        return totCost;
    }
}
