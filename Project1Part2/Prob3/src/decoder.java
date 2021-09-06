// Written using Java JDK v. 16.

// Main program that will do two things:
// 1. Take in the ASCII list from the decode() method. 
// 2. Call the other methods and print out the results

// Reading from text file reference:
// https://www.geeksforgeeks.org/different-ways-reading-text-file-java/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class decoder{

    static int[] asciiCode;

    public static void decode() throws FileNotFoundException {
        File inputFile = new File("src/asciiList.txt");
        Scanner sc = new Scanner(inputFile);

        String[] arr = sc.nextLine().split(",", -1);

        asciiCode = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            asciiCode[i] = Integer.parseInt(arr[i]);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        decode();

        PrintStream fileStream = new PrintStream("src/Results3.txt");
        System.setOut(fileStream);

        for (int i : asciiCode) {
            System.out.print("Code: " + i + "\t");
            codeToType.output(i);
            codeToChar.output(i);
        }
    }

}
