package com.first.tripakey.caldecorate.decorate.curtains;
//หลักการตั้งตัวเปรใน java = ชนิดตัวแปร(ย่อ)_ชื่อตัวแปลนั้น
//หลักการตั้งตัวเปรใน xml  = ชื่อตัวแปลนั้น_ชนิดตัวแปร(ย่อ

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.first.tripakey.caldecorate.R;
import com.first.tripakey.caldecorate.decorate.curtain;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class RomanBlind extends ActionBarActivity {
/////เริ่ม1 copy แอดส่วนลดตาม

    LinearLayout container,container2,discountF;
    static EditText            testhand,  field1,field2,field3,field4;
    public  Integer onstart;
    static Double   hand1,hand2,hand3,hand4,hand5,g;
    static TextView numM;

    ///////จบ1 copy แอดส่วนลดตาม
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /////เริ่ม2 copy แอดส่วนลดตาม
        onstart=0;
        hand1 = 0.0;
        hand2 = 0.0;
        hand3 = 0.0;
        hand4 = 0.0;
        hand5 = 0.0;
        g=0.0;

///////จบ2 copy แอดส่วนลดตาม
        super.onCreate(savedInstanceState);
        setTitle(R.string.romam);

        setContentView(R.layout.activity_roman_blind);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        SharedPreferences spp = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
      //  String stg_sharD = spp.getString("My_ValueD", "2.5");
        String stg_sharE = spp.getString("My_ValueEpup", "10.0");
        String stg_sharF = spp.getString("My_ValueFpup", "10.0");
        String stg_sharG = spp.getString("My_ValueGpup", "15.0");
        String stg_sharH = spp.getString("My_ValueHpup", "30.0");
        String stg_sharI = spp.getString("My_ValueIpup", "10.0");
        String stg_sharJ = spp.getString("My_ValueJpup", "50.0");
        //เปลียนเปน double
      //  double_d = Double.parseDouble(stg_sharD);
        final Double e = Double.parseDouble(stg_sharE);
        final Double f = Double.parseDouble(stg_sharF);
          g = Double.parseDouble(stg_sharG);
        final  Double h = Double.parseDouble(stg_sharH);
        final  Double i  = Double.parseDouble(stg_sharI);
        final Double j = Double.parseDouble(stg_sharJ);

        addcomp();

        final EditText  w_edt = (EditText) findViewById(R.id.w);
        final EditText h_edt = (EditText) findViewById(R.id.h);
        final EditText wfab_edt = (EditText) findViewById(R.id.wfab);
        final EditText priceIn_edt = (EditText) findViewById(R.id.priceIn);


        final EditText numL_edt =(EditText)findViewById(R.id.numL);

        final TextView totalpeice_tv = (TextView) findViewById(R.id.totalPiece);
        final TextView ydOut_tv = (TextView) findViewById(R.id.ydOut);
        final TextView metreOut_tv = (TextView) findViewById(R.id.metreOut);
        final TextView priceUse_tv = (TextView) findViewById(R.id.priceUse);
        final TextView discount_tv = (TextView) findViewById(R.id.discount);
        final TextView totalBht_tv = (TextView) findViewById(R.id.totalBht);
        numM=(TextView)findViewById(R.id.numM);


        Button cal_bt = (Button) findViewById(R.id.cal);


        final CheckBox vat = (CheckBox) findViewById(R.id.vat);

        g = g*2.0;
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



        ///////จบ3 copy แอดส่วนลดต
        cal_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((!w_edt.getText().toString().trim().isEmpty()) &&
                        (!h_edt.getText().toString().trim().isEmpty()) &&
                        (!priceIn_edt.getText().toString().trim().isEmpty()) &&
                        (!wfab_edt.getText().toString().trim().isEmpty())) {

                    Boolean cvat = vat.isChecked();
                    Double H = Double.parseDouble(h_edt.getText().toString());
                    Double W = Double.parseDouble(w_edt.getText().toString());
                    Double price = Double.parseDouble(priceIn_edt.getText().toString());
                    Double wfab = Double.parseDouble(wfab_edt.getText().toString());
                    Double priceUse = price;


                    ///เริ่ม4 copy แอดส่วนลดตาม

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
                    priceUse = price*(100-hand1)/100;
                    priceUse = priceUse*(100-hand2)/100;
                    priceUse = priceUse*(100-hand3)/100;
                    priceUse = priceUse*(100-hand4)/100;
                    priceUse = priceUse*(100-hand5)/100;

                    ///////จบ4 copy แอดส่วนลดตาม



                      Double lot;
                    if(!numL_edt.getText().toString().trim().isEmpty()) {
                          lot = Double.parseDouble(numL_edt.getText().toString());
                    }else lot=1.0;

                    Double numPiece =lot* (W/100 + g/100) /( wfab/100);
                    Double metre = lot*(H/100 + e/100 + f/100 + h/100) * numPiece * (i / 100 + 1);
                    Double yd = lot*metre * 1.09361;
                    Double totalBth = lot*yd * priceUse;


                    Double numPieceInter = (Double) Math.floor(numPiece + 0.5d);
                    Double intercal = numPieceInter - numPiece;
                    if (intercal < 0) {
                        numPieceInter = numPieceInter + 0.5;
                    }


                    if (cvat == true) {
                        //คำนวน แยกภาษี
                        totalBth = totalBth + totalBth * 0.07;
                        priceUse=priceUse+priceUse*0.07;

                    }

                    DecimalFormat d4 = new DecimalFormat("0.0000");
                    DecimalFormat d2 = new DecimalFormat("0.00");
                    DecimalFormat d1 = new DecimalFormat("0.0");

                    totalpeice_tv.setText(d2.format(numPieceInter));
                    numM.setText(d2.format(numPiece));
                    metreOut_tv.setText(d4.format(metre));
                    ydOut_tv.setText(d4.format(yd));
                    priceUse_tv.setText(d2.format(priceUse));
                    discount_tv.setText(d2.format(price-priceUse));
                    totalBht_tv.setText(d2.format(totalBth));

                } else
                    Toast.makeText(getApplicationContext(), "ต้องใส่ข้อมูลในช่องที่มีเครื่องหมายดอกจัน *", Toast.LENGTH_SHORT).show();


            }
        });

    }



    public void addcomp() {
        Spinner pcom = (Spinner) findViewById(R.id.spinComp);
        List<String> list = new ArrayList<String>();
        list.add("ผ้าม่านเมืองทอง");
        list.add("ผ้าม่านเมืองเงิน");
        list.add("ผ้าม่านเมืองทองแดง");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pcom.setAdapter(dataAdapter);
    }




    @Override
    public void onBackPressed() {
        startActivity(new Intent(RomanBlind.this, curtain.class));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cal_curtain2pup, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(RomanBlind.this, settingRomanBlind.class));
                return true;
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

