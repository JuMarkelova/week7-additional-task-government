package cy.markelova.government.util;

import java.util.Random;

public class StringHelper {

    public static String generateRandomString(int minLengthOfSequence, int maxLengthOfSequence) {
        Random random = new Random();
        int length = random.nextInt(minLengthOfSequence + 1) + maxLengthOfSequence / 2;
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            sb.append(randomChar);
        }
        return sb.toString();
    }
}