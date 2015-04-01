package logic;

import objects.Feature;
import objects.Image;

import java.util.ArrayList;

/**
 * Created by Liam on 31-Mar-15.
 */
public class CreateFeatureValueImages {

    public static ArrayList<Image> create(Feature[] features, ArrayList<Image> images) {
        int[] featureArray;
        Feature feature;
        int sum;

        for (Image image : images) {
            featureArray = new int[features.length+1];
            featureArray[0] = 1;//Dummy feature

            for (int i = 0 ; i < features.length; i++) {
                feature = features[i];
                sum = 0;

                for (int j = 0; j < 4; j++) {
                    sum += (image.getPixels()[feature.getColumnValue(j)][feature.getRowValue(j)] == feature.getSignValue(j))? 1 : 0;
                }
                featureArray[i+1] = (sum >= 3)? 1 : 0;
            }
            image.addFeatureArray(featureArray);
        }
        return images;
    }
}
