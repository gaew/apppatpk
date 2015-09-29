package com.first.tripakey.caldecorate.main;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.first.tripakey.caldecorate.R;

public class MainActivity extends AppCompatActivity {
////testgit
    //test merge with test


    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"ตกแต่งภายใน","คำนวนค่าใช้จ่าย","แปลงหน่วย"};
    int Numboftabs =3;
    boolean check_firsttime = false ;
    public static final String PREFS_NAME = "MyPrefsFile";

    SQLiteDatabase mDb;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.titleMain);

       /* AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
*/
        // startActivity(new Intent(MainActivity.this, firstTime.class));
        MainActivity.MyDbHelper db = new MainActivity.MyDbHelper(this);
        mDb = db.getWritableDatabase();
        Cursor mCursor = mDb.rawQuery("SELECT "+ MainActivity.MyDbHelper.CODE + " FROM "+  MainActivity.MyDbHelper.TABLE_NAME, null);

        Log.i("Data Count", String.valueOf(mCursor.getCount()));

        //test dialog

        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter =  new ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);

        // Assigning ViewPager View and settingPleatedCurtain the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);





    }

    protected void onStop(){
        super.onStop();

        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        SharedPreferences save_first_time = getPreferences(0);
        SharedPreferences.Editor editor = save_first_time.edit();
        editor.putBoolean("first_time", true);

        // Commit the edits!
        editor.commit();
    }


    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


  public static   class MyDbHelper extends SQLiteOpenHelper {
        private static final String DB_NAME = "caldecorate";
        private static final int DB_VERSION = 1;
        public static final String TABLE_NAME = "fab";
        public static final String COMPANY = "company";
        public static final String TYPE = "type";
        public static final String CODE = "code";
      public static final String WIDTH = "width";
      public static final String PRICE = "price";
      public static final String IMAGE = "image";

        public MyDbHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + TABLE_NAME + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COMPANY + " TEXT, " + TYPE + " TEXT, "
                    + CODE + " TEXT, " + WIDTH + " TEXT, " + PRICE + " TEXT, " + IMAGE + " TEXT); ");
            db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COMPANY + ", " + TYPE
                    + "," + CODE + "," + WIDTH + "," + PRICE + "," + IMAGE +") VALUES ('ม่านหาดไท', 'ม่านจีบ', '3LOT2-01','32','64','http://www.tripake.com/image/3LOT2-01.PNG');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COMPANY + ", " + TYPE
                    + "," + CODE + ","+WIDTH+","+ PRICE + "," + IMAGE + ") VALUES ('ม่านหาดไท', 'ม่านจีบ', '3LOT2-02','32','64','http://www.tripake.com/image/3LOT2-02.PNG');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COMPANY + ", " + TYPE
                    + "," + CODE + ","+WIDTH+","+ PRICE + "," + IMAGE + ") VALUES ('ม่านหาดไท', 'ม่านจีบ', '3LOT2-03','32','64','http://www.tripake.com/image/3LOT2-03.PNG');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COMPANY + ", " + TYPE
                    + "," + CODE + ","+WIDTH+","+ PRICE + "," + IMAGE + ") VALUES ('ม่านหาดไท', 'ม่านจีบ', '3LOT2-04','35','64','http://www.tripake.com/image/3LOT2-04.PNG');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COMPANY + ", " + TYPE
                    + "," + CODE + ","+WIDTH+","+ PRICE + "," + IMAGE + ") VALUES ('ม่านหาดไท', 'ม่านจีบ', '3LOT2-05','35','64','http://www.tripake.com/image/3LOT2-05.PNG');");

        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }


}