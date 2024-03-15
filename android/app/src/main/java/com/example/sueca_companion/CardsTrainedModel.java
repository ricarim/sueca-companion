package com.example.sueca_companion;
import android.util.Log;

import org.tensorflow.lite.Interpreter;
import java.io.IOException;
import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class CardsTrainedModel{
    private static final int OUTPUT_SIZE = 50;
    private Interpreter interpreter;

    public CardsTrainedModel(String modelPath) throws IOException{
        interpreter = new Interpreter(loadModelFile(modelPath));

    }

    private MappedByteBuffer loadModelFile(String modelPath) throws IOException{
        FileInputStream inputStream = new FileInputStream(modelPath);
        Log.d("CardsTrainedModel", " " + modelPath);
        FileChannel fileChannel = inputStream.getChannel();
        long startOffset = fileChannel.position(); // 0
        long declaredLength = fileChannel.size();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
    }

    public float[][] predict(float[][] input){
        float[][] output = new float[1][OUTPUT_SIZE];
        interpreter.run(input, output);
        return output;
    }
    
}
