package logic;

import objects.Feature;

/**
 * Created by Liam on 31-Mar-15.
 */
public class CreateFeatures {

    public static Feature[] create(int numberOfFeatures, int maxWidth, int maxHeight) {
        Feature[] features = new Feature[numberOfFeatures];
        int[] column;
        int[] row;
        boolean[] sign;

        for (int i = 0; i < numberOfFeatures; i++) {
            column = new int[4];
            row = new int[4];
            sign = new boolean[4];

            for (int j = 0; j < 4; j++) {
                column[j] = randomInt(maxWidth);
                row[j] = randomInt(maxHeight);
                sign[j] = (randomInt(2) == 0);
            }
            features[i] = new Feature(column, row, sign);
        }
        return features;
    }

    private static int randomInt(int max) {
        return (int)(Math.random() * max);
    }
}
