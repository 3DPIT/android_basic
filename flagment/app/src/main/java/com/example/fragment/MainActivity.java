package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    MainFragment fragment1;
    MenuFragment fragment2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1 = new MainFragment();
        fragment2 = new MenuFragment();

        //프래그먼트 매니지먼트에서 관리한다.
        Button btn1 =(Button)findViewById(R.id.btn1);
        Button btn2 =(Button)findViewById(R.id.button2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).commit();
                //자바 소스를 이용해서 프래그먼트 실행하기 이게 트랜잭션으로 만들었기때문에 커밋을 해줘야한다.
            }
        });

        //프래그먼트 매니지먼트에서 관리한다.
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment2).commit();
                //자바 소스를 이용해서 프래그먼트 실행하기 이게 트랜잭션으로 만들었기때문에 커밋을 해줘야한다.
            }
        });

    }
}
