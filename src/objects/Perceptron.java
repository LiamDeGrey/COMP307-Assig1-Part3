package objects;

import java.util.ArrayList;

public class Perceptron {
	private final ArrayList<Image> images;
	private double[] weights;

	private int timesRun = 0;

	public Perceptron(ArrayList<Image> images, double[] weights) {
		this.images = images;
		this.weights = weights;

		checkAllImages();
	}

	private void checkAllImages() {
		int count = 0;
		for (Image image : images) {
			if (!(checkWeightAgainstImage(image.getFeatureArray()).equals(image.getClassName()))) {
				changeWeights(image);
			} else {
				count++;
			}
		}
		System.out.printf("\nWeights fit %.1f%% of images. count = %d, images = %d", ((count / images.size()) * 100.0), count, images.size());
		if (count == images.size()) {
			System.out.println("CONVERGED");
		} else {
			timesRun++;
			if (timesRun == 1000) {
				System.out.println("\nHas not converged from 1000 trials; will move on to classification");
				classifyExamples();
				return;
			}
			checkAllImages();
		}
	}

	private String checkWeightAgainstImage(int[] featureImage) {
		int sum = 0;
		for (int i = 1; i < featureImage.length; i++) {
			sum += featureImage[i] * weights[i];
		}
		return (sum < 1)? "Yes" : "other";
	}

	private void changeWeights(Image image) {
		int[] featureArray;
		if (image.getClassName().equals("Yes")) {
			//Add feature vector to weight vector
			for (int i = 1; i < (featureArray = image.getFeatureArray()).length; i++) {
				weights[i] += featureArray[i];
			}
		} else {
			//subtract feature vector from weight vector
			for (int i = 1; i < (featureArray = image.getFeatureArray()).length; i++) {
				weights[i] -= featureArray[i];
			}
		}
	}

	private void classifyExamples() {
		//TODO: classify test examples
	}

}
