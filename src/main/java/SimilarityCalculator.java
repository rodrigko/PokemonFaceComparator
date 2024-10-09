public class SimilarityCalculator {
    public static double euclideanDistance(float[] vector1, float[] vector2) {
        double sum = 0.0;
        for (int i = 0; i < vector1.length; i++) {
            sum += Math.pow(vector1[i] - vector2[i], 2);
        }
        return Math.sqrt(sum);
    }
}
