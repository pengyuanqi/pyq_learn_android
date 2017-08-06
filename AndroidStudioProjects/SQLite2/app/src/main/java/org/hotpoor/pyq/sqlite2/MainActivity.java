package org.hotpoor.pyq.sqlite2;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SQLiteDatabase db = openOrCreateDatabase("stu.db", MODE_PRIVATE, null);
		db.execSQL("create table if not exists stutb(_id integer primary key autoincrement,name text not null,sex text not null,age integer not null)");
		ContentValues values = new ContentValues();
		values.put("name", "张三");
		values.put("sex", "男");
		values.put("age", 19);
		long rowId = db.insert("stutb", null, values);
		values.clear();
		values.put("name", "李四");
		values.put("sex", "男");
		values.put("age", 99);
		db.insert("stutb", null, values);
		values.clear();
		values.put("name", "王五");
		values.put("sex", "男");
		values.put("age", 59);
		db.insert("stutb", null, values);
		values.clear();
		values.put("name", "王武");
		values.put("sex", "男");
		values.put("age", 39);
		db.insert("stutb", null, values);
		values.clear();
		values.put("name", "王舞");
		values.put("sex", "男");
		values.put("age", 29);
		db.insert("stutb", null, values);
		values.clear();
		values.put("sex", "女");
		db.update("stutb", values, "_id>?", new String[]{"3"});//将全部id>3的人的性别改成女
		db.delete("stutb", "name like ?", new String[]{"%四%"});//删除所有名字中带有“四”的人
		Cursor c = db.query("stutb", null, "_id>?", new String[]{"0"}, null, null, "name");
		if (c!=null) {
			String [] columns= c.getColumnNames();
			while (c.moveToNext()) {
				for (String columnName : columns) {
					Log.i("info", c.getString(c.getColumnIndex(columnName)));
				}
			}
			c.close();
		}
		db.close();
	}

}
