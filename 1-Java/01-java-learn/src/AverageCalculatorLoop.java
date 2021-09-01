
public class AverageCalculatorLoop {

	public static void main(String[] args) {
		float[] scores = { 48, 55, 92, 78, 64 };
		float sum = 0.0f;
		/*for (int i = 0; i < scores.length; i++) {
			sum = sum + scores[i];
		}*/
		for (float score : scores) {
			sum += score;
		}
		System.out.println("Average = " + (sum / scores.length));
	}

}
