package com.xtdar.app.view.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by hmx on 2016/5/21.
 */
public class BaseActivity extends FragmentActivity  {
    protected TextView mTextTitle;
    protected RelativeLayout layout_back;
    protected SharedPreferences sp;
    protected SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //x.view().inject(this);
        sp = getSharedPreferences("UserConfig", MODE_PRIVATE);
        editor = sp.edit();
        }
}
