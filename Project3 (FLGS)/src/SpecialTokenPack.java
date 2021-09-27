public class SpecialTokenPack extends SpecialAdd{
    public double extraCost;
    Games g;

    public SpecialTokenPack(Games g){
        this.g = g;
    }

    public double cost(){
        extraCost = 6.00;
        return g.getPrice() + 6.00;
    }
}
