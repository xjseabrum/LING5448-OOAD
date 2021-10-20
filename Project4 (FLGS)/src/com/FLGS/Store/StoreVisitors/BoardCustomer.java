// One of the customer subclasses.
// It will be genreated by the factory
// and will set help kick start setting the probability bias
// values for the customer type and game type.
// See BiasUitls for more information of how the
// bias is implemented.

package com.FLGS.Store.StoreVisitors;

public class BoardCustomer extends Customer{
    public BoardCustomer(){
        super.type = "Board";
        super.setBias();
    }
}
