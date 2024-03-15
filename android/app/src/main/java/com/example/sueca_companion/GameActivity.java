package com.example.sueca_companion;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;

public class GameActivity extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    public static final String  MODEL_PATH= "assets/best_float32.tflite";
    CardsTrainedModel model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // hide the title bar
        setContentView(R.layout.game);

        try{
            model = new CardsTrainedModel(MODEL_PATH);
            Log.d("MODEL","SUCCESS Creating new model");
        }catch (IOException e){
            Log.d("MODEL",e.getMessage());
            
        }

    }

}
