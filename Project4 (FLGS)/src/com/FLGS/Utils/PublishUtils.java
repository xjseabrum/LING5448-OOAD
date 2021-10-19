package com.FLGS.Utils;

import com.FLGS.Games.Games;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import static com.FLGS.Main.register;
import static com.FLGS.Main.wares;
import static com.FLGS.Main.store;

public class PublishUtils {

    public static void setupPublishing() throws FileNotFoundException {
        PrintStream fileStream = new PrintStream("Output.txt");
        System.setOut(fileStream);
    }

    public static void publishSummary(){
        System.out.println("-".repeat(80));
        System.out.println("-".repeat(80));
        System.out.println("Event Summary:");
        System.out.println("The Cash Fairy graciously visited the store " +
                register.cashFairyCounter + " time(s).");
        System.out.println(store.getBaker().getName() +
                " the Baker made a racket totalling $" +
                String.format("%.2f", store.getBaker().getPocket()) + ".");
        System.out.println("\nItem Summary:");
        System.out.println("The Cookie Monster devoured a total of " +
                wares.cookiejar.getTotCMAte() + " cookie(s).");
        System.out.println(wares.cookiejar.getTotCookiesSold() +
                " sale(s) of cookies occurred, generating $" +
                String.format("%.2f",
                        (wares.cookiejar.getTotCookiesSold() *
                                wares.cookiejar.priceCookie)) + " of revenue.");

        for (Games game : wares.getGames()) {
            System.out.println(game.getSold() + " sale(s) of " +
                    game.getGameName() + " occurred, generating $" +
                    String.format("%.2f", (float) (game.getSold() *
                            game.getPrice())) + " of revenue.");
        }

        System.out.println("");

        for (Games game : wares.getGames()) {
            System.out.println(game.getDamageContainer() +
                    " order(s) of " +
                    game.getGameName() +
                    " got damaged, costing the store $" +
                    String.format("%.2f", (float) (game.getDamageContainer() *
                            game.getPrice() * 0.5)) + " in replacement costs.");
        }

    }

}
