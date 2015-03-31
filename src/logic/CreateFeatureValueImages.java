package logic;

import objects.Feature;

import java.util.ArrayList;

/**
 * Created by Liam on 31-Mar-15.
 */
public class CreateFeatureValueImages {

    public static ArrayList<int[]> create(Feature[] features, ArrayList<boolean[][]> images) {
        ArrayList<int[]> featureValueImages = new ArrayList<>();

        int[] featureValueImage;
        Feature feature;
        int sum;

        for (boolean[][] image : images) {
            featureValueImage = new int[features.length];

            for (int i = 0 ; i < features.length; i++) {
                feature = features[i];
                sum = 0;

                for (int j = 0; j < 4; j++) {
                    sum += (image[feature.getColumnValue(j)][feature.getRowValue(j)] == feature.getSignValue(j))? 1 : 0;
                }
                featureValueImage[i] = (sum >= 3)? 1 : 0;
            }
            featureValueImages.add(featureValueImage);
        }
        return featureValueImages;
    }
}
