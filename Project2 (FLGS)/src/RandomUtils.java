import java.util.Random;

public class RandomUtils {
    static Random rand = new Random();

    public static String getRandomName(int nameLength){

        // References
        // https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder name = new StringBuilder();

        while (name.length() <= nameLength){
            int i =  (int) (rand.nextFloat() * chars.length());
            name.append(chars.charAt(i));
        }

        return name.toString();
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

        double shelfProbability = 0.2-(0.02*shelfPos);

        if (shelfProbability<0){
            return false;
        }
        else if (getRandomDouble()<=shelfProbability){
            return true;
        }
        else {
            return false;
        }
    }

}
