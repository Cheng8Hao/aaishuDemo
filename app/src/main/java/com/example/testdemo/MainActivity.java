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
    //    private ArrayList<View> aList;
    private MyFragmentPagerAdapter myFragmentPagerAdapter;
    private TabLayout mTabLayout;
    TabLayout.Tab one;
    TabLayout.Tab two;
    TabLayout.Tab three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*vpager_one = (ViewPager) findViewById(R.id.vpager_one);
        aList = new ArrayList<View>();
        LayoutInflater li = getLayoutInflater();
        aList.add(li.inflate(R.layout.view_one,null,false));
        aList.add(li.inflate(R.layout.view_two,null,false));
        mAdapter = new MyPagerAdapter(aList);
        vpager_one.setAdapter(mAdapter);*/

        /*mytab = (TabLayout) findViewById(R.id.mytab);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        LayoutInflater inflater = getLayoutInflater();
        View view_one = inflater.inflate(R.layout.view_one, null);
        View view_two = inflater.inflate(R.layout.view_two, null);
        View view_three = inflater.inflate(R.layout.view_three, null);

        aList = new ArrayList<View>();// 将要分页显示的View装入数组中
        aList.add(view_one);
        aList.add(view_two);
        aList.add(view_three);

        viewPager.setAdapter(new MyPagerAdapter(aList));
        mytab.setupWithViewPager(viewPager);
        mytab.getTabAt(0).setText(" 查政策 ");
        mytab.getTabAt(1).setText("查立项");
        mytab.getTabAt(2).setText("要服务");

        mytab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });*/

        //使用适配器将ViewPager与Fragment绑定在一起
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
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
