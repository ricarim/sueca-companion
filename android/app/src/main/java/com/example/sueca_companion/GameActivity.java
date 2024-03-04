package com.example.sueca_companion;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.sueca_companion.ml.BestFloat32;
import com.google.android.material.snackbar.Snackbar;

import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.label.Category;

import java.io.IOException;
import java.util.List;

public class GameActivity extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 1;

    try {
        Context context;
        BestFloat32 model = BestFloat32.newInstance(context);

        // Creates inputs for reference.
        Bitmap bitmap;
        TensorImage image = TensorImage.fromBitmap(bitmap);

        // Runs model inference and gets result.
        BestFloat32.Outputs outputs = model.process(image);
        List<Category> output = outputs.getOutputAsCategoryList();

        // Releases model resources if no longer used.
        model.close();
    } catch (IOException e) {
        System.err.println(e);
        // TODO Handle the exception
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.game);


    }

}
