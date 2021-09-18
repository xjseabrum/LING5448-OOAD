// Add notes as to why this is OO
// as in, the purpose of the code (cohesion)
// what the code takes in
// what the code outputs for other objects to use.

import java.util.Arrays;

public class cumulSum{

    public static int[] cumul(int[] input) {
        int[] cumulOutput = new int[input.length];
        int sum = 0;
        int[] rowPercent = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            sum += input[i];
            cumulOutput[i] = sum;

        }

        for (int i = 0; i < input.length; i++){
            rowPercent[i] = cumulOutput[i] / sum;
            System.out.println(Arrays.toString(rowPercent));
        }
         return cumulOutput;
    }

}

