package com.example.costomizeviewtest;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class MyTestView extends View {
    private static final String TAG = TextView.class.getSimpleName();
    //构造函数
/**
 * 在java代码里new的时候会用到
 * @param context
 */
public MyTestView(Context context) {
    super(context);
}
    /**
     * 在xml布局文件中使用时自动调用
     * @param context
     */
    public MyTestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.test);
        String text = ta.getString(R.styleable.test_testAttr);
        int textAttr = ta.getInteger(R.styleable.test_text, -1);
        Log.e(TAG, "text = " + text + " , textAttr = " + textAttr);
        ta.recycle();
    }
    /**
     * 不会自动调用，如果有默认style时，在第二个构造函数中调用
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public MyTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 只有在API版本>21时才会用到
     * 不会自动调用，如果有默认style时，在第二个构造函数中调用
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyTestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }








}
