public class CustomMinis extends SpecialAdd{
        private int minRoll = 1;
        private int maxRoll = 4;
        public double extraCost;
        Games g;

        public CustomMinis(Games g){
            this.g = g;
        }

        public double cost(){
            extraCost = super.getRandRoll(minRoll, maxRoll) * 49.98;
            return g.getPrice() + extraCost;
        }
}
