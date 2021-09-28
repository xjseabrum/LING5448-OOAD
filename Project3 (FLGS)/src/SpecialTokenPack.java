public class SpecialTokenPack extends SpecialAdd{
    public SpecialTokenPack(Games g){
        this.g = g;
        this.price = 6.00;
        this.gameName = g.getGameName();
    }

    public double getPrice(){
        double totCost = g.getPrice() + this.price;
        System.out.println(" and 1 special token pack for $" +
                           String.format("%.2f", this.price) +
                          " for a grand total of $" + totCost + ".");
        return totCost;
    }
}
