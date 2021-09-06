package com.question2;

import com.question2.Utils.*;

import java.io.IOException;
import java.util.Scanner;


public class Ranger {

    int low, high;
    double mean, standardDeviation;
    int[] randomArray;

    public String read(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter lower bound integer...");
        low = Math.round(scanner.nextFloat());

        System.out.println("Enter higher bound integer...");
        high = Math.round(scanner.nextFloat());

        String validity = IOUtils.validateInputs(low, high);

        randomArray = ArrayUtils.createRandomArray(low, high);

        return validity;
    }


    public void calculate() throws IOException {

        mean = NumberUtils.getMean(randomArray);
        standardDeviation = NumberUtils.getStandardDeviation(randomArray);

        IOUtils.displayInfo(mean, standardDeviation, randomArray);

        randomArray = ArrayUtils.extendArray(randomArray, low, high);

    }

    public void write() throws IOException {
        IOUtils.writeInfo(mean, standardDeviation, randomArray, "results2.txt");
    }

    public void writeError() throws IOException {
        IOUtils.writeError(low, high, "results2.txt");
    }
}
