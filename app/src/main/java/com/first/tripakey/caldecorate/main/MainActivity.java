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


import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class MainActivity extends AppCompatActivity {
////testgit
    //test merge with test


    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"ตกแต่งภายใน","ค่าใช้จ่าย","แปลงหน่วย","ค้นหาร้าน"};
    int Numboftabs =4;
    boolean check_firsttime = false ;
    public static final String PREFS_NAME = "MyPrefsFile";

    SQLiteDatabase mDb;
    private Tracker mTracker;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.titleMain);

        // Obtain the shared Tracker instance.
        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();

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
                    + "," + CODE + "," + WIDTH + "," + PRICE + "," + IMAGE +") VALUES ('ม่านหาดไท', 'ม่านจีบ', 'A001','64','445','https://www.the-millshop-online.co.uk/media/catalog/product/cache/1/thumbnail/9df78eab33525d08d6e5fb8d27136e95/p/r/prestigious-textiles-briarfield-fabric-eau-du-nil-1.jpg');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COMPANY + ", " + TYPE
                    + "," + CODE + ","+WIDTH+","+ PRICE + "," + IMAGE + ") VALUES ('ม่านหาดไท', 'ม่านจีบ', 'A002','65','456','https://www.the-millshop-online.co.uk/media/catalog/product/cache/1/thumbnail/9df78eab33525d08d6e5fb8d27136e95/c/l/clarke-clarke-fabric-deer-f0862-1.jpg');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COMPANY + ", " + TYPE
                    + "," + CODE + ","+WIDTH+","+ PRICE + "," + IMAGE + ") VALUES ('ม่านหาดไท', 'ม่านจีบ', 'A003','44','764','https://www.the-millshop-online.co.uk/media/catalog/product/cache/1/thumbnail/9df78eab33525d08d6e5fb8d27136e95/p/r/prestigious-fabric-poppypod-eucalyptus-1.jpg');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COMPANY + ", " + TYPE
                    + "," + CODE + ","+WIDTH+","+ PRICE +") VALUES ('ม่านหาดไท', 'ม่านตาไก่', 'A004','36','568');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COMPANY + ", " + TYPE
                    + "," + CODE + ","+WIDTH+","+ PRICE +") VALUES ('ม่านหาดไท', 'ม่านตาไก่', 'A095','85','459');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COMPANY + ", " + TYPE
                    + "," + CODE + ","+WIDTH+","+ PRICE +") VALUES ('ม่านหาดไท', 'ม่านตาไก่', 'A026','35','856');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COMPANY + ", " + TYPE
                    + "," + CODE + ","+WIDTH+","+ PRICE +") VALUES ('ม่านหาดไท', 'ม่านตาไก่', 'A047','97','678');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COMPANY + ", " + TYPE
                    + "," + CODE + ","+WIDTH+","+ PRICE +") VALUES ('ม่านหรรษา', 'ม่านตาไก่', 'A098','45','876');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COMPANY + ", " + TYPE
                    + "," + CODE + ","+WIDTH+","+ PRICE +") VALUES ('ม่านหรรษา', 'ม่านตาไก่', 'A079','65','678');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COMPANY + ", " + TYPE
                    + "," + CODE + ","+WIDTH+","+ PRICE +") VALUES ('ม่านหรรษา', 'ม่านจีบ', 'A010','57','986');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COMPANY + ", " + TYPE
                    + "," + CODE + ","+WIDTH+","+ PRICE +") VALUES ('ม่านหรรษา', 'ม่านจีบ', 'A012','34','765');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COMPANY + ", " + TYPE
                    + "," + CODE + ","+WIDTH+","+ PRICE +") VALUES ('ม่านหรรษา', 'ม่านจีบ', 'A015','98','456');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COMPANY + ", " + TYPE
                    + "," + CODE + ","+WIDTH+","+ PRICE +") VALUES ('ม่านหรรษา', 'ม่านจีบ', 'A075','35','764');");
            db.execSQL("INSERT INTO " + TABLE_NAME + " (" + COMPANY + ", " + TYPE
                    + "," + CODE + ","+WIDTH+","+ PRICE +") VALUES ('ม่านหรรษา', 'ม่านจีบ', 'A014','54','345');");

        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }


}