package org.hotpoor.pyq.service;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
    Intent intent1;
    Intent intent2;
    MyBindService service;
    ServiceConnection conn=new ServiceConnection() {
        @Override//当启动源跟Service成功连接之后将会自动调用这个方法
        public void onServiceConnected(ComponentName name, IBinder binder) {
             service=((MyBindService.MyBinder)binder).getService();
        }

        @Override//当启动源跟Service的连接意外丢失的时候会调用这个方法
        //比如当Service崩溃了或者被强行杀死了
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void doClick(View v){
        switch (v.getId()){
            case R.id.start:
                intent1=new Intent(MainActivity.this,MyStartService.class);
                startService(intent1);
                break;

            case R.id.stop:
                stopService(intent1);
                break;
            case R.id.play:
                service.Play();
                break;
            case R.id.pause:
                service.Pause();
                break;
            case R.id.previous:
                service.Pervious();
                break;
            case R.id.next:
                service.next();
                break;
            case R.id.bind:
                intent2=new Intent(MainActivity.this,MyBindService.class);
                startService(intent2);
                bindService(intent2,conn, Service.BIND_AUTO_CREATE);
                break;
            case R.id.unbind:
                unbindService(conn);
                break;

        }
    }

    @Override
    protected void onDestroy() {
        stopService(intent2);
        unbindService(conn);
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
