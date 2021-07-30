package com.example.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.FrameMetrics;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(this);
        //动态添加碎片的步骤
        //1.创建待添加的碎片实例
        replaceFragment(new RightFragment());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                replaceFragment(new AnotherFragment());
                break;
            default:
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        //2.获取FragmentManager
        FragmentManager fragmentManager=getSupportFragmentManager();
        //3.开启一个事务
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        //4.向容器内添加或替换碎片
        transaction.replace(R.id.right_layout,fragment);
        transaction.addToBackStack(null);
        //5.提交事务
        transaction.commit();
    }
}