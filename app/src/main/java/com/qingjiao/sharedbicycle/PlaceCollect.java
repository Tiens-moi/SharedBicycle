package com.qingjiao.sharedbicycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class PlaceCollect extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_place_collect);

    }
}
