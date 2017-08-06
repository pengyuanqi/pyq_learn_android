package org.hotpoor.pyq.atry;


import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewActivity extends Activity {
    private EditText et;
    private Button bt;
    private String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newactivity);
        bt= (Button) findViewById(R.id.button2);
        et= (EditText) findViewById(R.id.et_input);
        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent data = new Intent();
                str = et.getText().toString();
                data.putExtra("data", str);
                setResult(2,data);
                finish();
            }
        });
    }
}