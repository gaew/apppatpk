package com.first.tripakey.caldecorate;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by gaew on 5/18/2015.
 */
public class DatabaseOperation extends SQLiteOpenHelper {
    public static final int database_version = 1;
    public String CREATE_QUERY = "CREATE_TABLE"+ tableDB.TableInfo.TABLE_NAME +"("+ tableDB.TableInfo.USER_COMPANY +"TEXT ;";

    public DatabaseOperation(Context context) {
        super(context, tableDB.TableInfo.DATABASE_NAME, null, database_version);
        Log.d("Database Operation","Database created");
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {
        sdb.execSQL(CREATE_QUERY);
        Log.d("Database Operation","Table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void putInformation(){
        
    }
}
