package com.qingjiao.sharedbicycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.baidu.mapapi.model.LatLng;
import com.qingjiao.sharedbicycle.utils.BlueToothTool;

public class NaviActivity extends AppCompatActivity {

    // 当前位置
    double mLat1 = 30.894435;
    double mLon1 = 103.60298;
    // 目的地坐标
    double mLat2 = 30.898484;
    double mLon2 = 103.613107;

    LatLng loc_start = new LatLng(mLat1,mLon1);
    LatLng loc_end = new LatLng(mLat2, mLon2);


    Button sendBtn;

    private  BlueToothTool client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_navi);

        sendBtn = (Button)findViewById(R.id.btn_send_result);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* BlueToothTool.WriteTask W=client.new WriteTask(editText.getText().toString());
                W.start();*/
            }
        });


    }
}
