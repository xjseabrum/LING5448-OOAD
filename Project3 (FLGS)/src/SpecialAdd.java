public abstract class SpecialAdd extends Games{
    public double cost = 0;
    public int randRoll;
    Games g;

    public int getRandRoll(int min, int max) {
        this.randRoll = RandomUtils.rand.nextInt((max - min) + 1) + min;
        return randRoll;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

}
