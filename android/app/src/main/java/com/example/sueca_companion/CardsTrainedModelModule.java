package com.example.sueca_companion;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.io.IOException;

public class CardsTrainedModelModule extends ReactContextBaseJavaModule {
    private final CardsTrainedModel model;

    public CardsTrainedModelModule(ReactApplicationContext reactContext) throws IOException {
        super(reactContext);
        // Inicialize seu modelo aqui com o caminho do modelo
        String modelPath = "../../../../assets/best_float32.tflite";
        model = new CardsTrainedModel(modelPath);
    }

    @Override
    public String getName() {
        return "CardsTrainedModel";
    }

    @ReactMethod
    public void predict(float[][] input, Promise promise) {
        float[][] output = model.predict(input);
        promise.resolve(output);
    }
}

