package com.example.costomizeviewtest;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class BaseLinearLayout extends LinearLayout {
    public BaseLinearLayout(Context context) {
        super(context);
    }

    public BaseLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BaseLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
