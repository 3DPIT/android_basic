package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //뷰의 주소값을 담을 참조변수
    TextView text1;
    CheckBox chk1,chk2,chk3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //뷰의 주소값을 가져옴
        text1=(TextView)findViewById(R.id.textView);
        chk1 =(CheckBox)findViewById(R.id.checkBox);
        chk2 =(CheckBox)findViewById(R.id.checkBox2);
        chk3 =(CheckBox)findViewById(R.id.checkBox3);
        //체크 박스에 리스너를 설정
        CheckBoxListener listener = new CheckBoxListener();
        chk1.setOnCheckedChangeListener(listener);
        chk2.setOnCheckedChangeListener(listener);
        chk3.setOnCheckedChangeListener(listener);


    }
    //첫번째 버튼을 눌렀을때 호출되늠 메서드
    // 체크 상태 값을 파악한다.
    public void btn1Method(View view){
        text1.setText("");
        //체크 상태에 따라 필요한 처리를 해준다.
        boolean a1 = chk1.isChecked();
        boolean a2 = chk2.isChecked();
        boolean a3 = chk3.isChecked();

        if(a1==true){
            text1.append("첫번째 체크 박스가 체크되어 있습니다\n");
        }
        if(a2==true){
            text1.append("두번째 체크 박스가 체크되어 있습니다\n");
        }
        if(a3==true){
            text1.append("세번째 체크 박스가 체크되어 있습니다\n");
        }
    }

    //두번째 버튼과 연결된 메서드
    //모든 체크박스의 상태를 체크상태로 설정
    public void btn2Method(View view){
        chk1.setChecked(true);
        chk2.setChecked(true);
        chk3.setChecked(true);
    }

    //세번째 버튼과 연결된 메서드
    //모든 체크박스의 상태를 빈 체크상태로 설정
    public void btn3Method(View view){
        chk1.setChecked(false);
        chk2.setChecked(false);
        chk3.setChecked(false);
    }

    public void btn4Method(View view){
        chk1.toggle();
        chk2.toggle();
        chk3.toggle();
    }

    //체크박스의 체크 상태가 변경되면 반응하는 리스너
    class CheckBoxListener implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            // 체크 상태가 변경된 체크박스의 id 가져옴
            int id = buttonView.getId();
            //아이디 값으로 분기한다.
            switch (id){
                case R.id.checkBox:
                    if(isChecked==true){
                        text1.setText("첫번째 체크박스 체크");
                    }else{
                        text1.setText("첫번째 체크박스 해제");
                    }
                    break;
                case R.id.checkBox2:
                    if(isChecked==true){
                        text1.setText("두번째 체크박스 체크");
                    }else{
                        text1.setText("두번째 체크박스 해제");
                    }
                    break;
                case R.id.checkBox3:
                    if(isChecked==true){
                        text1.setText("세번째 체크박스 체크");
                    }else{
                        text1.setText("세번째 체크박스 해제");
                    }
                    break;
            }
        }
    }

}
