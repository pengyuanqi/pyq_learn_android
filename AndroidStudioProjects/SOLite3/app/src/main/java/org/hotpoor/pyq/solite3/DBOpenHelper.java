package org.hotpoor.pyq.solite3;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper{
	
	public DBOpenHelper(Context context, String name) {
		super(context, name, null, 1);
	}
	public DBOpenHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	@Override//首次创建数据库的时候调用，一般可以把建库.建表的操作执行
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table if not exists stutb(_id integer primary key autoincrement,name text not null,sex text not null,age integer not null)");
		db.execSQL("insert into stutb(name,sex,age)values('张三','女',18)");
	}

	@Override//当数据库的版本发生变化的时候会自动执行
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
