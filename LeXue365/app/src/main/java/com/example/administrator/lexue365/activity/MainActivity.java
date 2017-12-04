package com.example.administrator.lexue365.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.administrator.lexue365.R;
import com.example.administrator.lexue365.fragment.FragShouYe;
import com.example.administrator.lexue365.fragment.FragTuiJian;
import com.example.administrator.lexue365.fragment.FragWoDe;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mMain;
    private ImageView mTui;
    private ImageView mMine;
    private FrameLayout mFl;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        fragment = new FragShouYe();
        getFragment("fragment01", fragment);

    }

    private void initView() {
        mMain = (ImageView) findViewById(R.id.main);
        mMain.setOnClickListener(this);
        mTui = (ImageView) findViewById(R.id.tui);
        mTui.setOnClickListener(this);
        mMine = (ImageView) findViewById(R.id.mine);
        mMine.setOnClickListener(this);
        mFl = (FrameLayout) findViewById(R.id.fl);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main:
                fragment = new FragShouYe();
                getFragment("fragment01", fragment);
                mMain.setImageResource(R.mipmap.index_checked);
                mTui.setImageResource(R.mipmap.recommand_unchecked);
                mMine.setImageResource(R.mipmap.mine_checked);
                break;
            case R.id.tui:
                fragment = new FragTuiJian();
                getFragment("fragment02", fragment);
                mMain.setImageResource(R.mipmap.index_unchecked);
                mTui.setImageResource(R.mipmap.recommand_checked);
                mMine.setImageResource(R.mipmap.mine_unchecked);
                break;
            case R.id.mine:
                fragment = new FragWoDe();
                getFragment("fragment03", fragment);
                mMain.setImageResource(R.mipmap.index_unchecked);
                mTui.setImageResource(R.mipmap.recommand_unchecked);
                mMine.setImageResource(R.mipmap.mine_checked);
                break;
        }
    }

    public void getFragment(String name, Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.addToBackStack(name);
        transaction.replace(R.id.fl,fragment);
        transaction.commit();
    }
}
