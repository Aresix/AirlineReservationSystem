package util;

import java.util.Random;

public class RandomNumber {
    public static int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }
}
