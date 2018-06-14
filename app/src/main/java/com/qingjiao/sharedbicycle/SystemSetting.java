package com.qingjiao.sharedbicycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.qingjiao.sharedbicycle.system.AboutUs;
import com.qingjiao.sharedbicycle.system.ChangePassword;
import com.qingjiao.sharedbicycle.system.IntroduceProductActivity;
import com.qingjiao.sharedbicycle.system.SuggestActivity;

public class SystemSetting extends AppCompatActivity implements View.OnClickListener {

    private Button btnProduce,btnSuggest,btnChangePassword,btnVersionUpdate,btnAboutUs,btnLoginOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_system_setting);

        btnProduce = (Button)findViewById(R.id.btn_introduce_product);
        btnSuggest = (Button)findViewById(R.id.btn_suggest_send);
        btnChangePassword = (Button)findViewById(R.id.btn_change_password);
        btnVersionUpdate = (Button)findViewById(R.id.btn_version_update);
        btnAboutUs = (Button)findViewById(R.id.about_us);
        btnLoginOut = (Button)findViewById(R.id.btn_login_out);


        btnProduce.setOnClickListener(this);
        btnSuggest.setOnClickListener(this);
        btnChangePassword.setOnClickListener(this);
        btnVersionUpdate.setOnClickListener(this);
        btnAboutUs.setOnClickListener(this);
        btnLoginOut.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_introduce_product:
                Intent intent1 = new Intent(SystemSetting.this, IntroduceProductActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_suggest_send:
                Intent intent2 = new Intent(SystemSetting.this, SuggestActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_change_password:
                Intent intent3 = new Intent(SystemSetting.this, ChangePassword.class);
                startActivity(intent3);
                break;
            case R.id.btn_version_update:
                Toast.makeText(getApplication(),"当前已是最新版本",Toast.LENGTH_SHORT).show();
                break;
            case R.id.about_us:
                Intent intent4 = new Intent(SystemSetting.this, AboutUs.class);
                startActivity(intent4);
                break;
            case R.id.btn_login_out:
                Toast.makeText(getApplication(),"这是第一个按钮",Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
