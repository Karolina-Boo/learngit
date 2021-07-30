package com.example.fragmentbestpractice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsTitleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsTitleFragment extends Fragment {
    private boolean isTwoPane;

    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{
        private List<News> mNewsList;
        class ViewHolder extends RecyclerView.ViewHolder{
            TextView newsTitleText;
            public ViewHolder(@NonNull @NotNull View itemView) {
                super(itemView);
                newsTitleText=(TextView)itemView.findViewById(R.id.news_title);
            }
        }
        public NewsAdapter(List<News> newsList){
            mNewsList=newsList;
        }

        @NonNull
        @NotNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
            final ViewHolder holder=new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    News news=mNewsList.get(holder.getAdapterPosition());
                    if (!isTwoPane){
                        NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getContent());
                    }
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull @NotNull NewsAdapter.ViewHolder holder, int position) {
            News news=mNewsList.get(position);
            holder.newsTitleText.setText(news.getTitle());
        }

        @Override
        public int getItemCount() {
            return mNewsList.size();
        }
    }


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewsTitleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsTitleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsTitleFragment newInstance(String param1, String param2) {
        NewsTitleFragment fragment = new NewsTitleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_news_title, container, false);
        RecyclerView newsTitleRecyclerView=(RecyclerView) view.findViewById(R.id.news_title_recycler_view);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        newsTitleRecyclerView.setLayoutManager(linearLayoutManager);
        NewsAdapter adapter=new NewsAdapter(getNews());
        newsTitleRecyclerView.setAdapter(adapter);
        return view;
    }

    private List<News> getNews() {
        List<News> newsList=new ArrayList<>();
        for (int i=1;i<=50;i++){
            News news=new News();
            news.setTitle("This is news title "+i);
            news.setContent(getRandomLengthContent("This is news content "+i+"."));
            newsList.add(news);
        }
        return newsList;
    }

    private String getRandomLengthContent(String s) {
        Random random=new Random();
        int length=random.nextInt(20)+1;
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<length;i++){
            builder.append(s);
        }
        return builder.toString();
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isTwoPane=false;//单页模式
    }
}