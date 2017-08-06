package org.hotpoor.pyq.buju;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private ViewStub stub;
    private View view=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        button= (Button) findViewById(R.id.button);
        stub= (ViewStub) findViewById(R.id.stub);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view == null) {
                    view = stub.inflate();
                    button.setText("隐藏");
                } else {
                    if ("显示".equals(button.getText())) {
                        view.setVisibility(View.VISIBLE);
                        button.setText("隐藏");
                    } else if ("隐藏".equals(button.getText())) {
                        view.setVisibility(View.INVISIBLE);
                        button.setText("显示");
                    }
                }
            }
        });
    }
}
