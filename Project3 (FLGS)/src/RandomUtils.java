import java.util.Random;

public class RandomUtils {
    static Random rand = new Random();

    public static String getRandomName() {
        Random rand = new Random();

        // Generate a name of random length between 3 and 8 characters long,
        // endpoints inclusive.

        // The math here is that the range between 3 and 8 is 5 (8-3=5)
        // and the nextInt function randomly selects between 0 and
        // the range calculated above plus 1 (as nextInt is exclusive
        // on the upper bound).  Then translate the sampled space over
        // 3 units so that the minimum is 3.

        int nameLength = rand.nextInt(6) + 3;

        // References
        // https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java

        char[] charsCons = {'b', 'c', 'd', 'e', 'f', 'g', 'h', 'k', 'l', 'm',
                'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y',
                'z'};
        char[] charsVowel = {'a', 'e', 'i', 'o', 'u'};

        StringBuilder name = new StringBuilder();

        while (name.length() < nameLength) {
            int r = rand.nextInt(charsCons.length);
            int s = rand.nextInt(charsVowel.length);
            char cons = charsCons[r];
            char vow = charsVowel[s];

            if (name.length() % 2 == 0) {
                name.append(cons);
            } else {
                name.append(vow);
            }
        }

        // Get the letters of the name, excluding the first letter
        // which has to be converted to uppercase
        String withoutFirst = name.substring(1);

        // Output the name where the first character is uppercase and
        // the rest is preserved.
        String nameOut = Character.toUpperCase(name.charAt(0)) + withoutFirst;
        return nameOut;
    }

    public static int getRandomInt(int higherBound) {
        return rand.nextInt(higherBound);
    }

    public static boolean getRandomBool() {
        return rand.nextBoolean();
    }

    public static double getRandomDouble() {
        return rand.nextDouble();
    }

    public static boolean customerBuysFromShelf(int shelfPos) {

        double shelfProbability = 0.2 - (0.02 * shelfPos);

        // Simplified if-else-statement as return
        // will always give back true or false.
        return getRandomDouble() <= shelfProbability && shelfProbability > 0;

    }

}

