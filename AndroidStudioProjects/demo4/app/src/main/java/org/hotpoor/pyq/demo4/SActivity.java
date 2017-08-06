package org.hotpoor.pyq.demo4;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

public class SActivity extends Activity{
    private Button bt;
    private String content="你好";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sactivity);
        bt= (Button) findViewById(R.id.button1);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data=new Intent();
                data.putExtra("data",content);
                setResult(2,data);
                //结束当前页面
                System.out.println("==========1");
                finish();
            }
        });
    }
}
