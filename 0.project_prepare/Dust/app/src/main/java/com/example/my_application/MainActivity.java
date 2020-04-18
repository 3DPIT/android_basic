package com.example.my_application;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    //Activity가 생성될 때 자동으로 호출
    //화면 회전이 발생했을때 자동으로 호출
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // System.out.println("onCreate 메서드 호출");
        Log.d("test","onCreate 메서드 호출");
        Toast.makeText(this,"onCreat",Toast.LENGTH_SHORT).show();
    }
    @Override
    //onCreate 메서드 호출 이후에 자동으로 호출
    //Activity가 정지 상태가 되었다가 활동상태로 돌아올때 호출
    protected void onStart() {
        super.onStart();
        Log.d("test", "onStart 호출");
        Toast.makeText(this,"onStrat",Toast.LENGTH_SHORT).show();

    }
    @Override
    //onStart 메서드가 호출된 이후에 자동으로 호출
    //Activity가 일시 정지 되었다가 다시 돌아 올때 호출
    protected void onResume() {
        super.onResume();
        Log.d("test","onResume 호출");
        Toast.makeText(this,"onResume",Toast.LENGTH_SHORT).show();
    }
    // Activity가 정지 상태가 되었다가 활동 상태로 돌아갈 때 onStart 메서드 전에 호출
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("test","onRestart 호출");
        Toast.makeText(this,"onRestart",Toast.LENGTH_SHORT).show();
    }
    //Activity 일시 정지 상태가 될때 호출
    //화면상에서 완전히 사라지거나 현재 화면 위에 작은 팝업 창 같은것이 나타날 때 호출
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("test","onPause 호출");
        Toast.makeText(this,"onPause",Toast.LENGTH_SHORT).show();
    }
    //Activity가 화면에서 사라질 떄 호출
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("test","onStop 호출");
        Toast.makeText(this,"onStop",Toast.LENGTH_SHORT).show();
    }
    //현재 Activity의 수행이 완전히 종료되어 메모리상에서 제거 될 때 호출
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("test","onDestory 호출");
        Toast.makeText(this,"onDestory",Toast.LENGTH_SHORT).show();

    }
}
