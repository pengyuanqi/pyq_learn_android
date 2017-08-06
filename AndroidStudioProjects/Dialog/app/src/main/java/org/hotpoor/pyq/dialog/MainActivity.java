package org.hotpoor.pyq.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    String[]single_list={"男","女"};
    String[]multi_list={"篮球","足球","排球","乒乓球"};
    String[]item_list={"项目经理","策划","测试","程序员","美工"};

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
        findViewById(R.id.dialog_btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            showDialog1();
            }
        });

        findViewById(R.id.dialog_btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog2();
            }
        });

        findViewById(R.id.dialog_btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog3();
            }
        });

        findViewById(R.id.dialog_btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog4();
            }
        });

        findViewById(R.id.dialog_btn5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog5();
            }
        });

    }
    /*
     *显示确认对话框
     */
    private void showDialog1(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("确认对话框");//设置标题
        builder.setIcon(R.mipmap.ic_launcher);//设置图标
        builder.setMessage("确认对话框提示内容");//设置内容
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this , "点击了确定按钮" , Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this , "点击了取消按钮" , Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog dialog=builder.create();//获取dialog
        dialog.show();//显示对话框
    }
    /*
     *显示单选按钮对话框
     */
    private void showDialog2(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("选择性别");//设置标题
        builder.setIcon(R.mipmap.ic_launcher);//设置图标
        builder.setSingleChoiceItems(single_list, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str=single_list[which];
                Toast.makeText(MainActivity.this ,"这个人是"+str , Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog dialog=builder.create();//获取dialog
        dialog.show();//显示对话框
    }
    /*
     *显示多选按钮对话框
     */
    private void showDialog3(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("爱好");//设置标题
        builder.setIcon(R.mipmap.ic_launcher);//设置图标
        builder.setMultiChoiceItems(multi_list, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked)
                    Toast.makeText(MainActivity.this, "我喜欢" + multi_list[which], Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this ,"我不喜欢"+multi_list[which] , Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog=builder.create();//获取dialog
        dialog.show();//显示对话框
    }
    /*
     *显示列表对话框
     */
    private void showDialog4(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("部门列表");//设置标题
        builder.setIcon(R.mipmap.ic_launcher);//设置图标
        builder.setItems(item_list, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this ,"我是"+item_list[which] , Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog dialog=builder.create();//获取dialog
        dialog.show();//显示对话框
    }
    /*
     *显示自定义对话框
     */
    private void showDialog5(){
        LayoutInflater inflater=LayoutInflater.from(this);
        View view=inflater.inflate(R.layout.dialog,null);
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("自定义对话框");//设置标题
        builder.setIcon(R.mipmap.ic_launcher);//设置图标
        builder.setView(view);
        //创建dialog
        final Dialog dialog=builder.create();
        Button bt = (Button) view.findViewById(R.id.bt);
        final EditText et = (EditText) view.findViewById(R.id.editText);
        bt.setOnClickListener(new android.view.View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String str=et.getText().toString();
                Toast.makeText(MainActivity.this,"提交的内容是"+str,Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });
        dialog.show();//显示对话框
    }
}
