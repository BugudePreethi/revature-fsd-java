
public class AverageCalculator {

	public static void main(String[] args) {
		//int[] scores = { 48, 55, 92, 78, 64 };
        int[] scores = new int[5];
        scores[0] = 48;
        scores[1] = 55;
        scores[2] = 92;
        scores[3] = 78;
        scores[4] = 64;
        //float average = (scores[0] + scores[1] + scores[2] + scores[3] + scores[4]) / 5.0f;
        float average = (scores[0] + scores[1] + scores[2] + scores[3] + scores[4]) / (float) scores.length;
        System.out.println("Average = "+average);
	}

}
