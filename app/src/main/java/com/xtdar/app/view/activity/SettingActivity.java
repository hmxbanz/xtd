package com.xtdar.app.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xtdar.app.common.NToast;
import com.xtdar.app.presenter.ConfigPresenter;

import com.xtdar.app.R;
import com.xtdar.app.widget.DialogWithYesOrNoUtils;

import java.io.File;


public class SettingActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout mLayoutAbout,mLayoutClear,mLayoutFeeback;
    private ConfigPresenter mConfigPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        initViews();
        mConfigPresenter=new ConfigPresenter(this);
        mConfigPresenter.init();
    }
    public void initViews(){
        layout_back= (RelativeLayout) findViewById(R.id.layout_back);
        layout_back.setOnClickListener(this);
        mLayoutAbout= (LinearLayout) findViewById(R.id.layout_about);
        mLayoutAbout.setOnClickListener(this);
        mLayoutClear = (LinearLayout) findViewById(R.id.layout_clear);
        mLayoutClear.setOnClickListener(this);
        mLayoutFeeback= (LinearLayout) findViewById(R.id.layout_feedback);
        mLayoutFeeback.setOnClickListener(this);

        mTextTitle =(TextView) findViewById(R.id.text_title);
        mTextTitle.setText("设置");
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_back:
                finish();
                break;
            case R.id.layout_about:
                startActivity(new Intent(this,AboutActivity.class));
                break;
            case R.id.layout_clear:
                DialogWithYesOrNoUtils.getInstance().showDialog(this, "确定要清除缓存吗?", new DialogWithYesOrNoUtils.DialogCallBack() {
                    @Override
                    public void executeEvent() {
                        File file = new File(Environment.getExternalStorageDirectory().getPath() + getPackageName());
                        //deleteFile(file);
                        NToast.shortToast(SettingActivity.this, "消除成功");
                    }

                });
                break;
            case R.id.layout_feedback:
                startActivity(new Intent(this,FeedbackActivity.class));
                break;


        }
    }
}
