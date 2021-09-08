package com.question2.Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class IOUtils {

    public static String validateInputs(int i1, int i2) {

        if (i1 > i2 || i1 < 0)  // both inputs are positive, lower and upper bounds are sequential.
            return "invalid";

        else if (i1 == 0 && i2==0)
            return "exit";

       else
           return "valid";
    }

    public static void displayInfo(double mean, double sd, int[] randomArray){

        // This is a highly coupled method, that can display the mean and sd.
        // Since the scope of the problem is fixed, this coupling should not cause issues.

        // Method takes Mean, SD and RandomArray and formats them and displays them on screen neatly.

        System.out.print("Values : ");
        for (double i: randomArray) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        System.out.println("Mean = " + mean + " Standard Deviation = " + sd);
    }

    public static void writeInfo(double mean, double sd, int[] randomArray, String filePath) throws IOException {

        // https://stackoverflow.com/questions/20588900/bufferedwriter-write-method-doesnt-write-integers-to-file
        // https://stackoverflow.com/questions/8005086/java-filewriter-how-to-write-to-next-line

        // This is a highly coupled method, that can display the mean and sd.
        // Since the scope of the problem is fixed, this coupling should not cause issues.

        // Method takes Mean, SD and RandomArray and formats them and writes them to filePath.

        FileWriter fstream = new FileWriter(filePath, true);
        BufferedWriter out = new BufferedWriter(fstream);

        out.write("Values : ");
        for (int i: randomArray) {
            out.write(String.valueOf(i));
            out.write(" ");
        }
        out.newLine();
        out.write("Mean = " + mean + " Standard Deviation = " + sd);
        out.newLine();

        out.close();
    }

    public static void writeError(int i1, int i2, String filePath) throws IOException {
        FileWriter fstream = new FileWriter(filePath, true);
        BufferedWriter out = new BufferedWriter(fstream);

        out.write("Illegal Entries i1 : " + i1 + " and i2 : " + i2);
        out.newLine();
        out.close();
    }
}
