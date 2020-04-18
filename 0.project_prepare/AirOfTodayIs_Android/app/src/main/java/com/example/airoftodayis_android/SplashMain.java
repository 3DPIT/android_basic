package com.example.airoftodayis_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Thread.sleep(2000);
            Intent mainTntent = new Intent(this, MainActivity.class);
            startActivity(mainTntent);
            finish();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
