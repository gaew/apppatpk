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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.first.tripakey.caldecorate.R;
import com.first.tripakey.caldecorate.decorate.curtains.Eyelet.Eyelet;
import com.first.tripakey.caldecorate.decorate.curtains.Pleated.Pleated;
import com.first.tripakey.caldecorate.decorate.curtains.Roman.Roman;
import com.first.tripakey.caldecorate.main.MainActivity;

public class curtain extends ActionBarActivity {
    String[] array_item = { "ผ้าม่านจีบ", "ผ้าม่านตาไก่", "ผ้าม่านพับ"};
    private ListView lsView_curtainType;
    private ArrayAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.curtain);
        setContentView(R.layout.activity_curtains);

        Button pleated = (Button)findViewById(R.id.bt_pleated);
        Button eyelet = (Button)findViewById(R.id.bt_eyelet);
        Button roman = (Button)findViewById(R.id.bt_roman);

        pleated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(curtain.this, Pleated.class));
            }
        });

        eyelet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(curtain.this, Eyelet.class));
            }
        });

        roman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(curtain.this, Roman.class));
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