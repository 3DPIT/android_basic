package com.threedpit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    //Activity가 생성될 때 자동으로 호출된다.
    // 화면 회전이 발생했을때 자동으로 호출된다.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this.getApplicationContext(),"onCreate",Toast.LENGTH_SHORT).show();
        Log.d("test","oncreate");
    }
    //onCreate 메서드 호출 이후에 자동으로 호출
    //액티비트 정지상태가 되었다가 활동상태로 돌아올때 호출
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this.getApplicationContext(),"onStart",Toast.LENGTH_SHORT).show();
        Log.d("test","onStart");
    }
    //onStart 메서드 호출된 이후에 자동으로 호출
    //액티비티가 일시정지 되었다가 다시 돌아올때 호출 팝업창이런경우
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this.getApplicationContext(),"onResume",Toast.LENGTH_SHORT).show();
        Log.d("test","onResume");
    }
// 액티비티가 정지상태였다가 활동 상태로 돌아갈때 onstart매서드 전에 호출
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this.getApplicationContext(),"onRestart",Toast.LENGTH_SHORT).show();
        Log.d("test","onRestart");
    }
//액티비티가 일시정지 상태가 될때 호출
    //화면상에 완전히 사라지거나 현재 화면위해 작은 팝업창 같은것 나타날때 호풀
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this.getApplicationContext(),"onPause",Toast.LENGTH_SHORT).show();
        Log.d("test","onPause");
    }

    //액티비티가 화면에서 사라질때
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this.getApplicationContext(),"onStop",Toast.LENGTH_SHORT).show();
        Log.d("test","onStop");
    }
//현재 액티비티의 수행이 완전히 종료되어 메모리상 제거 될떄
    // 어플리케이션 종료나 백그라운드상태앱 종료시
 @Override
    protected void onDestroy() {
        super.onDestroy();
     Toast.makeText(this.getApplicationContext(),"onDestory",Toast.LENGTH_SHORT).show();
     Log.d("test","onDestory");
    }
}
