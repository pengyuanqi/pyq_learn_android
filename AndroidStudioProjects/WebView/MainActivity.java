package org.hotpoor.pyq.webview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {


    private String url="https://www.baidu.com/";
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);
        //Uri uri=Uri.parse(url);//url为你要链接的地址
        //Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        //startActivity(intent);
        init();
    }

    private void init() {
        webView= (WebView) findViewById(R.id.webView);
        //WebView加载本地资源
        //webView.loadUrl("file:///android_asset/example.html");
        //WebView加载web资源
        webView.loadUrl("http://www.baidu.com");
        //覆盖WebView默认通过第三方或者是系统浏览器打开网页的行为，使得网页可以在WebView中打开
    }   webView.setWebViewClient(new WebViewClient(){
        shou
    };
}
