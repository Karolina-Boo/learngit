package com.example.viewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;

public class MainActivity extends AppCompatActivity {
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton=(Button)findViewById(R.id.button);
        mButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Log.d("ViewTest","MotionEvent:ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.d("ViewTest","MotionEvent:ACTION_MOVE");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.d("ViewTest","MotionEvent:ACTION_UP");
                        break;
                }
                return false;//表示是否消费了当前事件，返回true表示事件被消费，返回false表示View以及子View均没有消费事件，将调用父View的onTouchEvent方法
            }
        });
    }
    public void click(View v){
        Log.d("ViewTest","点击了按钮");
    }
}