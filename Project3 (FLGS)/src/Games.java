// This is the Games superclass.
// This is an abstract class.
// It forms the base of the inheritance structure,
// by which KidsGame, BoardGame, CardGame and FamilyGame
// inherit their shared attributes, functions, and methods.
// This provides an example of abstraction:
// This superclass provides the framework by which all Games
// subclasses have to abide by and use.

// This object calls an object, gi, which contains
// the hashmaps to the names, prices, and dimensions of the games.

public abstract class Games {

    public double price = -1;
    public double boxHeight = 0;
    public double boxWidth = 0;
    public double boxLength = 0;
    public int inventory = 3;
    public int sold = 0;
    public int currentPosition;
    public int damageContainer = 0;
    public String gameName = "Generic Game";
    public String gameType = "Generic Type of Game";
    public double extraBuyChance = 0;

    //////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////

    // Constructor
    public Games(){

    }

    //////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////

    // Non-getter-setter methods
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

    //////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////

    // Getters
    public double getPrice(){
        return price;
    }

    public double getBoxHeight(){
        return boxHeight;
    }

    public double getBoxWidth(){
        return boxWidth;
    }

    public double getBoxLength(){
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

    public String getGameName(){
        return gameName;
    }

    public String getGameType(){
        return gameType;
    }

    public double getExtraBuyChance(){return extraBuyChance;}

    //////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////

    // Setters
    public void setPrice(double itemPrice) {
        this.price = Math.round(itemPrice * 100.0) / 100.0;
    }

    public void setGameName(String newName){
        this.gameName = newName;
    }
    public void setGameType(String newType){
        this.gameType = newType;
    }

    public void setCurrentPosition(int shelfPos){
        this.currentPosition = shelfPos;
    }

    public void setDamageContainer(int numDmg){
        this.damageContainer = numDmg;
    }
    public void setExtraBuyChance(double d){this.extraBuyChance = d;}

}
