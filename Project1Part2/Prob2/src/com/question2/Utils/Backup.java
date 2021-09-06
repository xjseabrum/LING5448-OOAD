package com.question2.Utils;

import java.util.Arrays;
import java.util.Scanner;
import org.apache.commons.math3.stat.StatUtils;

public class Backup {

    public static void main(){

        int low, high;
        double[] randomArray;
        double mean, standardDeviation;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter lower bound integer...");
        low = scanner.nextInt();

        System.out.println("Enter higher bound integer...");
        high = scanner.nextInt();

        validateInputs(low, high);
        randomArray = createRandomArray(low, high);

        for (int i=0; i<2; i++){


            mean = getMean(randomArray);
            standardDeviation = getStandardDeviation(randomArray);

            System.out.println(Arrays.toString(randomArray));
            System.out.println("Mean = " + mean + " Standard Deviation = " + standardDeviation);

            randomArray = attachAndFillArray(randomArray, low, high);
//            randomArray = fillAttachedArray(randomArray, low, high);
            System.out.println(Arrays.toString(randomArray));

        }

//        randomArray = createRandomArray(low, high);
//
//        mean = getMean(randomArray);
//        standardDeviation = getStandardDeviation(randomArray);
//
//        System.out.println(Arrays.toString(randomArray));
//        System.out.println("Mean = " + mean + " Standard Deviation = " + standardDeviation);
//
//        randomArray = Arrays.copyOf(randomArray, randomArray.length +10);
//        System.out.println(Arrays.toString(randomArray));

    }


    public static void validateInputs(int i1, int i2) {

        if (i1 > i2 || i1 < 0)
            throw new IllegalArgumentException("Your inputs are invalid.");

        else if (i1 == 0 && i2==0)
            throw new IllegalArgumentException("Both the inputs cannot be 0.");

    }

    public static double[] createRandomArray(int low, int high) {

        // https://stackoverflow.com/questions/1200621/how-do-i-declare-and-initialize-an-array-in-java
        // https://www.javatpoint.com/how-to-return-an-array-in-java

        double[] randomArray = new double[10];

        for (int i=0; i<10; i++)
            randomArray[i] = getRandomNumber(low, high);

        return randomArray;

    }

    public static double getRandomNumber(int low, int high){

        int range = high-low;
        return low + (range * Math.random());
    }

    public static double getMean(double[] randomArray){

        // https://stackoverflow.com/questions/5492553/java-library-to-calculate-the-mean
        // https://commons.apache.org/proper/commons-math/
        // https://stackoverflow.com/questions/1051640/correct-way-to-add-external-jars-lib-jar-to-an-intellij-idea-project
        // https://stackoverflow.com/questions/325524/where-to-put-the-external-jars

        return StatUtils.mean(randomArray);
    }

    public static double getStandardDeviation(double[] randomArray) {

        // https://www.investopedia.com/ask/answers/021215/what-difference-between-standard-deviation-and-variance.asp

        return Math.sqrt(StatUtils.variance(randomArray));
    }

    public static double[] fillAttachedArray(double[] randomArray, int low, int high){

        for (int i=randomArray.length-1; i>=(randomArray.length-10); i--)
            randomArray[i] = getRandomNumber(low, high);

        return randomArray;
    }

    public static double[] attachAndFillArray(double[] randomArray, int low, int high){
        randomArray =  Arrays.copyOf(randomArray, randomArray.length +10);

        for (int i=randomArray.length-1; i>=(randomArray.length-10); i--)
            randomArray[i] = getRandomNumber(low, high);

        return randomArray;
    }
}

