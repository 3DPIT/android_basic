package com.example.button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    //뷰의 주소 값을 담을 참조 변수
    TextView text1;
    Button btn1, btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (TextView)findViewById(R.id.textView);
        btn1 = (Button)findViewById(R.id.button);
        btn2 = (Button)findViewById(R.id.button2);
        //
        btn3 = (Button)findViewById(R.id.button3);
        btn4 = (Button)findViewById(R.id.button4);


        //리스너1 객체를 생성
        BtnListener1 listener1 = new BtnListener1();
        btn1.setOnClickListener(listener1);
        //리스너2 객체를 생성
        BtnListener2 listener2 = new BtnListener2();
        btn2.setOnClickListener(listener2);

        //리스너3 or 4 객체를 생성
        BtnListener3or4 listener34 = new BtnListener3or4();
        btn3.setOnClickListener(listener34);
        btn4.setOnClickListener(listener34);
    }

    //첫 번째 버튼과 연결된 리스너
    class BtnListener1 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            text1.setText("1 버튼을 눌렀습니다.");
        }
    }
    //두 번째 버튼과 연결된 리스너
    class BtnListener2 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            text1.setText("2 버튼을 눌렀습니다.");
        }
    }

    //세 번째, 네번제 버튼과 연결된 리스너
    class  BtnListener3or4 implements View.OnClickListener{
        @Override
        public void onClick(View v) {
        // 이벤트가 발생된 뷰의 id 값을 추출
        int id = v.getId();
        switch (id){
            case   R.id.button3:
                text1.setText("3 버튼을 눌렀습니다.");
                break;
            case   R.id.button4:
                text1.setText("4 버튼을 눌렀습니다.");
                break;
            }
        }
    }
    //다섯 번째 버튼을 누르면 호출되는 매서드
    public void btn5Method(View view){
        text1.setText("5 버튼을 눌렀습니다.");
    }
    //여섯 번째 버튼을 누르면 호출되는 매서드

    public void btn6Method(View view){
        text1.setText("6 버튼을 눌렀습니다.");
    }
    //일곱 번째 또는 여덟 번째 버튼을 누르면 호출되는 매서드
    public void btn7or8Method(View view){

        int id =view.getId();
        //아이디 값으로 분기한다.
        switch (id){
            case R.id.button7:
                text1.setText("7 버튼을 눌렀습니다.");
                break;
            case R.id.button8:
                text1.setText("8 버튼을 눌렀습니다.");
                break;
        }
    }
}
