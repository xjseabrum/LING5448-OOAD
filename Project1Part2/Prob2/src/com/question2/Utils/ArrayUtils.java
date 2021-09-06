package com.question2.Utils; // https://stackoverflow.com/questions/14829522/import-some-classes-in-same-package

import java.util.Arrays;


public class ArrayUtils {

    public static int[] createRandomArray(int low, int high) {

        // https://stackoverflow.com/questions/1200621/how-do-i-declare-and-initialize-an-array-in-java
        // https://www.javatpoint.com/how-to-return-an-array-in-java

        int[] randomArray = new int[10];

        for (int i=0; i<10; i++)
            randomArray[i] = (int) NumberUtils.getRandomNumber(low, high);

        return randomArray;
    }

    public static int[] extendArray(int[] randomArray, int low, int high){
        randomArray =  Arrays.copyOf(randomArray, randomArray.length +10);

        for (int i=randomArray.length-1; i>=(randomArray.length-10); i--)
            randomArray[i] = (int) NumberUtils.getRandomNumber(low, high);

        return randomArray;
    }

    public static double[] recastArray(int[] randomArray){

        // https://stackoverflow.com/questions/12729139/copy-contents-of-an-int-array-to-a-double-array-in-java

        double[] castedRandomArray = new double[randomArray.length];

        for (int i=0; i<randomArray.length; i++)
            castedRandomArray[i] = randomArray[i];

        return castedRandomArray;
    }
}
