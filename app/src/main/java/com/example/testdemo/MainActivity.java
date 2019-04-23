package com.example.testdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager mViewPager;
    private chFragmentPagerAdapter myFragmentPagerAdapter;
    private TabLayout mTabLayout;
    private TabLayout.Tab one;
    private TabLayout.Tab two;
    private TabLayout.Tab three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //chenghao M for 首页 2019-04-20 begin
        //使用适配器将ViewPager与Fragment绑定在一起
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        myFragmentPagerAdapter = new chFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(myFragmentPagerAdapter);
        //将TabLayout与ViewPager绑定在一起
        mTabLayout = (TabLayout) findViewById(R.id.mytab);
        mTabLayout.setupWithViewPager(mViewPager);
        //指定Tab的位置
        one = mTabLayout.getTabAt(0);
        two = mTabLayout.getTabAt(1);
        three = mTabLayout.getTabAt(2);
        //设置Tab的图标
        /*one.setIcon(R.mipmap.ic_launcher);
        two.setIcon(R.mipmap.ic_launcher);
        three.setIcon(R.mipmap.ic_launcher);*/

        LinearLayout xiangmushenbao = (LinearLayout) findViewById(R.id.xiangmushenbaoLinearLayout);
        xiangmushenbao.setOnClickListener(this);

        ImageView xiangmoshenbaoImageView = (ImageView) findViewById(R.id.xiangmoshenbaoImageView);
        xiangmoshenbaoImageView.setOnClickListener(this);
        //chenghao M for 首页 2019-04-20 begin

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.xiangmushenbaoLinearLayout: //项目申报
                Log.d("chenghao666", "onClick: xiangmushenbaoLinearLayout");
                Toast.makeText(this, "onClick: xiangmushenbaoLinearLayout", Toast.LENGTH_SHORT).show();
                break;
            case R.id.xiangmoshenbaoImageView: //项目申报右箭头
                Log.d("chenghao666", "onClick: xiangmoshenbaoImageView");
                Toast.makeText(this, "onClick: xiangmoshenbaoImageView", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
