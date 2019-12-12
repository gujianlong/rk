package com.example.gujianlong126;

import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gujianlong126.adapter.MyAdapter;
import com.example.gujianlong126.base.BaseActivity;
import com.example.gujianlong126.base.BasePresenter;
import com.example.gujianlong126.bean.Bean;
import com.example.gujianlong126.mvp.Presenter;
import com.example.gujianlong126.url.MyUrl;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {


    private RecyclerView recyclerView;
    private List<Bean.OrderDataBean> list = new ArrayList<>();
    private MyAdapter myAdapter;


    @Override
    protected void getDing() {
        myAdapter = new MyAdapter(this, list);
        recyclerView.setAdapter(myAdapter);
        mPresenter.onGetParams(MyUrl.HOMEBASE, Bean.class);
        myAdapter.setOnClickItem(new MyAdapter.OnClickItem() {
            @Override
            public void onClick(int p) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof Bean) {
            list.addAll(((Bean) o).getOrderData());
            myAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(String error) {

    }
}
