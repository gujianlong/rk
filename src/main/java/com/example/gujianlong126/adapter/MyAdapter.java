package com.example.gujianlong126.adapter;
/*
 *@auther:谷建龙
 *@Date: 2019/12/8
 *@Time:13:59
 *@Description:
 * */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.gujianlong126.R;
import com.example.gujianlong126.bean.Bean;
import com.example.gujianlong126.utils.GlideUtils;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    private final Context context;
    private final List<Bean.OrderDataBean> list;

    public MyAdapter(Context context, List<Bean.OrderDataBean> list) {

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
        holder.big_name.setText(list.get(position).getShopName() + "");
        SmallAdapter smallAdapter = new SmallAdapter(list.get(position).getCartlist(), position);
        holder.big_rv.setAdapter(smallAdapter);
        holder.big_check.setChecked(setBigCheck(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private final CheckBox big_check;
        private final TextView big_name;
        private final RecyclerView big_rv;

        public Holder(@NonNull View itemView) {
            super(itemView);
            big_check = itemView.findViewById(R.id.big_check);
            big_name = itemView.findViewById(R.id.big_name);
            big_rv = itemView.findViewById(R.id.big_rv);
            big_rv.setLayoutManager(new LinearLayoutManager(context));
        }
    }

    class SmallAdapter extends RecyclerView.Adapter<SmallAdapter.SmallHolder> {
        private List<Bean.OrderDataBean.CartlistBean> list;
        private int bigIndex;

        public SmallAdapter(List<Bean.OrderDataBean.CartlistBean> list, int bigIndex) {
            this.list = list;
            this.bigIndex = bigIndex;
        }

        @NonNull
        @Override
        public SmallHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = View.inflate(context, R.layout.recy_small, null);
            SmallHolder holder = new SmallHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull SmallHolder holder, final int position) {
            holder.small_check.setChecked(list.get(position).isStatus());
            holder.small_name.setText(list.get(position).getProductName() + "");
            holder.small_price.setText(list.get(position).getPrice() + "");
            GlideUtils.loadImage(list.get(position).getDefaultPic(), holder.small_image);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickItem.onClick(position);
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public class SmallHolder extends RecyclerView.ViewHolder {

            private final CheckBox small_check;
            private final ImageView small_image;
            private final TextView small_name;
            private final TextView small_price;

            public SmallHolder(@NonNull View itemView) {
                super(itemView);
                small_check = itemView.findViewById(R.id.small_check);
                small_image = itemView.findViewById(R.id.small_image);
                small_name = itemView.findViewById(R.id.small_name);
                small_price = itemView.findViewById(R.id.small_price);
            }
        }
    }

    public interface OnClickItem {
        void onClick(int p);
    }

    private OnClickItem onClickItem;

    public void setOnClickItem(OnClickItem onClickItem) {
        this.onClickItem = onClickItem;
    }

    private boolean setBigCheck(int bigIndex) {
        boolean frag = true;
        Bean.OrderDataBean orderDataBean = list.get(bigIndex);
        for (int i = 0; i < orderDataBean.getCartlist().size(); i++) {
            if (!orderDataBean.getCartlist().get(i).isStatus()) {
                frag = false;
                return frag;
            }
        }
        return frag;
    }
}
