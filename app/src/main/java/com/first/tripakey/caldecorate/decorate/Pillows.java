package com.first.tripakey.caldecorate.decorate;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.first.tripakey.caldecorate.main.AnalyticsApplication;
import com.first.tripakey.caldecorate.main.MainActivity;
import com.first.tripakey.caldecorate.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Pillows extends ActionBarActivity {
/////เริ่ม1 copy แอดส่วนลดตาม

    LinearLayout container,container2,discountF;
    static EditText            testhand,  field1,field2,field3,field4;
    public  Integer onstart;
    static Double   hand1,hand2,hand3,hand4,hand5;

    ///////จบ1 copy แอดส่วนลดตา
    public Spinner spin_cost1;//แสดงชื้อบริษัทจำหน่ายผ้าม้าน

   static public Double priceUse_d,areaAddU,fabtotal , statusN;
    static String num;


    private Tracker mTracker;
    String name = "pillows";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.bambooblind);
        setContentView(R.layout.activity_pillows );
/*
//////beging analysis
        AnalyticsApplication application = (AnalyticsApplication) getApplication();
        mTracker = application.getDefaultTracker();

        mTracker.setScreenName("Image~" + name);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());

        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory("Action")
                .setAction("Share")
                .build());
////////////////end analysis

*/
        cost1addCompunny();
/////เริ่ม2 copy แอดส่วนลดตาม
        onstart=0;
        hand1 = 0.0;
        hand2 = 0.0;
        hand3 = 0.0;
        hand4 = 0.0;
        hand5 = 0.0;
        areaAddU=0.0;
        fabtotal=0.0;
///////จบ2 copy แอดส่วนลดตาม
        final EditText fabWild = (EditText) findViewById(R.id.fab_wild);
        final EditText price = (EditText) findViewById(R.id.priceInt_edittxt);
        final EditText Wild = (EditText) findViewById(R.id.wild);
        final EditText Long = (EditText) findViewById(R.id.long_fab);
        final EditText Num = (EditText) findViewById(R.id.num_pillow);

        final TextView ydShow = (TextView) findViewById(R.id.yd_show);
        final TextView pillowRow = (TextView) findViewById(R.id.pillow_row);
        final TextView priceUse = (TextView) findViewById(R.id.lastHandi_textview);

        final TextView handLesss = (TextView) findViewById(R.id.handLess);
        final TextView totalPrice = (TextView) findViewById(R.id.totalPrice_textview);

        Button cal = (Button) findViewById(R.id.cal);


        final CheckBox vat = (CheckBox) findViewById(R.id.check_vat);
        final CheckBox motor_chk = (CheckBox) findViewById(R.id.motor);
        //////เริ่ม3 copy แอดส่วนลดตาม
        container = (LinearLayout)findViewById(R.id.container);
        container2= (LinearLayout)findViewById(R.id.container2);
        discountF = (LinearLayout)findViewById(R.id.discountReq);
        testhand = (EditText)findViewById(R.id.handi1_edittxt);

        testhand.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {

                if (testhand.length() == 1) {
                    if (onstart == 0) {
                        onstart = 1;
                        LayoutInflater layoutInflater2 = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        final View addView = layoutInflater2.inflate(R.layout.discountfield, null);
                        field1 = (EditText) addView.findViewById(R.id.addDiscount);


                        discountF.addView(addView);
                        field1.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                            }

                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {

                            }

                            @Override
                            public void afterTextChanged(Editable s) {
                                if(field1.length()==1) {
                                    if (onstart == 1) {
                                        onstart = 2;
                                        LayoutInflater layoutInflater2 = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                        final View addView = layoutInflater2.inflate(R.layout.discountfield, null);
                                        field2 = (EditText) addView.findViewById(R.id.addDiscount);
                                        discountF.addView(addView);
                                        field2.addTextChangedListener(new TextWatcher() {
                                            @Override
                                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                            }

                                            @Override
                                            public void onTextChanged(CharSequence s, int start, int before, int count) {

                                            }

                                            @Override
                                            public void afterTextChanged(Editable s) {
                                                if (field2.length() == 1) {
                                                    if (onstart == 2) {
                                                        onstart = 3;
                                                        LayoutInflater layoutInflater2 = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                                        final View addView = layoutInflater2.inflate(R.layout.discountfield, null);
                                                        field3 = (EditText) addView.findViewById(R.id.addDiscount);
                                                        discountF.addView(addView);
                                                        field3.addTextChangedListener(new TextWatcher() {
                                                            @Override
                                                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                                            }

                                                            @Override
                                                            public void onTextChanged(CharSequence s, int start, int before, int count) {

                                                            }

                                                            @Override
                                                            public void afterTextChanged(Editable s) {
                                                                if (field3.length() == 1) {
                                                                    if (onstart == 3) {
                                                                        onstart = 4;
                                                                        LayoutInflater layoutInflater2 = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                                                        final View addView = layoutInflater2.inflate(R.layout.discountfield, null);
                                                                        field4 = (EditText) addView.findViewById(R.id.addDiscount);

                                                                        discountF.addView(addView);
                                                                    }
                                                                }

                                                            }
                                                        });
                                                    }
                                                }

                                            }
                                        });

                                    }
                                }
                            }
                        });
                    }

                }

            }
        });

        cal.setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick(View v) {
                if          ((!price.getText().toString().trim().isEmpty())&&
                        (!fabWild.getText().toString().trim().isEmpty())&&
                        (!Wild.getText().toString().trim().isEmpty())&&
                        (!Long.getText().toString().trim().isEmpty())
                        ){


                    Boolean cvat = vat.isChecked();

                    Double price_d = Double.parseDouble(price.getText().toString());
                    Double WF = Double.parseDouble(fabWild.getText().toString());
                    Double W = Double.parseDouble(Wild.getText().toString());
                    Double L = Double.parseDouble(Long.getText().toString());
                    Double N = Double.parseDouble(Num.getText().toString());
                    W = W*2.54;
                    L = L*2.54;

                    // go step1
                    Double eL = ((L+2)*2)/91.6;
                    Double nWF = WF/(W+2);
                    nWF = Math.floor(nWF);
                    //end step1

                    //go proof
                    statusN = 0.0;
                    Double totalF = 0.0;
                    //////////all var ready
                     while (statusN<=N){
                            totalF += eL;
                            statusN += nWF;
                     }
                    statusN -= nWF;
                    totalF -= eL;
                    if ((N-statusN)!= 0.0) {
                        if  ((N-statusN)*(W+2)<eL*91.6) {
                            totalF += (N-statusN)*(W+2)/91.6;
                            statusN=N;
                        }else {
                            totalF += eL;
                            statusN += nWF;
                        }
                    }
                    ///เริ่ม4 copy แอดส่วนลดตาม
                    priceUse_d=price_d;
                    switch (onstart){
                        case 0:
                            if (!testhand.getText().toString().trim().isEmpty()){
                                hand1=Double.parseDouble(testhand.getText().toString());
                            }
                            break;
                        case 1:
                            if (!testhand.getText().toString().trim().isEmpty()){
                                hand1=Double.parseDouble(testhand.getText().toString());
                            }
                            if (!field1.getText().toString().trim().isEmpty()){
                                hand2=Double.parseDouble(field1.getText().toString());
                            }
                            break;
                        case 2:
                            if (!testhand.getText().toString().trim().isEmpty()){
                                hand1=Double.parseDouble(testhand.getText().toString());
                            }
                            if (!field1.getText().toString().trim().isEmpty()){
                                hand2=Double.parseDouble(field1.getText().toString());
                            }
                            if (!field2.getText().toString().trim().isEmpty()){
                                hand3=Double.parseDouble(field2.getText().toString());
                            }
                            break;
                        case 3:
                            if (!testhand.getText().toString().trim().isEmpty()){
                                hand1=Double.parseDouble(testhand.getText().toString());
                            }
                            if (!field1.getText().toString().trim().isEmpty()){
                                hand2=Double.parseDouble(field1.getText().toString());
                            }
                            if (!field2.getText().toString().trim().isEmpty()){
                                hand3=Double.parseDouble(field2.getText().toString());
                            }
                            if (!field3.getText().toString().trim().isEmpty()){
                                hand4=Double.parseDouble(field3.getText().toString());
                            }
                            break;
                        case 4:
                            if (!testhand.getText().toString().trim().isEmpty()){
                                hand1=Double.parseDouble(testhand.getText().toString());
                            }
                            if (!field1.getText().toString().trim().isEmpty()){
                                hand2=Double.parseDouble(field1.getText().toString());
                            }
                            if (!field2.getText().toString().trim().isEmpty()){
                                hand3=Double.parseDouble(field2.getText().toString());
                            }
                            if (!field3.getText().toString().trim().isEmpty()){
                                hand4=Double.parseDouble(field3.getText().toString());
                            }
                            if (!field4.getText().toString().trim().isEmpty()){
                                hand5=Double.parseDouble(field4.getText().toString());
                            }
                            break;
                    }
                    priceUse_d = price_d*(100-hand1)/100;
                    priceUse_d = priceUse_d*(100-hand2)/100;
                    priceUse_d = priceUse_d*(100-hand3)/100;
                    priceUse_d = priceUse_d*(100-hand4)/100;
                    priceUse_d = priceUse_d*(100-hand5)/100;

                    ///////จบ4 copy แอดส่วนลดตาม

                    if(cvat==true){
                        priceUse_d = priceUse_d+priceUse_d*0.07;

                    }
                    ///price_Use_d
                    Double discount_d=price_d-priceUse_d;
                    Double totalBht_d=priceUse_d*totalF;

                    DecimalFormat d4 = new DecimalFormat("0.0000");
                    DecimalFormat d2 = new DecimalFormat("0.00");



                    ydShow.setText(d4.format(totalF));
                    pillowRow.setText(d2.format(statusN));

                    priceUse.setText(d2.format(priceUse_d));
                    handLesss.setText(d2.format(discount_d));
                    totalPrice.setText(d2.format(totalBht_d));

                }else Toast.makeText(getApplicationContext(),"ต้องใส่ข้อมูลในช่องที่มีเครื่องหมายดอกจัน *",Toast.LENGTH_SHORT).show();



            }
        });

    }



    public void cost1addCompunny() {
        spin_cost1 = (Spinner) findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("ผ้าม่านเมืองทอง");
        list.add("ผ้าม่านเมืองเงิน");
        list.add("ผ้าม่านเมืองทองแดง");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_cost1.setAdapter(dataAdapter);
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(Pillows.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();
       // startActivity(new Intent(Pillows.this, MainActivity.class));


    }






}

