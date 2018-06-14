package com.qingjiao.sharedbicycle.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import com.qingjiao.sharedbicycle.R;
import com.qingjiao.sharedbicycle.item.ItemHistory;

import java.util.List;

/**
 * author: 江晶晶 .
 * date:   On 2018/3/16
 */


public class HistoryRecyclerAdapter extends  RecyclerView.Adapter<HistoryRecyclerAdapter.MyViewHolder>{

    private List<ItemHistory> list;
    
    public HistoryRecyclerAdapter(List<ItemHistory> list){
        this.list = list;
    }
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history_record,null);
        final MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(HistoryRecyclerAdapter.MyViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getTextRecord());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_history_record);
        }
    }
}
