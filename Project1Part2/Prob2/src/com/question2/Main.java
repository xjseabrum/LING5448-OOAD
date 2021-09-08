package com.question2;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {


        // General Structure of the Program -

        // Main calls Ranger class to run the program.

        // Ranger calls the high level functions. Abstraction guidelines
        // provided in the requirement doc (assignment sheet)

        // The actual base level logic is kept separate from Ranger
        // to ensure high level of cohesion.

        // The base level logic (of creating arrays, calculating mean, etc)
        // is stored in the utils package.

        // The utils are segregated based on their functionality.

        // External libraries (apache.commons.math3) was used to calculate mean and standardDeviation.

        Ranger ranger = new Ranger();
        String validity;

        // please note that I had initially implemented an if-else,
        // but the IDE automatically converted it to switch case.
        // I don't know how to cite this.
        label:
        while (true) {
            validity = ranger.read();

            switch (validity) {
                case "valid":
                    for (int i = 0; i < 10; i++) {
                        ranger.calculate();
                        ranger.write();
                    }
                    break;

                case "invalid":
                    ranger.writeError();
                    break;

                case "exit":
                    break label;
            }
        }
    }
}
