package com.example.testdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Carson_Ho on 16/7/22.
 */
public class CheckitemFragment extends Fragment {

    private static final String TAG = "Fragment2";
    private View rootView;
    private MeasureGridView mHotProjectGridView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (null == rootView) {
            rootView = inflater.inflate(R.layout.checkitemfragment, container, false);
            initView(rootView);
        }
        return rootView;
    }

    private void initView(View rootView) {
        String strText[] = {"小巨人", "科创版", "高新技术企业认定"};
        int icno[] = {R.drawable.apple_pic, R.drawable.pear_pic, R.drawable.strawberry_pic};
        initHotProjectGridView(rootView, strText, icno);
    }

    private void initHotProjectGridView(View rootView, String[] strText, int icno[]) {

        //准备要添加的数据条目
        List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < strText.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", icno[i]);//添加图像资源的ID
            item.put("textItem", strText[i]);//按序号添加ItemText
            items.add(item);
        }

        //实例化一个适配器
        SimpleAdapter adapter = new SimpleAdapter(getActivity(),
                items,
                R.layout.gridview_item_itextinimage,
                new String[]{"imageItem", "textItem"},
                new int[]{R.id.image_item, R.id.text_item});

        //获得GridView实例
        mHotProjectGridView = (MeasureGridView) rootView.findViewById(R.id.hotProjectgridview);
        mHotProjectGridView.setNumColumns(3);
        //为GridView设置适配器

        mHotProjectGridView.setAdapter(adapter);
        mHotProjectGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(getActivity(), "pic" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
