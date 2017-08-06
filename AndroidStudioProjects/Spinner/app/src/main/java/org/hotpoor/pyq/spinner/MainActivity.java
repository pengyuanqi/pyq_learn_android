package org.hotpoor.pyq.spinner;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener{

    private TextView textView;
    private Spinner spinner;
    private List<String>list;
    private ArrayAdapter<String>adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        textView= (TextView) findViewById(R.id.textView);
        spinner= (Spinner) findViewById(R.id.spinner);
        textView.setText("您选择的城市是北京");
        //1.设置数据源
        list=new ArrayList<String>();
        list.add("北京");
        list.add("上海");
        list.add("广州");
        list.add("深圳");

        //2.新建ArrayAdapter（数组适配器）
        adapter=new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item , list);
        //3.adapter设置一个下拉列表的样式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //4.spinner加载适配器
        spinner.setAdapter(adapter);
        //5.spinner设置监听器
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String cityname=adapter.getItem(position);
        //String city=list.get(position);
        textView.setText("您选择的城市是"+cityname);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
