package com.first.tripakey.caldecorate;

import android.provider.BaseColumns;

/**
 * Created by gaew on 5/18/2015.
 */
public class tableDB {
    public tableDB(){

    }
    public static abstract class TableInfo implements BaseColumns
    {
        public static final String USER_COMPANY = "user_company";
        public static final String DATABASE_NAME = "company_info";
        public static final String TABLE_NAME = "reg_info";

    }
}
