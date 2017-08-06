package org.hotpoor.pyq.toast;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initEvent();
    }
    /*
     *初始化点击事件
     */
    private void initEvent(){
        findViewById(R.id.toast_btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast1();
            }
        });
        findViewById(R.id.toast_btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast2();
            }
        });
        findViewById(R.id.toast_btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast3();
            }
        });
        findViewById(R.id.toast_btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast4();
            }
        });

    }
    /*
     *显示默认toast
     */
    private void showToast1(){
        Toast toast= Toast.makeText(this,"这是一个默认的Toast",Toast.LENGTH_LONG);
        toast.show();
    }
    /*
     *显示自定义位置的Toast
     */
    private void showToast2(){
        Toast toast= Toast.makeText(this,"改变位置的Toast",Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }
    /*
     *带有图片的Toast
     */
    private void showToast3(){
        Toast toast= Toast.makeText(this,"带有图片的Toast",Toast.LENGTH_LONG);
        LinearLayout toast_layout= (LinearLayout) toast.getView();
        ImageView iv=new ImageView(this);
        iv.setImageResource(R.mipmap.ic_launcher);
        toast_layout.addView(iv,0);
        toast.show();
    }
    /*
     *完全自定义的Toast
     */
    private void showToast4(){
        LayoutInflater inflater=LayoutInflater.from(this);
        View toast_view=inflater.inflate(R.layout.toast_layout,null);
        Toast toast= new Toast(this);
        toast.setView(toast_view);
        toast.show();
    }
}

