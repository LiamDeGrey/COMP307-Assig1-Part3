package objects;

public class Image {
	private final String className;
	private final boolean[][] pixels;
	private int[] featureArray;

	public Image(String className, boolean[][] pixels) {
		this.className = className;
		this.pixels = pixels;
	}

	public String getClassName() {
		return className;
	}

	public boolean[][] getPixels() {
		return pixels;
	}

	public int getWidth() {
		return pixels.length;
	}

	public int getHeight() {
		return pixels[0].length;
	}

	public void addFeatureArray(int[] featureArray) {
		this.featureArray = featureArray;
	}

	public int[] getFeatureArray() {
		return featureArray;
	}
}
