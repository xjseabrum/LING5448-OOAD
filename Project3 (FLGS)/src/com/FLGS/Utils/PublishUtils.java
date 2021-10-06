package com.FLGS.Utils;

import com.FLGS.Games.Games;
import com.FLGS.Main;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import static com.FLGS.Main.register;

public class PublishUtils {

    public static void setupPublishing () throws FileNotFoundException {
        PrintStream fileStream = new PrintStream("Output.txt");
        System.setOut(fileStream);
    }

    public static void publishSummary(){
        System.out.println("-".repeat(80));
        System.out.println("-".repeat(80));
        System.out.println("Items Sold and Their Generated Revenue: \n");
        for (Games game : Main.wares.getGames()) {
            System.out.println(game.getSold() + " sale(s) of " +
                    game.getGameName() + " occurred, generating $" +
                    String.format("%.2f", (float) (game.getSold() *
                            game.getPrice())) + " of revenue.");
        }
        System.out.println("The Cash Fairy graciously visited the store " +
                  register.cashFairyCounter + " time(s).");
    }

}
