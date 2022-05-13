package kr.ac.yeonsung.gnlwo.mobileproject_0513_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button[] btnnum = new Button[10];
    int[] btnnumId = {R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6,
            R.id.btn_7, R.id.btn_8, R.id.btn_9};
    EditText edit1, edit2;
    TextView text_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);

        text_result = findViewById(R.id.text_result);
        for (int i=0; i<btnnum.length; i++){
            final int index = i;
            btnnum[i] = findViewById(btnnumId[i]);
            btnnum[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String num = ""; //비어있는 문자열
                    if(edit1.isFocused()){ //edit1에 포커스가 맞춰저 있다면
                        num = edit1.getText().toString() + btnnum[view.getId()].getText();
                        edit1.setText(num);
                    }
                    if(edit2.isFocused()){ //edit1에 포커스가 맞춰저 있다면
                        num = edit2.getText().toString() + btnnum[view.getId()].getText();
                        edit2.setText(num);
                    }
                };
            });
        }
        Button btnPlus = findViewById(R.id.btn_plus);
        Button btnMinus = findViewById(R.id.btn_minus);
        Button btnMulit = findViewById(R.id.btn_multi);
        Button btnDe = findViewById(R.id.btn_de);

        btnPlus.setOnClickListener(btnListener);
        btnMinus.setOnClickListener(btnListener);
        btnMulit.setOnClickListener(btnListener);
        btnDe.setOnClickListener(btnListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int edit1num = Integer.parseInt(edit1.getText().toString());
            int edit2num = Integer.parseInt(edit2.getText().toString());
            int result = 0;
            switch(view.getId()){
                case R.id.btn_plus:
                    result = edit1num + edit2num;
                    break;
                case R.id.btn_minus:

                    result = edit1num - edit2num;
                    break;
                case R.id.btn_multi:
                    result = edit1num * edit2num;
                    break;
                case R.id.btn_de:
                    result = edit1num / edit2num;
                    break;
            }
            text_result.setText("계산결과 : " + result);
        }
    };
}