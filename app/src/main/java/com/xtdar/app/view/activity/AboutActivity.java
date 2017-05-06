package com.xtdar.app.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xtdar.app.R;
import com.xtdar.app.presenter.ConfigPresenter;


public class AboutActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout mLayoutModifyPass;
    private ConfigPresenter mConfigPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        initViews();
        //mConfigPresenter=new ConfigPresenter(this);
        //mConfigPresenter.init();
    }
    public void initViews(){

        layout_back= (RelativeLayout) findViewById(R.id.layout_back);
        layout_back.setOnClickListener(this);
        mTextTitle =(TextView) findViewById(R.id.text_title);
        mTextTitle.setText("关于");
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.layout_back:
                finish();
                break;

        }
    }
}
