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

    public double price;
    public double boxHeight;
    public double boxWidth;
    public double boxLength;
    public int inventory = 3;
    public int sold = 0;
    public int currentPosition;
    public int damageContainer = 0;
    public String gameName;
    public String gameType;
    GameInfo gi = new GameInfo();

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
        return gi.priceTable().get(this.getGameName());
    }

    public double getBoxHeight(){
        this.boxHeight = gi.gameDimensions().get(this.getGameName())[0];
        return boxHeight;
    }

    public double getBoxWidth(){
        this.boxWidth = gi.gameDimensions().get(this.getGameName())[1];
        return boxWidth;
    }

    public double getBoxLength(){
        this.boxLength = gi.gameDimensions().get(this.getGameName())[2];
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

    //////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////

    // Setters
    public void setPrice(double itemPrice) throws Exception {
        this.price = gi.priceTable().get(this.getGameName());

        // Commented out for now as we don't expect price changes to
        // change on the fly.
        // this.price = Math.round(itemPrice * 100.0) / 100.0;

        gi.priceTable().replace(this.gameName,
                                Math.round(itemPrice * 100.0) / 100.0);

        // Check to ensure the price falls between 5 and 100, inclusive.
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
}
