public class Sold {
    // Output the price with the decorators.

    public void doAction(Games gameSold, String customerName,
                         CashRegister cashRegister) {
        double income = gameSold.getPrice();

        // TO DO: be sure to reduce the inv of the base and not the deco.
        // Diff'tiate the deco and the game to do this correctly.

        // gs.g.i()
        gameSold.inventory -= 1;

        // Same here.
        gameSold.sold += 1;


        cashRegister.addCash(income);
        System.out.println(customerName + " bought " + gameSold.getGameName() +
                           " for $"+ String.format("%.2f", income) + ".");
    }
}
