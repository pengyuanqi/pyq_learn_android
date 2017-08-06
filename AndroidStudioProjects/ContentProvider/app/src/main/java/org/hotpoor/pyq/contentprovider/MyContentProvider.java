package org.hotpoor.pyq.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class MyContentProvider extends ContentProvider{
    @Override//在ContentProvider创建后被调用
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override//根据Uri查询出selection指定的条件所匹配的全部记录，并且可以指定查询哪些列 以什么方式（order）排序
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override//返回当前Uri的MIME类型，如果Uri对应的数据可能包括多条记录，那么该MIME类型字符串就是以vnd.android。dir/开头
    //如果该Uri对应的数据只有一条记录 该MIME类型字符串，就是以vnd.android.cursor.item/开头
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override//根据Uri插入Values对应的数据
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override//根据Uri删除selection指定的条件所匹配的全部记录
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override//根据Uri修改selection指定的条件所匹配的全部记录
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
