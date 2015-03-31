package logic;

public class CreateWeights {
	private static final int RANGE = 1;


	public static double[] create(int numberOfWeights) {
		double[] weights = new double[numberOfWeights];
		for (int i = 0; i < weights.length; i++) {
			weights[i] = randomDouble(RANGE);
		}
		return weights;
	}

	//If range is 1 will return double between 0 and 1
	private static double randomDouble(int range) {
        return Math.random() * range;
    }
}
