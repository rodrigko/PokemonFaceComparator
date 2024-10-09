import ai.djl.Model;
import ai.djl.ModelException;
import ai.djl.ndarray.NDArray;
import ai.djl.ndarray.NDManager;
import ai.djl.translate.TranslateException;
import java.io.IOException;
import java.nio.file.Paths;

public class FeatureExtractor {
    public static float[] extractFeatures(String imagePath) throws IOException, ModelException, TranslateException {
        Model model = Model.newInstance("resnet50");
        model.load(Paths.get("path-to-model-dir"));

        // Carrega e pré-processa a imagem
        Image img = ImageFactory.getInstance().fromFile(Paths.get(imagePath));
        img.getTransform().add(new Resize(128, 128));

        try (NDManager manager = NDManager.newBaseManager()) {
            NDArray array = img.toNDArray(manager);
            NDArray features = model.forward(array);
            return features.toFloatArray();  // Converte para array de floats
        }
    }
}
