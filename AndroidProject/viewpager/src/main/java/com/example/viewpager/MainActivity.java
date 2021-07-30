package com.example.viewpager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

//public class MainActivity extends AppCompatActivity {
public class MainActivity extends FragmentActivity{
    private View view1,view2,view3;
    private ViewPager viewPager;
    private List<View> viewList;
//    private List<String> titleList;

    private ImageView cursor;
    private int bmpw=0;//游标宽度
    private int offset=0;//动画图片偏移量
    private int currIndex=0;//当前页卡编号

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //构造适配器
        List<Fragment> fragments=new ArrayList<>();
        fragments.add(new FirstFragment());
        fragments.add(new SecondFragment());
        fragments.add(new ThirdFragment());
        FragAdapter adapter=new FragAdapter(getSupportFragmentManager(),fragments);

        //设定适配器
        ViewPager vp=(ViewPager)findViewById(R.id.viewpager);
        vp.setAdapter(adapter);
//        viewPager = (ViewPager) findViewById(R.id.viewpager);
//        LayoutInflater inflater=getLayoutInflater();
//        view1=inflater.inflate(R.layout.layout1,null);
//        view2=inflater.inflate(R.layout.layout2,null);
//        view3=inflater.inflate(R.layout.layout3,null);
//
//        viewList=new ArrayList<View>();
//        viewList.add(view1);
//        viewList.add(view2);
//        viewList.add(view3);
//
//        //初始化指示器位置
//        initCursorPos();

//        titleList=new ArrayList<>();
//        titleList.add("star");
//        titleList.add("moon");
//        titleList.add("sun");

//        PagerAdapter pagerAdapter=new PagerAdapter() {
//            @Override
//            //返回要滑动的view的个数
//            public int getCount() {
//                return viewList.size();
//            }
//
//            @Override
//            public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
////                return view==object;
//                return view==viewList.get((int)Integer.parseInt(object.toString()));
//            }
//
//            @Override
//            //从当前container中删除指定位置的View
//            public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
//                container.removeView(viewList.get(position));
//            }
//
//            @NonNull
//            @NotNull
//            @Override
//            //做了两件事，第一：将当前视图添加到container中，第二：返回当前View
//            public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {
//                container.addView(viewList.get(position));
////                return viewList.get(position);
//                return position;
//            }
//
//            @Nullable
//            @org.jetbrains.annotations.Nullable
//            @Override
//            public CharSequence getPageTitle(int position) {
//                return titleList.get(position);//根据位置返回当前所对应的标题。
//            }
//        };
//        viewPager.setAdapter(pagerAdapter);
    }

//    private void initCursorPos() {
//        //初始化动画
//        cursor=(ImageView) findViewById(R.id.cusor);
//        bmpw= BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_background).getWidth();
//        DisplayMetrics displayMetrics=new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
//        int screenW= displayMetrics.widthPixels;
//        offset=(screenW/viewList.size()-bmpw)/2;
//        Matrix matrix=new Matrix();
//        matrix.postTranslate(offset,0);
//        cursor.setImageMatrix(matrix);
//    }
//
//    //页面改变监听器
//    public class MyPageChangeListener implements ViewPager.OnPageChangeListener{
//
//        int one=offset*2+bmpw;
//        int two=one*2;
//
//        @Override
//        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//        }
//
//        @Override
//        public void onPageSelected(int position) {
//            Animation animation=null;
//            switch (position){
//                case 0:
//                    if (currIndex==1){
//                        animation=new TranslateAnimation(one,0,0,0);
//                    } else if (currIndex==2){
//                        animation=new TranslateAnimation(two,0,0,0);
//                    }
//                    break;
//                case 1:
//                    if (currIndex==0){
//                        animation=new TranslateAnimation(offset,one,0,0);
//                    } else if (currIndex==2){
//                        animation=new TranslateAnimation(two,one,0,0);
//                    }
//                    break;
//                case 2:
//                    if (currIndex==0){
//                        animation=new TranslateAnimation(offset,one,0,0);
//                    } else if (currIndex==1){
//                        animation=new TranslateAnimation(one,two,0,0);
//                    }
//                    break;
//            }
//            currIndex =position;
//            animation.setFillAfter(true);
//            animation.setDuration(300);
//            cursor.startAnimation(animation);
//        }
//
//        @Override
//        public void onPageScrollStateChanged(int state) {
//
//        }
//    }

//    public class MyPagerAdapter extends PagerAdapter{
//        public List<View> mListViews;
//
//        @Override
//        public int getCount() {
//            return mListViews.size();
//        }
//
//        @Override
//        public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
//            return view==object;
//        }
//
//        @Override
//        public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {
//            container.removeView(mListViews.get(position));
//        }
//
//        @NonNull
//        @NotNull
//        @Override
//        public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {
//            container.removeView(mListViews.get(position));
//            return mListViews.get(position);
//        }
//    }

    public class FragAdapter extends FragmentPagerAdapter{

        private List<Fragment> mFragments;

        //对于构造函数，这里申请了一个Fragment的List对象，用于保存用于滑动的Fragment对象，并在创造函数中初始化
        public FragAdapter(@NonNull @NotNull FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            mFragments=fragments;
        }

        @NonNull
        @NotNull
        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
}