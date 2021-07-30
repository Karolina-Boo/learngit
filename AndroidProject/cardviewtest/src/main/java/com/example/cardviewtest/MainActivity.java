package com.example.cardviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("TAG", String.valueOf(ViewConfiguration.get(getBaseContext()).getScaledTouchSlop()));
        GestureDetector gestureDetector=new GestureDetector((GestureDetector.OnGestureListener) this);
    }
}