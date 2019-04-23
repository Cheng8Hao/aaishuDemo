package com.example.testdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by chenghao on 2019/04/20.
 */
public class chFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] mTitles = new String[]{"查政策", "查立项", "要服务"};

    public chFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return new CheckitemFragment();
        } else if (position == 2) {
            return new AskServeFragment();
        }
        return new CheckPolicyFragment();
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
