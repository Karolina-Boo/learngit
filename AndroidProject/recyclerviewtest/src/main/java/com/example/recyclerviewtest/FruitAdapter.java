package com.example.recyclerviewtest;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> mFruitList;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

    @Override
    //创建ViewHolder实例，初始换ViewHolder及其关联的View
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.fruit_item,parent,false);
        return new ViewHolder(view,mOnItemClickListener);
    }

    @Override
    //对RecyclerView子项的数据进行赋值,填充ViewHolder微键
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Fruit fruit=mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
        //法一：为RecyclerView添加点击监听
//        holder.fruitView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position=holder.getAdapterPosition();
//                Fruit fruit=mFruitList.get(position);
//                Toast.makeText(v.getContext(),"you clicked view"+fruit.getName(),Toast.LENGTH_SHORT).show();
//                Intent intent=new Intent(mContext,MainActivity2.class);
//                mContext.startActivity(intent);
//            }
//        });
//        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position=holder.getAdapterPosition();
//                Fruit fruit= mFruitList.get(position);
//                Toast.makeText(v.getContext(),"you clicked image"+fruit.getName(),Toast.LENGTH_SHORT).show();
//
//            }
//        });
    }

    //法二：为RecyclerView添加点击监听
    //1.定义一个点击接口
    public interface OnItemClickListener{
        void onClick(View view,int pos);
    }

    //2.定义一个Adapter的点击监听函数
    public void setmOnItemClickListener(OnItemClickListener clickListener){
        this.mOnItemClickListener=clickListener;
    }

    @Override
    //告诉RecyclerView一共有多少子项
    public int getItemCount() {
        return mFruitList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(View itemView,final OnItemClickListener onItemClickListener) {
            super(itemView);
            fruitView=itemView;
            fruitImage=(ImageView) itemView.findViewById(R.id.fruit_image);
            fruitName=(TextView) itemView.findViewById(R.id.fruit_name);
            //3.监听itemView的点击事件
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener!=null){
                        int position=getAdapterPosition();//获取点击的位置
                        if (position!=RecyclerView.NO_POSITION){
                            onItemClickListener.onClick(itemView,position);
                        }
                    }
                }
            });
        }
    }

    //法一：为RecyclerView添加点击监听
//    public FruitAdapter(List<Fruit> fruitList,Context context){
//
//        this.mFruitList=fruitList;
//        this.mContext=context;
//    }

    //法二：为RecyclerView添加点击监听
    public FruitAdapter(List<Fruit> fruitList,Context context){
        this.mFruitList=fruitList;
        this.mContext=context;
    }
}
