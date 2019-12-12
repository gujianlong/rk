package com.example.gujianlong126;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.gujianlong126.adapter.DingAdapter;
import com.example.gujianlong126.adapter.WuAdapter;
import com.example.gujianlong126.base.BaseActivity;
import com.example.gujianlong126.base.BasePresenter;
import com.example.gujianlong126.bean.Bean;
import com.example.gujianlong126.mvp.Presenter;
import com.example.gujianlong126.url.MyUrl;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends BaseActivity {

    private RecyclerView recycler;
    private List<Bean.OrderDataBean> list = new ArrayList<>();
    private WuAdapter wuAdapter;

    @Override
    protected void getDing() {
        wuAdapter = new WuAdapter(this, list);
        recycler.setAdapter(wuAdapter);
        mPresenter.onGetParams(MyUrl.HOMEBASE, Bean.class);
    }

    @Override
    protected BasePresenter getPresenter() {
        return new Presenter();
    }

    @Override
    protected void initView() {
        recycler = findViewById(R.id.recy);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main2;
    }

    @Override
    public void onSuccess(Object o) {
        if (o instanceof Bean){
            list.addAll(((Bean) o).getOrderData());
            wuAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onError(String error) {

    }
}
