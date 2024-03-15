import org.tensorflow.lite.Interpreter;

import com.sun.tools.javac.util.ByteBuffer;

import sun.jvm.hotspot.utilities.BitMap;


public class MainActivity {
    private Interpreter interpreter;

    private static final String MODEL_PATH = "../../../../assets/best_float32.tflite";
    private static final int DIM_BATCH_SIZE = 1;
    private static final int DIM_IMG_SIZE_X = 224;
    private static final int DIM_IMG_SIZE_Y = 224;
    private static final int DIM_PIXEL_SIZE = 3;

    private ByteBuffer imgData = ByteBuffer.allocateDirect(4 * DIM_BATCH_SIZE * DIM_IMG_SIZE_X * DIM_IMG_SIZE_Y * DIM_PIXEL_SIZE);

    private void convertBitmapToByteBuffer(BitMap bitmap) {
        imgData.rewind();

        bitmap.getPixels(intValues, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());

        int pixel = 0;
        for(int i = 0; i < DIM_IMG_SIZE_X; ++i){
            for(int j=0; j < DIM_IMG_SIZE_Y; ++j){
                final int val = intValues[pixel++];

                imgData.putFloat((((val >> 16)) & 0xFF) - IMAGE_MEAN / IMAGE_STD);
                imgData.putFloat((((val >> 8)) & 0xFF) - IMAGE_MEAN / IMAGE_STD);
                imgData.putFloat(((val) & 0xFF) - IMAGE_MEAN / IMAGE_STD);
            }
        }

    }
    public static void main(String[] args) {
        BitMap bitmap = BitmapFactory.decodeFile("path_to_image");
        convertBitmapToByteBuffer(bitmap);
        try {
            File file = new File(MODEL_PATH);
            Interpreter interpreter = new Interpreter(file);
            interpreter.run(input, output);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}

