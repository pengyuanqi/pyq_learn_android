package org.hotpoor.pyq.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.app.Activity;

public class MainActivity extends AppCompatActivity {
    private AutoCompleteTextView acTextView;
    private String[] res = {"beijing1","beijing2","beijing3",
                             "shanghai1","shanghai2","shanghai3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        acTextView=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,res);
        acTextView.setAdapter(adapter);
    }
}
