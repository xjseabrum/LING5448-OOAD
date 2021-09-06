package com.question2;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Ranger ranger = new Ranger();
        String validity;

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
