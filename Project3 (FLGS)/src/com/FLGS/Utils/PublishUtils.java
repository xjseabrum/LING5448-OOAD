package com.FLGS.Utils;

import com.FLGS.Games.Games;
import com.FLGS.Main;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import static com.FLGS.Main.register;

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
        System.out.println("Gonger the Baker made a racket of $" +
                "0" +
                ".");
        System.out.println("\nItem Summary:");
        System.out.println("The cookie monster devoured a total of " +
                "0" + " cookie(s).");
        System.out.println("0 sale(s) of cookies occurred, generating $" +
                "0" + " of revenue.");
        for (Games game : Main.wares.getGames()) {
            System.out.println(game.getSold() + " sale(s) of " +
                    game.getGameName() + " occurred, generating $" +
                    String.format("%.2f", (float) (game.getSold() *
                            game.getPrice())) + " of revenue.");
        }

    }

}
