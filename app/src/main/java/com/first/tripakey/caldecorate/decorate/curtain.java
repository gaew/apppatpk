package com.first.tripakey.caldecorate.decorate;
//หลักการตั้งตัวเปรใน java = ชนิดตัวแปร(ย่อ)_ชื่อตัวแปลนั้น
//หลักการตั้งตัวเปรใน xml  = ชื่อตัวแปลนั้น_ชนิดตัวแปร(ย่อ

//หน้าเลือกชนิดผ้าม้าน
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.first.tripakey.caldecorate.Global;
import com.first.tripakey.caldecorate.main.MainActivity;
import com.first.tripakey.caldecorate.R;
import com.first.tripakey.caldecorate.decorate.curtains.RomanBlind;
import com.first.tripakey.caldecorate.decorate.curtains.EyeletCurtains;
import com.first.tripakey.caldecorate.decorate.curtains.PleatedCurtains;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class curtain extends ActionBarActivity {
    String[] array_item = { "ผ้าม่านจีบ", "ผ้าม่านตาไก่", "ผ้าม่านพับ"};
    private ListView lsView_curtainType;
    private ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.curtain);
        setContentView(R.layout.activity_curtain);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        lsView_curtainType  =  (ListView) findViewById(R.id.lv_curtain);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, array_item);
        lsView_curtainType.setAdapter(arrayAdapter);
        //เมื่อกดเลือก item ในลิสวิวให้ไป activity นั้นและส่งค่าชื่อหัวข้อไปในตัวแปรโกลบอล
        lsView_curtainType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position+1){
                    case 1:
                        startActivity(new Intent(curtain.this, PleatedCurtains.class));
                        Global.name_curtain = "ม่านจีบ";
                        break;
                    case 2:
                        startActivity(new Intent(curtain.this, EyeletCurtains.class));
                        Global.name_curtain = "ม่านตาไก่";
                        break;
                    case 3:
                        startActivity(new Intent(curtain.this, RomanBlind.class));
                        Global.name_curtain = "ม่านผับ";
                        break;


                }

            }
        });
    }
    //กลับไป activity ก่อนหน้านี้
    public void onBackPressed() {
        startActivity(new Intent(curtain.this, MainActivity.class));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_curtain, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {

            case R.id.man:
                final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("Ezekiel 25:17");

                alertDialog.setMessage("\"The path of the righteous man is beset on all sides by the iniquities of the selfish and the tyranny of evil men.\n" +
                        "Blessed is he who, in the name of charity and good will, shepherds the weak through the valley of darkness, for he is truly his brother's keeper and the finder of lost children.\n" +
                        "And I will strike down upon thee with great vengeance and furious anger those who attempt to poison and destroy my brothers. And you will know my name is the Lord when I lay my vengeance upon thee.\"");
                alertDialog.show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}