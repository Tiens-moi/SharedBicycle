package com.qingjiao.sharedbicycle.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.busline.BusLineSearch;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.baidu.mapapi.search.route.RoutePlanSearch;
import com.qingjiao.sharedbicycle.R;

/**
 * author: 江晶晶 .
 * date:   On 2018/3/19
 */


public class FragmentSearchRoute extends Fragment {

    MapView mMapView = null;//百度地图显示布局对象
    BaiduMap mBaiduMap = null;//百度地图控制对象

    PoiSearch poiSearch;//Poi搜索对象

    RoutePlanSearch routePlanSearch;//路线规划
    PoiSearch busPoiSearch;//公交地铁的Poi搜索对象
    BusLineSearch busLineSearch;//公交检索对象

    private Button btnSendEquip;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_search_route,container,false);
        SDKInitializer.initialize(getContext());
        initBaiduMap();
        return view;

    }

    private void initView(){
        btnSendEquip = (Button)getView().findViewById(R.id.btn_send_equip);
        btnSendEquip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(FragmentSearchRoute.this,)*/
            }
        });
    }
    private void initBaiduMap() {


        //获取地图控件引用
        mMapView = (MapView)getView().findViewById(R.id.map_view_route);
        //百度地图控制对象
        mBaiduMap = mMapView.getMap();
        //普通地图
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);

    }


}
