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
		double count = 0;
		for (Image image : images) {
			if (!(checkWeightAgainstImage(image.getFeatureArray()).equals(image.getClassName()))) {
				changeWeights(image);
			} else {
				count++;
			}
		}
		timesRun++;

		System.out.printf("\nWeights fit %.1f%% of images.", ((count / images.size()) * 100.0));
		if (count == images.size()) {
			System.out.printf("\n\nCONVERGED after %d attempts", timesRun);
			classifyExamples();
		} else {
			if (timesRun == 1000) {
				System.out.printf("\n\nPerceptron has not converged from %d trials; percentage of images classified correctly = %.1f%%", timesRun, ((count / images.size()) * 100.0));
				classifyExamples();
				return;
			}
			checkAllImages();
		}
	}

	private String checkWeightAgainstImage(int[] featureImage) {
		double sum = 0;

		for (int i = 0; i < featureImage.length; i++) {
			sum += featureImage[i] * weights[i];
		}
		return (sum > 1)? "Yes" : "other";
	}

	private void changeWeights(Image image) {
		int[] featureArray;
		if (image.getClassName().equals("Yes")) {
			//Add feature vector to weight vector because suggested value must have been "other",
			//weights are too high
			for (int i = 1; i < (featureArray = image.getFeatureArray()).length; i++) {
				weights[i] += featureArray[i];
			}
		} else {
			//Subtract feature vector to weight vector because suggested value must have been "yes"
			//weights are too low
			for (int i = 1; i < (featureArray = image.getFeatureArray()).length; i++) {
				weights[i] -= featureArray[i];
			}
		}
	}

	private void classifyExamples() {
		//TODO: classify test examples
	}

}
