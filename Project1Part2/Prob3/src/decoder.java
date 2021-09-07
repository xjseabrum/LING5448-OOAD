// Written using Java JDK v. 16.

// This is the main program.
// Main program that will do two things:
// 1. Take in the ASCII list from the getFile() method.
// 2. Call the other methods and print out the results and save them to
// Results3.txt

// Instead of implementing the class as just Decode(),
// The implementation here is split into 2 methods:

// The first method, codeToChar, is created SOLELY to convert an ASCII code to
// a character. 
// Because it does nothing else, the cohesion within the code is high.

// The second method, codeToType, is created only to assign the correct
// code type to the ASCII code. This is also to maintain a relatively high level
// of cohesion.

// The coupling between all the files is relatively low, with the only one
// object, asciiCode, passed between all of them.

// Reading from text file reference:
// https://www.geeksforgeeks.org/different-ways-reading-text-file-java/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class decoder{

    static int[] asciiCode;

    public static void getFile() throws FileNotFoundException {
        File inputFile = new File("src/asciiList.txt");
        Scanner sc = new Scanner(inputFile);

        String[] arr = sc.nextLine().split(",", -1);

        asciiCode = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            asciiCode[i] = Integer.parseInt(arr[i]);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        getFile();

        PrintStream fileStream = new PrintStream("src/Results3.txt");
        System.setOut(fileStream);

        for (int i : asciiCode) {
            System.out.print("Code: " + i + "\t");
            codeToType.output(i);
            codeToChar.output(i);
        }
    }

}
