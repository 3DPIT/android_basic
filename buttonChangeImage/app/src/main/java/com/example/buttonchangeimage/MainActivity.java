package com.example.buttonchangeimage;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.button);
         imageView=(ImageView)findViewById(R.id.imageView);
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            i= 1-i;
            if(i==0){
                imageView.setImageResource(R.drawable.ic_launcher_foreground);
            }
            else{
                imageView.setImageResource(R.drawable.ic_launcher_background);
            }
        }
    });
    }
}
