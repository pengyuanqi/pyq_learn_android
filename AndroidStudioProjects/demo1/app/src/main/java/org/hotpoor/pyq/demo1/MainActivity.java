package org.hotpoor.pyq.demo1;

        import android.app.Activity;
        import android.os.Bundle;
        import android.widget.CompoundButton;
        import android.widget.CompoundButton.OnCheckedChangeListener;
        import android.widget.ImageView;
        import android.widget.ToggleButton;

public class MainActivity extends Activity implements OnCheckedChangeListener {
    private ToggleButton tb;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tb= (ToggleButton) findViewById(R.id.toggleButton1);
        img=(ImageView)findViewById(R.id.imageView1);

        tb.setOnCheckedChangeListener(this);
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView,boolean isCheaked){

        img.setBackgroundResource(isCheaked?R.drawable.open:R.drawable.close);

    }

}
