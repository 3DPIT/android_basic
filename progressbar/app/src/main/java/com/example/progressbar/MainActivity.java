package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    ProgressBar pgb;
    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        tv = findViewById(R.id.tv);
        pgb = findViewById(R.id.progressbar);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pgb.setProgress(75);
            }
        });

    }

    public void progress() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    final int percent = i;
                    tv.post(new Runnable() {
                        @Override
                        public void run() {
                            pgb.setProgress(percent);
                            tv.setText(percent+"%");
                            if (percent == 100) {
                                tv.setText("완료!!");
                            }
                        }
                    });

                }
            }
        }).start();
    }
}