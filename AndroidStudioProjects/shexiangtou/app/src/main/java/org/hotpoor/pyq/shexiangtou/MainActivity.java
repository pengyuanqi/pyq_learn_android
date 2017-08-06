package org.hotpoor.pyq.shexiangtou;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public Button camera_btn;
    public LinearLayout imagesLinear;
    public static int i= 0;
    public File[] files;
    public String[] arr;
    public int j;
    public String path;
    public String uri;
    public List list;


    public void customCamera(View view){
        startActivity(new Intent(this,CustomCamera.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=new ArrayList();
        //camera_btn = (Button)findViewById(R.id.button);
        //camera_btn.callOnClick();
        new Thread() {
            public void run() {
                path = "/sdcard/pyq_dev/";
                getFiles(path);
                System.out.println(path + " 文件夹下面共有 " + i + " 张图片文件");
            };
        }.start();
        System.out.println(this);
        System.out.println("====");
         /*为什么图片一定要转化为 Bitmap格式的！！ */
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                imagesLinear = (LinearLayout)findViewById(R.id.imagesLinear);
                for (int b = 0; b < list.size(); b++) {
                    String name = list.get(b).toString();
                    ImageView imageView = new ImageView(MainActivity.this);
                    imageView.setLayoutParams(new ActionBar.LayoutParams(200, 200));
                    System.out.println(name);
                    System.out.println("=====");
                    Bitmap bitmap = getLoacalBitmap(name); //从本地取图片(在cdcard中获取)  //
                    imageView.setImageBitmap(bitmap); //设置Bitmap
                    imagesLinear.addView(imageView);
                }
            }
        });
    }

    public void getFiles(final String string) {
        // TODO Auto-generated method stub
        File file = new File(string);
        files = file.listFiles();
        for (j = 0; j < files.length; j++) {
            String name = files[j].getName();
            if (files[j].isDirectory()) {
                String dirPath = files[j].toString().toLowerCase();
                System.out.println(dirPath);
                getFiles(dirPath + "/");
            } else if (files[j].isFile() & name.endsWith(".jpg") || name.endsWith(".png") || name.endsWith(".bmp") || name.endsWith(".gif") || name.endsWith(".jpeg")) {
                System.out.println("FileName===" + files[j].getName());
                uri = path +files[j].getName();
                list.add(uri);
                i++;
            }
        }

    }

    /**
     * 加载本地图片
     * @param url
     * @return
     */
    public static Bitmap getLoacalBitmap(String url) {
        try {
            FileInputStream fis = new FileInputStream(url);
            return BitmapFactory.decodeStream(fis);  ///把流转化为Bitmap图片

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
