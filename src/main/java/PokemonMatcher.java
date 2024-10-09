import java.io.IOException;
import java.util.List;

public class PokemonMatcher {
    public static void findMostSimilar(String userImagePath, List<String> pokemonImagePaths) throws IOException, ModelException, TranslateException {
        float[] userFeatures = FeatureExtractor.extractFeatures(userImagePath);
        double bestMatchScore = Double.MAX_VALUE;
        String bestMatchImage = null;

        for (String pokemonImagePath : pokemonImagePaths) {
            float[] pokemonFeatures = FeatureExtractor.extractFeatures(pokemonImagePath);
            double similarityScore = SimilarityCalculator.euclideanDistance(userFeatures, pokemonFeatures);

            if (similarityScore < bestMatchScore) {
                bestMatchScore = similarityScore;
                bestMatchImage = pokemonImagePath;
            }
        }

        System.out.println("A imagem de Pokémon mais similar é: " + bestMatchImage);
    }
}
