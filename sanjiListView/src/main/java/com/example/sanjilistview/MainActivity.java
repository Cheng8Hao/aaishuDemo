package com.example.sanjilistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    private ListView lv01, lv02, lv03;
    ArrayAdapter<String> provinceAdapter = null;   //省级适配器
    ArrayAdapter<String> cityAdapter = null;    //地级适配器
    ArrayAdapter<String> countyAdapter = null;    //县级适配器
    static int provincePosition = 3;
    private String[] Sprovince;
    private String[][] city;
    private String[][][] county;
    private String[][][] countys;
    private TextView contentTv;
    private LinearLayout allData;
    private boolean isVisible = false;
    private String proSt, cityContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
        setData();
        setListView();
        setListener();
    }

    private void setListener() {
        lv01.setOnItemClickListener(this);
        lv02.setOnItemClickListener(this);
        lv03.setOnItemClickListener(this);
        contentTv.setOnClickListener(this);
    }

    private void setListView() {
        provinceAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Sprovince);
        lv01.setAdapter(provinceAdapter);

        cityAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, city[0]);  //默认选中首项
        lv02.setAdapter(cityAdapter);

        countyAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, county[0][0]); //默认选中首项
        lv03.setAdapter(countyAdapter);
    }

    private void setViews() {
        lv01 = (ListView) findViewById(R.id.lv01);
        lv02 = (ListView) findViewById(R.id.lv02);
        lv03 = (ListView) findViewById(R.id.lv03);
        contentTv = (TextView) findViewById(R.id.contentTv);
        allData = (LinearLayout) findViewById(R.id.allData);
        allData.setVisibility(View.GONE);
    }

    private void setData() {
        //省级选项值
        Sprovince = new String[]{"北京", "上海", "天津", "广东"};//,"重庆","黑龙江","江苏","山东","浙江","香港","澳门"};
        //地级选项值
        city = new String[][]
                {
                        {"北京", "东城区", "西城区", "崇文区", "宣武区", "朝阳区", "海淀区", "丰台区", "石景山区", "门头沟区",
                                "房山区", "通州区", "顺义区", "大兴区", "昌平区", "平谷区", "怀柔区", "密云县",
                                "延庆县"},
                        {"广东", "广州", "深圳", "韶关" // ,"珠海","汕头","佛山","湛江","肇庆","江门","茂名","惠州","梅州",
                                // "汕尾","河源","阳江","清远","东莞","中山","潮州","揭阳","云浮"
                        }
                };

        //县级选项值
        county = new String[][][]
                {
                        {   //北京
                                {"不限"}, {"北京县1"}, {"北京县2"}, {"北京县3"}, {"无"}, {"无"}, {"无"}, {"无"}, {"无"}, {"无"},
                                {"无"}, {"无"}, {"无"}, {"无"}, {"无"}, {"无"}, {"无"}, {"无"}
                        },

                        {    //广东
                                {"海珠区", "荔湾区", "越秀区", "白云区", "萝岗区", "天河区", "黄埔区", "花都区", "从化市", "增城市", "番禺区", "南沙区"}, //广州
                                {"宝安区", "福田区", "龙岗区", "罗湖区", "南山区", "盐田区"}, //深圳
                                {"武江区", "浈江区", "曲江区", "乐昌市", "南雄市", "始兴县", "仁化县", "翁源县", "新丰县", "乳源县"}  //韶关
                        }
                };
        countys = new String[][][]
                {
                        {{"无"}}
                };
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.lv01:
                //此处为了更新在点击第一列,清除之前第三列的数据
                countyAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countys[0][0]); //默认选中首项
                lv03.setAdapter(countyAdapter);

                cityAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, city[position]);
                lv02.setAdapter(cityAdapter);
                proSt = (String) (parent.getItemAtPosition(position));
                provincePosition = position;
                break;
            case R.id.lv02:
                countyAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, county[provincePosition][position]);
                lv03.setAdapter(countyAdapter);
                cityContent = (String) (parent.getItemAtPosition(position));
                break;
            case R.id.lv03:
                String content = (String) (parent.getItemAtPosition(position));
                Log.i("Tag", "获取的内容:" + proSt + cityContent + content);
                //消除显示
                allData.setVisibility(View.GONE);
                contentTv.setText(content);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        if (contentTv.getText() != null) {
            contentTv.setText("正在选择......");
        }
        if (allData.getVisibility() == View.GONE) {
            allData.setVisibility(View.VISIBLE);
        }
    }
}

