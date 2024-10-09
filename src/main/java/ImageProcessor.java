import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImageProcessor {
    static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static Mat preprocessImage(String imagePath) {
        Mat image = Imgcodecs.imread(imagePath);
        Mat resizedImage = new Mat();
        Imgproc.resize(image, resizedImage, new Size(128, 128));
        return resizedImage;
    }
}
