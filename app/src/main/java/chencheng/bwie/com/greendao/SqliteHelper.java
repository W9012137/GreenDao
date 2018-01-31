package chencheng.bwie.com.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/01/26
 * Description:
 */
public class SqliteHelper extends SQLiteOpenHelper {

    private final  String DB_NAME="kson-db";
    public SqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
