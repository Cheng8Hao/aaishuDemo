package com.example.testdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ChengHao on 2019/04/15
 */
public class CheckPolicyFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "Fragment1";
    private View rootView;
    private MeasureGridView mTopGridView;
    private MeasureGridView mshouzhongquntiGridView;
    private MeasureGridView mzhengceleixinGridView;
    private MeasureGridView mshoulibumenGridView;
    private MeasureGridView mzhengcejieduGridView;
    private RelativeLayout shouzhongRelativeLayout;
    private RelativeLayout zhengceRelativeLayout;
    private RelativeLayout shouliRelativeLayout;
    private RelativeLayout zhengcejieduRelativeLayout;
    private RelativeLayout dongtaizhengceRelativeLayout;
    private RelativeLayout jinqixiangmoshengbaoRelativeLayout;
    private RelativeLayout redianxiangmushengbaoRelativeLayout;
    private ImageView chakanzhengcekuImageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        if (null == rootView) {
            rootView = inflater.inflate(R.layout.checkpolicyfragment, container, false);
            initView(rootView);
        }
        return rootView;
    }

    private void initView(View rootView) {
        /*String topGridViewStr[] = {"项目申报", "项目公告", "政策法规", "政策解读"};
        int topGridViewImage[] = {R.drawable.apple_pic, R.drawable.pear_pic, R.drawable.strawberry_pic,
                R.drawable.banana_pic};
        initTopGridView(rootView, topGridViewStr, topGridViewImage);*/

        /*  String shouzhongquntiGridViewStr[] = {"政策解读111111", "政策解读2222222222"};
        int shouzhongquntiGridViewImage[] = {R.drawable.apple_pic, R.drawable.pear_pic};
        initzhengcejieduGridView(rootView,shouzhongquntiGridViewStr,shouzhongquntiGridViewImage);*/
        initTopGridView(rootView);
        initshouzhongquntiGridView(rootView);
        initzhengceleixinGridView(rootView);
        initshoulibumenGridView(rootView);
        initzhengcejieduGridView(rootView);

        shouzhongRelativeLayout = (RelativeLayout) rootView.findViewById(R.id.shouzhong);
        shouzhongRelativeLayout.setOnClickListener(this);
        zhengceRelativeLayout = (RelativeLayout) rootView.findViewById(R.id.zhengce);
        zhengceRelativeLayout.setOnClickListener(this);
        shouliRelativeLayout = (RelativeLayout) rootView.findViewById(R.id.shouli);
        shouliRelativeLayout.setOnClickListener(this);
        zhengcejieduRelativeLayout = (RelativeLayout) rootView.findViewById(R.id.zhengcejiedu);
        zhengcejieduRelativeLayout.setOnClickListener(this);
        dongtaizhengceRelativeLayout = (RelativeLayout) rootView.findViewById(R.id.dongtaizhengce);
        dongtaizhengceRelativeLayout.setOnClickListener(this);

        jinqixiangmoshengbaoRelativeLayout = (RelativeLayout) rootView.findViewById(R.id.jinqixiangmoshengbao);
        jinqixiangmoshengbaoRelativeLayout.setOnClickListener(this);
        redianxiangmushengbaoRelativeLayout = (RelativeLayout) rootView.findViewById(R.id.redianxiangmushengbao);
        redianxiangmushengbaoRelativeLayout.setOnClickListener(this);
        chakanzhengcekuImageView = (ImageView) rootView.findViewById(R.id.chakanzhengceku);
        chakanzhengcekuImageView.setOnClickListener(this);
    }

    private void initTopGridView(View rootView) {
        String topGridViewStr[] = {"项目申报", "项目公告", "政策法规", "政策解读"};
        int topGridViewImage[] = {R.drawable.apple_pic, R.drawable.pear_pic, R.drawable.strawberry_pic,
                R.drawable.banana_pic};
        //准备要添加的数据条目
        List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < topGridViewStr.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", topGridViewImage[i]);//添加图像资源的ID
            item.put("textItem", topGridViewStr[i]);//按序号添加ItemText
            items.add(item);
        }

        //实例化一个适配器
        SimpleAdapter adapter = new SimpleAdapter(getActivity(),
                items,
                R.layout.gridview_item_textbelowimage,
                new String[]{"imageItem", "textItem"},
                new int[]{R.id.image_item, R.id.text_item});

        //获得GridView实例
        mTopGridView = (MeasureGridView) rootView.findViewById(R.id.top_grid_view);
        mTopGridView.setNumColumns(4);
        //为GridView设置适配器
        mTopGridView.setAdapter(adapter);
        mTopGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(getActivity(), "mTopGridView pic" + position, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initTopGridView(View rootView, String[] strText, int icno[]) {
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
                R.layout.gridview_item_textbelowimage,
                new String[]{"imageItem", "textItem"},
                new int[]{R.id.image_item, R.id.text_item});

        //获得GridView实例
        mTopGridView = (MeasureGridView) rootView.findViewById(R.id.top_grid_view);
        mTopGridView.setNumColumns(4);
        //为GridView设置适配器
        mTopGridView.setAdapter(adapter);
        mTopGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(getActivity(), "mTopGridView pic" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initshouzhongquntiGridView(View rootView) {
        String str_shouzhong[] = {"高校毕业生", "科技人员", "留学人员", "中小微型企业", "投资机构", "更多"};
        //准备要添加的数据条目
        List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < str_shouzhong.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("textItem", str_shouzhong[i]);//按序号添加ItemText
            items.add(item);
        }

        //实例化一个适配器
        SimpleAdapter adapter = new SimpleAdapter(getActivity(),
                items,
                R.layout.gridview_item_text_pink,
                new String[]{"textItem"},
                new int[]{R.id.text_item});

        //获得GridView实例
        mshouzhongquntiGridView = (MeasureGridView) rootView.findViewById(R.id.shouzhongqunti_grid_view);
        mshouzhongquntiGridView.setNumColumns(3);

        //为GridView设置适配器
        mshouzhongquntiGridView.setAdapter(adapter);
        mshouzhongquntiGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(getActivity(), "pic" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initzhengceleixinGridView(View rootView) {
        String str_zhengceleixing[] = {"财政引导", "税收政策", "产业扶持", "金融扶持", "人才扶持", "更多"};
        //准备要添加的数据条目
        List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < str_zhengceleixing.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("textItem", str_zhengceleixing[i]);//按序号添加ItemText
            items.add(item);
        }

        //实例化一个适配器
        SimpleAdapter adapter = new SimpleAdapter(getActivity(),
                items,
                R.layout.gridview_item_text_orange,
                new String[]{"textItem"},
                new int[]{R.id.text_item});

        //获得GridView实例
        mzhengceleixinGridView = (MeasureGridView) rootView.findViewById(R.id.zhengceleixing_grid_view);
        mzhengceleixinGridView.setNumColumns(3);

        //为GridView设置适配器
        mzhengceleixinGridView.setAdapter(adapter);
        mzhengceleixinGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(getActivity(), "pic" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initshoulibumenGridView(View rootView) {
        final String str_shoulibumeng[] = {"财政", "发改", "经信", "商务", "科技"};
        //准备要添加的数据条目
        List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < str_shoulibumeng.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("textItem", str_shoulibumeng[i]);//按序号添加ItemText
            items.add(item);
        }

        //实例化一个适配器
        SimpleAdapter adapter = new SimpleAdapter(getActivity(),
                items,
                R.layout.gridview_item_text_blue,
                new String[]{"textItem"},
                new int[]{R.id.text_item});


        //获得GridView实例
        mshoulibumenGridView = (MeasureGridView) rootView.findViewById(R.id.shoulibumen_grid_view);
        mshoulibumenGridView.setNumColumns(4);

        //为GridView设置适配器
        mshoulibumenGridView.setAdapter(adapter);
        mshoulibumenGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(getActivity(), "pic" + position + "  " + str_shoulibumeng[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initzhengcejieduGridView(View rootView) {
        String shouzhongquntiGridViewStr[] = {"政策解读111111", "政策解读2222222222"};
        int shouzhongquntiGridViewImage[] = {R.drawable.apple_pic, R.drawable.pear_pic};
        //准备要添加的数据条目
        List<Map<String, Object>> items = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < shouzhongquntiGridViewStr.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("imageItem", shouzhongquntiGridViewImage[i]);//添加图像资源的ID
            item.put("textItem", shouzhongquntiGridViewStr[i]);//按序号添加ItemText
            items.add(item);
        }

        //实例化一个适配器
        SimpleAdapter adapter = new SimpleAdapter(getActivity(),
                items,
                R.layout.gridview_item_textbelowimage,
                new String[]{"imageItem", "textItem"},
                new int[]{R.id.image_item, R.id.text_item});

        //获得GridView实例
        mzhengcejieduGridView = (MeasureGridView) rootView.findViewById(R.id.zhengcejiedu_grid_view);
        mzhengcejieduGridView.setNumColumns(2);
        //为GridView设置适配器

        mzhengcejieduGridView.setAdapter(adapter);
        mzhengcejieduGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(getActivity(), "pic" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void initzhengcejieduGridView(View rootView, String[] strText, int icno[]) {

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
                R.layout.gridview_item_textbelowimage,
                new String[]{"imageItem", "textItem"},
                new int[]{R.id.image_item, R.id.text_item});

        //获得GridView实例
        mzhengcejieduGridView = (MeasureGridView) rootView.findViewById(R.id.zhengcejiedu_grid_view);
        mzhengcejieduGridView.setNumColumns(2);
        //为GridView设置适配器

        mzhengcejieduGridView.setAdapter(adapter);
        mzhengcejieduGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(getActivity(), "pic" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.shouzhong: //受众群体
            {
                Toast.makeText(getActivity(), "onClick: shouzhongRelativeLayout", Toast.LENGTH_SHORT).show();
                break;
               /* intent = new Intent(getActivity(), StartLoginActivity.class);
                startActivity(intent);*/
            }
            case R.id.zhengce: //政策类型
            {
                Toast.makeText(getActivity(), "onClick: zhengceRelativeLayout", Toast.LENGTH_SHORT).show();
                break;
                /*intent = new Intent(getActivity(), StartLoginActivity.class);
                startActivity(intent);*/
            }
            case R.id.shouli: //受理部门
            {
                Toast.makeText(getActivity(), "onClick: shouliRelativeLayout", Toast.LENGTH_SHORT).show();
                break;
                /*intent = new Intent(getActivity(), StartLoginActivity.class);
                startActivity(intent);*/
            }


            case R.id.dongtaizhengce: //动态政策
            {
                Toast.makeText(getActivity(), "onClick: dongtaizhengce RelativeLayout", Toast.LENGTH_SHORT).show();
                break;
                /*intent = new Intent(getActivity(), StartLoginActivity.class);
                startActivity(intent);*/
            }


            case R.id.redianxiangmushengbao: //热点项目
            {
                Toast.makeText(getActivity(), "onClick: ridianxiangmushengbao RelativeLayout", Toast.LENGTH_SHORT).show();
                break;
                /*intent = new Intent(getActivity(), StartLoginActivity.class);
                startActivity(intent);*/
            }

            case R.id.jinqixiangmoshengbao: //近期项目申报
            {
                Toast.makeText(getActivity(), "onClick: jinqixiangmoshengbao RelativeLayout", Toast.LENGTH_SHORT).show();
                break;
                /*intent = new Intent(getActivity(), StartLoginActivity.class);
                startActivity(intent);*/
            }
            case R.id.chakanzhengceku: //政策解读
            {
                Toast.makeText(getActivity(), "onClick: chakanzhengceku ImageView", Toast.LENGTH_SHORT).show();
                break;
                /*intent = new Intent(getActivity(), StartLoginActivity.class);
                startActivity(intent);*/
            }

            case R.id.zhengcejiedu: //政策解读
            {
                Toast.makeText(getActivity(), "onClick: zhengcejiedu RelativeLayout", Toast.LENGTH_SHORT).show();
                break;
                /*intent = new Intent(getActivity(), StartLoginActivity.class);
                startActivity(intent);*/
            }

        }
    }
}
