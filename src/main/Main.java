package main;

import logic.CreateFeatureValueImages;
import logic.CreateFeatures;
import logic.CreateWeights;
import objects.Feature;
import logic.LoadImages;

import java.util.ArrayList;

/**
 * Created by Liam on 29-Mar-15.
 */
public class Main {
    private static final int NUMBERFEATURES = 50;

    private static ArrayList<int[]> findFeatureValueImages(String[] args) {
        ArrayList<boolean[][]> images = null;
        Feature[] features = null;
        ArrayList<int[]> featureValueImages = null;

        if (args.length > 0) {
            images = LoadImages.load(args[0]);
        } else {
            System.out.println("Please pass a file argument containing at least one PBM image");
        }

        if (images != null) {
            features = CreateFeatures.create(NUMBERFEATURES, images.get(0).length-1, images.get(0)[0].length -1);
        } else {
            System.out.println("There was an error loading your images");
        }

        if (features != null) {
            featureValueImages = CreateFeatureValueImages.create(features, images);
        } else {
            System.out.println("There was an error creating the random features");
        }
        return featureValueImages;
    }

    public static void main(String[] args) {
        ArrayList<int[]> featureValueImages = findFeatureValueImages(args);
        double[] weights;

        if (featureValueImages != null) {
            weights = CreateWeights.create(featureValueImages.get(0).length);
        } else {
            System.out.println("There was an error creating the featureValueImages");
        }
    }
}
