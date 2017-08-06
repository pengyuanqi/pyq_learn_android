package org.hotpoor.pyq.gridview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener{

    private GridView gridView;
    private List<Map<String,Object>>dataList;
    private int[]icon={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,
            R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i};
    private String[]iconName={"a","b","c","d","e","f","g","h","i"};
    private SimpleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gridView= (GridView) findViewById(R.id.gridView);
        //1.准备数据源
        //2.新建适配器（SimpleAdapter）
        //3.GridView加载适配器
        //4.GridView配置事件监听器（OnItemClickListen）
        dataList=new ArrayList<Map<String,Object>>();
        //getData();
        adapter=new SimpleAdapter(this, getData(), R.layout.item, new String[]{"image","text"}, new int[]{R.id.image,R.id.text});

        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);
    }
    private List<Map<String,Object>> getData(){
        for(int i=0;i<icon.length;i++)
        {
            Map<String,Object>map=new HashMap<String, Object>();
            map.put("image",icon[i]);
            map.put("text",iconName[i]);
            dataList.add(map);
        }
        return dataList;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(this,"我是"+iconName[position], Toast.LENGTH_SHORT).show();
    }
}
