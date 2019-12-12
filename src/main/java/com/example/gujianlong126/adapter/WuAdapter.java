package com.example.gujianlong126.adapter;
/*
 *@auther:谷建龙
 *@Date: 2019/12/12
 *@Time:8:56
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gujianlong126.Main2Activity;
import com.example.gujianlong126.R;
import com.example.gujianlong126.bean.Bean;

import java.util.List;

public class WuAdapter extends RecyclerView.Adapter<WuAdapter.Holder> {
    private final Context context;
    private final List<Bean.OrderDataBean> list;

    public WuAdapter(Context context, List<Bean.OrderDataBean> list) {

        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.recy_bid, null);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.name.setText(list.get(position).getShopName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private final TextView name;

        public Holder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.big_name);
        }
    }
}
