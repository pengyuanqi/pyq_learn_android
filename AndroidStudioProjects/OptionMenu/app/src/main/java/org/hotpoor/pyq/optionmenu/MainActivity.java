package org.hotpoor.pyq.optionmenu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.hotpoor.pyq.optionmenu.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.main, menu);
		MenuItem item = menu.add(1, 100, 1, "菜单一");
		item.setTitle("aaa");
		item.setIcon(R.mipmap.ic_launcher);
		menu.add(1, 101, 1, "菜单二");
		menu.add(1, 102, 1, "菜单三");
		menu.add(1, 103, 1, "菜单四");
		menu.add(1, 104, 1, "菜单五");
		menu.add(1, 105, 1, "菜单六");
		menu.add(1, 106, 1, "菜单七");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 100:
			Intent intent = new Intent(MainActivity.this,SecondActivity.class);
			item.setIntent(intent);
			break;

		case 101:
			Toast.makeText(MainActivity.this, "点击了菜单二", Toast.LENGTH_SHORT)
					.show();
			break;
		case 102:
			Toast.makeText(MainActivity.this, "点击了菜单三", Toast.LENGTH_SHORT)
					.show();
			break;
		case 103:
			Toast.makeText(MainActivity.this, "点击了菜单四", Toast.LENGTH_SHORT)
					.show();
			break;
		case 104:
			Toast.makeText(MainActivity.this, "点击了菜单五", Toast.LENGTH_SHORT)
					.show();
			break;
		case 105:
			Toast.makeText(MainActivity.this, "点击了菜单六", Toast.LENGTH_SHORT)
					.show();
			break;
		case 106:
			Toast.makeText(MainActivity.this, "点击了菜单七", Toast.LENGTH_SHORT)
					.show();
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
