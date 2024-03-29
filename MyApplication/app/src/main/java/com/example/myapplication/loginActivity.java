package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

public class loginActivity extends AppCompatActivity {

    Button register_btn1;
    Button registerBtn;
    EditText idet, pwet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register_btn1 =(Button)findViewById(R.id.register_btn1);
        registerBtn = (Button)findViewById(R.id.register_btn);
        idet = (EditText)findViewById(R.id.register_id);
        pwet = (EditText)findViewById(R.id.register_pw);

        register_btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),joinActivity.class);
                startActivity(intent);
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    String result;
                    String id = idet.getText().toString();
                    String pw = pwet.getText().toString();

                    RegisterActivity task = new RegisterActivity();
                    result = task.execute("login",id, pw).get();

                    if(result.equals("1")){

                        Intent intent = new Intent (getApplicationContext(), cardView.class);//로그인 성공하면 북리스트로 이동
                        intent.putExtra("id",id);
                        startActivity(intent);
                    }

                } catch (Exception e) {
                    Log.i("DBtest", ".....ERROR.....!");
                }
            }
        });

    }
}