public abstract class Games {

    public double price;
    public double boxHeight;
    public double boxWidth;
    public double boxLength;
    public int inventory = 3;
    public int sold = 0;
    public int currentPosition;
    public int damageContainer = 0;
    public String gameName;

    public Games(){

    }

    public double getPrice(){
        return price;
    }

    // getters for dimensions to refer to hashmap

    public double getBoxHeight(GameInfo obj){
        boxHeight = obj.gameDimensions.get(this.getGameName())[0];
        return boxHeight;
    }

    public double getBoxWidth(GameInfo obj){
        boxWidth = obj.gameDimensions.get(this.getGameName())[1];
        return boxWidth;
    }

    public double getBoxLength(GameInfo obj){
        boxLength = obj.gameDimensions.get(this.getGameName())[2];
        return boxLength;
    }

    public int getInventory(){
        return inventory;
    }

    public int getSold(){
        return sold;
    }

    public int getCurrentPosition(){
        return currentPosition;
    }

    public int getDamageContainer(){
        return damageContainer;
    }

    public void setPrice(double itemPrice) throws Exception {
        this.price = Math.round(itemPrice * 100.0) / 100.0;

        if(this.price < 5 || this.price > 100){
            try
            {
                throw new Exception("Invalid price.");
            }
            catch(Exception e)
            {
                System.out.println("Price must be between 5-100, inclusive.");
                throw e;
            }

        }
    }

    // Explicit setters commented out as the item LxWxH are in the hashmap.
//    public void setBoxHeight(double itemHeight){
//        this.boxHeight = itemHeight;
//    }
//
//    public void setBoxWidth(double itemWidth){
//        this.boxWidth = itemWidth;
//    }
//
//    public void setBoxLength(double itemLength){
//        this.boxLength = itemLength;
//    }

    public void addInventory(int addToInv){
        this.inventory += addToInv;
    }

    public boolean Sold(int numSold){
        if (this.inventory < numSold) {
            return false;
        } else {
            this.sold += numSold;
            this.inventory -= numSold;
            return true;
        }
    }

    public void setCurrentPosition(int shelfPos){
        this.currentPosition = shelfPos;
    }

    public void setDamageContainer(int numDmg){
        this.damageContainer = numDmg;
    }

    public String getGameName(){
        return gameName;
    }

    public void setGameName(String newName){
        this.gameName = newName;
    }
}
