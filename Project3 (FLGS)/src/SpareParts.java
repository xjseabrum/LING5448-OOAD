public class SpareParts extends SpecialAdd{
    private int minRoll = 1;
    private int maxRoll = 2;
    public double extraCost;
    Games g;

    public SpareParts(Games g){
        this.g = g;
    }

    public double cost(){
        super.getRandRoll(minRoll, maxRoll);
        extraCost = super.randRoll * 7.00;
        return g.getPrice() + extraCost;
    }
}
