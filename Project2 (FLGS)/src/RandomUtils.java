import java.util.Random;

public class RandomUtils {
    static Random rand = new Random();

    public static String getRandomName(int nameLength){

        // References
        // https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java

        char[] charsCons = {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M',
                            'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y',
                            'Z'};
        char[] charsVowel = {'A', 'E', 'I', 'O', 'U'};
//        String chars = "ABCDEFGHIJKLMNOPQRSTVWXYZ";
//        String charsVowel = "AEIOU";
        StringBuilder name = new StringBuilder();

        while (name.length() < nameLength){
            Random rand = new Random();
            int r = rand.nextInt(charsCons.length);
            int s = rand.nextInt(charsVowel.length);
            char cons = charsCons[r];
            char vow = charsVowel[s];

            if (name.length() % 2 == 0){
                name.append(cons);
            } else {
                name.append(vow);
            }
        }

        StringBuilder lowers = new StringBuilder();
        String nameString = name.toString();
        char[] letters = nameString.toCharArray();

        for (int i = 2; i <= nameLength; i++){
            lowers.append(Character.toLowerCase(letters[i-1]));
        }

        String nameOut = String.valueOf(name.charAt(0)) + String.valueOf(lowers);
        return nameOut;
    }

    public static int getRandomInt(int higherBound){
        return rand.nextInt(higherBound);
    }

    public static boolean getRandomBool(){
        return rand.nextBoolean();
    }

    public static double getRandomDouble(){
        return rand.nextDouble();
    }

    public static boolean customerBuysFromShelf(int shelfPos){

        double shelfProbability = 0.2 - (0.02 * shelfPos);

        if (shelfProbability < 0){
            return false;
        }
        else if (getRandomDouble() <= shelfProbability){
            return true;
        }
        else {
            return false;
        }
    }

}
