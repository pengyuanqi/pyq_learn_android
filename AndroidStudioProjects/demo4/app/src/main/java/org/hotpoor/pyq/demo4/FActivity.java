package org.hotpoor.pyq.demo4;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class FActivity extends Activity{
    private Button bt1;
    private Button bt2;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.factivity);

        tv= (TextView) findViewById(R.id.textView);
        bt1= (Button) findViewById(R.id.button1_first);
        bt2= (Button) findViewById(R.id.button2_second);

        bt1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 *第一个参数：上下文对象this
                 *第二个参数：目标文件
                 */
                Intent intent=new Intent(FActivity.this,SActivity.class);
                startActivity(intent);
            }
        });
        /*
         *通过startActivityForResult
         */
        bt2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FActivity.this,SActivity.class);
                /*
                 *第一个参数是Intent对象
                 *第二个参数是请求的一个标识
                 */
                startActivityForResult(intent,1);
            }
        });
    }

    /*
     *通过startActivityForResult跳转，接收返回数据的方法
     * requestCode：请求的标识
     * resultCode：第二个页面返回的标识
     * data：第二个页面回传的数据
     */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("==========");
        if (requestCode==1&&resultCode==2){
            String content = data.getStringExtra("data");
            tv.setText(content);
        }
    }
}
