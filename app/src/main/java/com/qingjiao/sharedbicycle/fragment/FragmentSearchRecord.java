package com.qingjiao.sharedbicycle.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qingjiao.sharedbicycle.R;
import com.qingjiao.sharedbicycle.adapter.HistoryRecyclerAdapter;
import com.qingjiao.sharedbicycle.item.ItemHistory;

import java.util.ArrayList;
import java.util.List;

/**
 * author: 江晶晶 .
 * date:   On 2018/3/19
 */


public class FragmentSearchRecord extends Fragment {
    private RecyclerView recyclerView;

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_search_record,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_find);
        iniRecyclerView();

        return view;
    }

    private void iniRecyclerView(){
        List<ItemHistory> list = new ArrayList<>();

        ItemHistory item = new ItemHistory();
        item.setTextRecord("都江堰市第二人民医院");
        list.add(item);

        ItemHistory item1 = new ItemHistory();
        item1.setTextRecord("青城山快铁站");
        list.add(item1);

        ItemHistory item2 = new ItemHistory();
        item2.setTextRecord("都江堰快铁站");
        list.add(item2);

        ItemHistory item3 = new ItemHistory();
        item3.setTextRecord("成都天府软件园");
        list.add(item3);

        ItemHistory item4 = new ItemHistory();
        item4.setTextRecord("都江堰风景区");
        list.add(item4);

        ItemHistory item5 = new ItemHistory();
        item5.setTextRecord("都江堰市第二人民医院");
        list.add(item5);

        ItemHistory item6 = new ItemHistory();
        item6.setTextRecord("春熙路");
        list.add(item6);

        ItemHistory item7 = new ItemHistory();
        item7.setTextRecord("蜀汉路东地铁口");
        list.add(item7);

        ItemHistory item8 = new ItemHistory();
        item8.setTextRecord("都江堰腾飞酒店");
        list.add(item8);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        HistoryRecyclerAdapter adapter = new HistoryRecyclerAdapter(list);
        recyclerView.setAdapter(adapter);
    }

}
