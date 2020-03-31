package com.example.textview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //뷰의 주소값을 담을 참조 변수를 선언
    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //id 속성이 text2인 뷰의 주소 값을 얻어온다
        text1 = (TextView)findViewById(R.id.text2);
        text1.setText("java에서 실행");
    }
}
