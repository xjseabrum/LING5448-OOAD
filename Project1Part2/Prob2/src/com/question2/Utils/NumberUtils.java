package com.question2.Utils;

import org.apache.commons.math3.stat.StatUtils;

public class NumberUtils {

    public static double getMean(int[] randomArray){

        // https://stackoverflow.com/questions/5492553/java-library-to-calculate-the-mean
        // https://commons.apache.org/proper/commons-math/
        // https://stackoverflow.com/questions/1051640/correct-way-to-add-external-jars-lib-jar-to-an-intellij-idea-project
        // https://stackoverflow.com/questions/325524/where-to-put-the-external-jars

        return StatUtils.mean(ArrayUtils.recastArray(randomArray));
    }

    public static double getStandardDeviation(int[] randomArray) {

        // https://www.investopedia.com/ask/answers/021215/what-difference-between-standard-deviation-and-variance.asp

        return Math.sqrt(StatUtils.variance(ArrayUtils.recastArray(randomArray)));
    }

    public static double getRandomNumber(int low, int high){

        int range = high-low;
        return Math.round(low + (range * Math.random()));
    }

}
