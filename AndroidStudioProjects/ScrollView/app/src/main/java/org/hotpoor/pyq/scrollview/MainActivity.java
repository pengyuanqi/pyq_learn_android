package org.hotpoor.pyq.scrollview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{

    private TextView tv;
    private ScrollView scroll;
    private Button up_btn;
    private Button down_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tv = (TextView) findViewById(R.id.content);
        up_btn= (Button) findViewById(R.id.up);
        down_btn= (Button) findViewById(R.id.down);
        up_btn.setOnClickListener(this);
        down_btn.setOnClickListener(this);
        tv.setText(getResources().getString(R.string.content));
        scroll = (ScrollView) findViewById(R.id.scroll);
        scroll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE: {
                        /*
                         * (1)getScrollY()---滚动条滑动的距离
                         * (2)getMeasuredHeight()---所有内容高度
                         * (3)getHeight()---屏幕显示高度
                         */

                        //顶部状态
                        if (scroll. getScrollY()<=0) {
                            Log.i("Main", "顶部");
                            tv.append("向上内容\n"+getResources().getString(R.string.content));
//                            tv.append("向上内容\n",0,1);
                        }
                        //底部状态
                        //TextView的总高度<=屏幕的高度+滚动条的滚动距离
                        if (scroll.getChildAt(0).getMeasuredHeight() <= scroll.getHeight() + scroll.getScrollY()) {
                            Log.i("Main", "滑动到底部");
                            Log.i("Main", "scroll.getChildAt(0).getMeasuredHeight()="
                                    + scroll.getChildAt(0).getMeasuredHeight()
                                    + "scroll.getHeight()="
                                    + scroll.getHeight()
                                    + "scroll.getScrollY()="
                                    + scroll.getScrollY());
                            //tv.append(getResources().getString(R.string.content));
                            tv.append("向下内容\n");
                        }
                        break;
                    }
                }

                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.up:
                {
                    scroll.scrollBy(0,-30);
                    break;
                }
            case R.id.down:
                {
                    scroll.scrollBy(0,30);
                    break;
                }

        }

    }
}
