package main;

import logic.CreateFeatureValueImages;
import logic.CreateFeatures;
import logic.CreateWeights;
import objects.Feature;
import objects.Image;
import objects.Perceptron;
import logic.LoadImages;

import java.util.ArrayList;

/**
 * Created by Liam on 29-Mar-15.
 */
public class Main {
    private static final int NUMBERFEATURES = 50;

    private static ArrayList<Image> findImages(String[] args) {
        ArrayList<Image> images = null;
        Feature[] features = null;

        if (args.length > 0) {
            images = LoadImages.load(args[0]);
        } else {
            System.out.println("Please pass a file argument containing at least one PBM image");
        }

        if (images != null) {
            features = CreateFeatures.create(NUMBERFEATURES, images.get(0).getWidth()-1, images.get(0).getHeight()-1);
        } else {
            System.out.println("There was an error loading your images");
        }

        if (features != null) {
            images = CreateFeatureValueImages.create(features, images);
        } else {
            System.out.println("There was an error creating the random features");
            images = null;
        }
        return images;
    }

    public static void main(String[] args) {
        ArrayList<Image> images = findImages(args);
        double[] weights;

        if (images != null) {
        	new Perceptron(
        			images,
        			CreateWeights.create(images.get(0).getFeatureArray().length)
        			);
        } else {
            System.out.println("There was an error creating the Images");
        }
    }
}
