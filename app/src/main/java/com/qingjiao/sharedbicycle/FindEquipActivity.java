package com.qingjiao.sharedbicycle;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.CircleOptions;
import com.baidu.mapapi.map.GroundOverlayOptions;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.Stroke;
import com.baidu.mapapi.map.SupportMapFragment;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.search.core.CityInfo;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.baidu.mapapi.search.poi.PoiSortType;
import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionResult;
import com.baidu.mapapi.search.sug.SuggestionSearch;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.qingjiao.sharedbicycle.adapter.HistoryRecyclerAdapter;
import com.qingjiao.sharedbicycle.fragment.FragmentSearchRecord;
import com.qingjiao.sharedbicycle.fragment.FragmentSearchRoute;
import com.qingjiao.sharedbicycle.item.ItemHistory;

import java.util.ArrayList;
import java.util.List;


public class FindEquipActivity extends AppCompatActivity{

    private ImageButton imgbtnReturn;
    private Button btnSearch;
    EditText et_mlocation;
    private RecyclerView recyclerView;
    EditText et_Goalocation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_find_equip);
        btnSearch = (Button)findViewById(R.id.btn_find_find);
        imgbtnReturn = (ImageButton)findViewById(R.id.find_equip_return);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
				Intent intent = new Intent(FindEquipActivity.this, NaviActivity.class);
                startActivity(intent);
            }
        });

        imgbtnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindEquipActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view_find);
        iniRecyclerView();

        et_mlocation = (EditText)findViewById(R.id.editext_mlocation);

// 获取意图对象
        Intent intent = getIntent();
        //获取传递的值
        String str = intent.getStringExtra("data");
        //设置值
        et_mlocation.setText(str);

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

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        HistoryRecyclerAdapter adapter = new HistoryRecyclerAdapter(list);
        recyclerView.setAdapter(adapter);
    }
    /*private void findView(){
        imgbtnReturn = (ImageButton)findViewById(R.id.find_equip_return);
        et_location = (EditText)findViewById(R.id.editext_location);
        keyWorldsView = (AutoCompleteTextView)findViewById(R.id.AutoComplete_go);

        sugAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line);
        keyWorldsView.setAdapter(sugAdapter);
        keyWorldsView.setThreshold(1);


        *//**
         * 当输入关键字变化时，动态更新建议列表
         *//*
        keyWorldsView.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {

            }

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2,
                                      int arg3) {
                if (cs.length() <= 0) {
                    return;
                }

                *//**
                 * 使用建议搜索服务获取建议列表，结果在onSuggestionResult()中更新
                 *//*
                mSuggestionSearch
                        .requestSuggestion((new SuggestionSearchOption())
                                .keyword(cs.toString()).city(editCity.getText().toString()));
            }
        });



    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        mPoiSearch.destroy();
        mSuggestionSearch.destroy();
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    *//**
     * 响应城市内搜索按钮点击事件
     *
     * @param v
     *//*
    public void searchButtonProcess(View v) {
        searchType = 1;
        String citystr = editCity.getText().toString();
        String keystr = keyWorldsView.getText().toString();
        mPoiSearch.searchInCity((new PoiCitySearchOption())
                .city(citystr).keyword(keystr).pageNum(loadIndex));
    }

    *//**
     * 响应周边搜索按钮点击事件
     *
     * @param v
     *//*
    public void  searchNearbyProcess(View v) {
        searchType = 2;
        PoiNearbySearchOption nearbySearchOption = new PoiNearbySearchOption().keyword(keyWorldsView.getText()
                .toString()).sortType(PoiSortType.distance_from_near_to_far).location(center)
                .radius(radius).pageNum(loadIndex);
        mPoiSearch.searchNearby(nearbySearchOption);
    }

    public void goToNextPage(View v) {
        loadIndex++;
        searchButtonProcess(null);
    }

    *//**
     * 响应区域搜索按钮点击事件
     *
     * @param v
     *//*
    public void searchBoundProcess(View v) {
        searchType = 3;
        mPoiSearch.searchInBound(new PoiBoundSearchOption().bound(searchbound)
                .keyword(keyWorldsView.getText().toString()));

    }


    @Override
    public void onGetPoiResult(PoiResult poiResult) {

    }

    @Override
    public void onGetPoiDetailResult(PoiDetailResult poiDetailResult) {

    }

    @Override
    public void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult) {

    }

    @Override
    public void onGetSuggestionResult(SuggestionResult suggestionResult) {

    }*/
}
