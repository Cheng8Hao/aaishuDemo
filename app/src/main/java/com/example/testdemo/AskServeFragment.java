package com.example.testdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Carson_Ho on 16/7/22.
 */
public class AskServeFragment extends Fragment implements View.OnClickListener {
    private View rootView;
    LinearLayout gaoxinLinearLayout;
    LinearLayout ruanjianLinearLayout;
    LinearLayout zhuanliLinearLayout;
    LinearLayout shangbiaoLinearLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (null == rootView) {
            rootView = inflater.inflate(R.layout.askservefragment, container, false);
            initView(rootView);
        }
        return rootView;
        // return inflater.inflate(R.layout.askservefragment, container, false);
    }

    private void initView(View rootView) {
        gaoxinLinearLayout = (LinearLayout) rootView.findViewById(R.id.gaoxinLinearLayout);
        gaoxinLinearLayout.setOnClickListener(this);

        ruanjianLinearLayout = (LinearLayout) rootView.findViewById(R.id.ruanjianLinearLayout);
        ruanjianLinearLayout.setOnClickListener(this);

        zhuanliLinearLayout = (LinearLayout) rootView.findViewById(R.id.zhuanliLinearLayout);
        zhuanliLinearLayout.setOnClickListener(this);

        shangbiaoLinearLayout = (LinearLayout) rootView.findViewById(R.id.shangbiaoLinearLayout);
        shangbiaoLinearLayout.setOnClickListener(this);
        //just for test 2019-04-18

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.gaoxinLinearLayout: // 高新技术企业认证
                Toast.makeText(getActivity(), "onClick: gaoxinLinearLayout", Toast.LENGTH_SHORT).show();
                break;
               /* intent = new Intent(getActivity(), StartLoginActivity.class);
                startActivity(intent);*/

            case R.id.ruanjianLinearLayout: // 软件著作权
                Toast.makeText(getActivity(), "onClick: ruanjianLinearLayout", Toast.LENGTH_SHORT).show();
                break;
               /* intent = new Intent(getActivity(), StartLoginActivity.class);
                startActivity(intent);*/

            case R.id.zhuanliLinearLayout: // 专利申请
                Toast.makeText(getActivity(), "onClick: zhuanliLinearLayout", Toast.LENGTH_SHORT).show();
                break;
               /* intent = new Intent(getActivity(), StartLoginActivity.class);
                startActivity(intent);*/

            case R.id.shangbiaoLinearLayout: // 商标注册
                Toast.makeText(getActivity(), "onClick: shangbiaoLinearLayout", Toast.LENGTH_SHORT).show();
                break;
               /* intent = new Intent(getActivity(), StartLoginActivity.class);
                startActivity(intent);*/
        }


    }
}
