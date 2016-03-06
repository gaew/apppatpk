package com.first.tripakey.caldecorate.decorate;
//หลักการตั้งตัวเปรใน java = ชนิดตัวแปร(ย่อ)_ชื่อตัวแปลนั้น
//หลักการตั้งตัวเปรใน xml  = ชื่อตัวแปลนั้น_ชนิดตัวแปร(ย่อ

//หน้าคำนวนม้านจีบ
import android.animation.LayoutTransition;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.first.tripakey.caldecorate.decorate.curtains.Roman.Roman;
import com.first.tripakey.caldecorate.main.AnalyticsApplication;
import com.first.tripakey.caldecorate.main.MainActivity;
import com.first.tripakey.caldecorate.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class WallPaper extends ActionBarActivity {
    LinearLayout container,container2,discountF;
    public Spinner spin_manmon;

    public boolean  checkbox_vat;
    public  Integer onstart;
    static double           usetotal,
                             priceHandDoub,
                            addtotalW,
                             addtotalL,addtotalUnit,
                            totalBht,
                           totalSquare,
                              areaAddU,
                               hand1,hand2,hand3,hand4,hand5,
                              areaAddE;
    static EditText        testhand,field1,field2,field3,field4,priceEdt,edt_empUnit,
                           edt_wallW, edt_wallL,edt_useW, edt_useUnit,edt_useL, edt_emplyW,edt_emplyL;
    static String           totalSqStr;
    public String texttoshow,testStr;
    public TextView mSquareTv,numWallTv,
            sparWallTv, BhtTotalTv,
            handtoTV,
            discountTv,
            addU_total_tv,
            addE_total_tv;
    static Button   bt_cal;
    long spar,num;

    private Tracker mTracker;
    String name = "wall paper";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.wallpeper);
        setContentView(R.layout.activity_wall_paper);
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

        usetotal=0;
        areaAddU=0;
        areaAddE=0;
        onstart=0;
        hand1 = 0;
        hand2 = 0;
        hand3 = 0;
        hand4 = 0;
        hand5 = 0;

        edt_useW =(EditText) findViewById(R.id.useBlogWild_edt);
        edt_useL =(EditText) findViewById(R.id.useBlogLong_edt);

        edt_wallW =(EditText) findViewById(R.id.wallWild_edt);
        edt_wallL =(EditText) findViewById(R.id.wallLong_edt);

        edt_emplyW =(EditText) findViewById(R.id.emplyBlogWild_edt);
        edt_emplyL =(EditText) findViewById(R.id.emplyBlogLong_edt);
       ImageButton bt_adduse = (ImageButton) findViewById(R.id.addUse_edt);
       ImageButton bt_addemply = (ImageButton) findViewById(R.id.addEmply_edt);

        bt_adduse.setImageResource(R.drawable.add_ic);
        bt_addemply.setImageResource(R.drawable.add_ic);

        addU_total_tv  =(TextView) findViewById(R.id.addAreaTotal);
        addE_total_tv =(TextView) findViewById(R.id.addEmpTotal);
        numWallTv =(TextView) findViewById(R.id.NumWall);
        handtoTV =(TextView) findViewById(R.id.handprice);
        discountTv =(TextView) findViewById(R.id.discount);

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





        bt_adduse.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View arg0) {

                if ((!edt_useW.getText().toString().trim().isEmpty()) &&
                        (!edt_useL.getText().toString().trim().isEmpty())      ) {
                    LayoutInflater layoutInflater =
                            (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    final View addView = layoutInflater.inflate(R.layout.rowforwall, null);
                    final TextView textOut1 = (TextView) addView.findViewById(R.id.uw);
                    textOut1.setText(edt_useW.getText().toString());
                    final TextView textOut2 = (TextView) addView.findViewById(R.id.ul);
                    textOut2.setText(edt_useL.getText().toString());

                    texttoshow = textOut1.getText().toString();
                    String addWstr = textOut1.getText().toString();
                    String addLstr = textOut2.getText().toString();

                    addtotalW = Double.parseDouble(addWstr);
                    addtotalL = Double.parseDouble(addLstr);
                    areaAddU =( areaAddU + (addtotalW / 100) * (addtotalL / 100));
                    DecimalFormat d2 = new DecimalFormat("0.00");
                    testStr = d2.format(areaAddU);
                    addU_total_tv.setText(testStr);
                    edt_useW.setText(" ");
                    edt_useL.setText(" ");

                    ImageButton remove = (ImageButton) addView.findViewById(R.id.remove);
                    remove.setImageResource(R.drawable.delete_ic);
                    remove.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String addWstr = textOut1.getText().toString();
                            String addLstr = textOut2.getText().toString();

                            addtotalW = Double.parseDouble(addWstr);
                            addtotalL = Double.parseDouble(addLstr);

                            areaAddU =( areaAddU -(addtotalW / 100) * (addtotalL / 100));
                            DecimalFormat d2 = new DecimalFormat("0.00");
                            testStr = d2.format(areaAddU);
                            addU_total_tv.setText(testStr);
                            ((LinearLayout) addView.getParent()).removeView(addView);
                        }
                    });
                    container.addView(addView);

                }else Toast.makeText(getApplicationContext(), "กรุณากรอกข้อมูล", Toast.LENGTH_LONG).show();
            }});

        bt_addemply.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View arg0) {
                if ((!edt_emplyW.getText().toString().trim().isEmpty()) &&
                        (!edt_emplyL.getText().toString().trim().isEmpty()) ) {
                    LayoutInflater layoutInflater =
                            (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    final View addView = layoutInflater.inflate(R.layout.rowforwall, null);
                    final TextView textOut1 = (TextView) addView.findViewById(R.id.uw);
                    textOut1.setText(edt_emplyW.getText().toString());
                    final TextView textOut2 = (TextView) addView.findViewById(R.id.ul);
                    textOut2.setText(edt_emplyL.getText().toString());

                    // texttoshow = textOut1.getText().toString();
                    String empWstr = textOut1.getText().toString();
                    String empLstr = textOut2.getText().toString();

                    Double empTotalW = Double.parseDouble(empWstr);
                    Double empTotalL = Double.parseDouble(empLstr);


                    areaAddE = (areaAddE + (empTotalW / 100) * (empTotalL / 100));
                    DecimalFormat d2 = new DecimalFormat("0.00");
                    testStr = d2.format(areaAddE);
                    addE_total_tv.setText(testStr);
                    edt_emplyW.setText(" ");
                    edt_emplyL.setText(" ");

                    ImageButton remove = (ImageButton) addView.findViewById(R.id.remove);
                    remove.setImageResource(R.drawable.delete_ic);
                    remove.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String empWstr = textOut1.getText().toString();
                            String empLstr = textOut2.getText().toString();

                            Double empTotalW = Double.parseDouble(empWstr);
                            Double empTotalL = Double.parseDouble(empLstr);

                            areaAddE = (areaAddE - (empTotalW / 100) * (empTotalL / 100));
                            DecimalFormat d2 = new DecimalFormat("0.00");
                            testStr = d2.format(areaAddE);
                            addE_total_tv.setText(testStr);
                            ((LinearLayout) addView.getParent()).removeView(addView);
                        }
                    });
                    container2.addView(addView);
                }else Toast.makeText(getApplicationContext(), "กรุณากรอกข้อมูล", Toast.LENGTH_LONG).show();
            }});

        LayoutTransition transition = new LayoutTransition();
        container.setLayoutTransition(transition);
        addcom();
        priceEdt = (EditText) findViewById(R.id.wallPrice_edt);

        mSquareTv = (TextView) findViewById(R.id.Msquare);

        BhtTotalTv = (TextView) findViewById(R.id.BthTotal);


        sparWallTv=(TextView) findViewById(R.id.sparWall);
        bt_cal = (Button) findViewById(R.id.button_cal);
        final CheckBox c_vat = (CheckBox) findViewById(R.id.check_vat);
        //ชื่อหัวข้อเอามาจาตัวแปรที่เก็บใว้ก่อนเข้าหน้านี้แล้ว
        DecimalFormat d2 = new DecimalFormat("0.00");
      //  test = d2.format(usetotal);
        //เมื่อกดคำนวน
        bt_cal.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          if ((!priceEdt.getText().toString().trim().isEmpty()) &&
                                                  (!edt_wallL.getText().toString().trim().isEmpty()) &&
                                             (!edt_wallW.getText().toString().trim().isEmpty()))  {
                                              checkbox_vat = c_vat.isChecked();
                                              totalSquare = areaAddU - areaAddE;
                                              Double wallW_dou = Double.parseDouble(edt_wallW.getText().toString());
                                              Double wallL_dou = Double.parseDouble(edt_wallL.getText().toString());
                                              Double priceDoub = Double.parseDouble(priceEdt.getText().toString());
                                              Double wallArea_dou =( wallL_dou/100)*(wallW_dou/100);
                                              Double numWall_dou = totalSquare/wallArea_dou;
                                             Integer num =((int) Math.ceil(numWall_dou));
                                              spar = num.longValue()/10;
                                              spar =((int) Math.ceil(spar))+1;





                                              priceHandDoub=priceDoub;
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
                                                  priceHandDoub = priceDoub*(100-hand1)/100;
                                                  priceHandDoub = priceHandDoub*(100-hand2)/100;
                                                  priceHandDoub = priceHandDoub*(100-hand3)/100;
                                              priceHandDoub = priceHandDoub*(100-hand4)/100;
                                              priceHandDoub = priceHandDoub*(100-hand5)/100;
                                              totalBht= (num*priceHandDoub) ;




                                              if (checkbox_vat == true) {
                                                  //คำนวน แยกภาษี
                                                  totalBht = totalBht + totalBht * 0.07;
                                                  priceHandDoub = priceHandDoub + priceHandDoub * 0.07;
                                              }

                                              Double handtoDou= priceDoub-priceHandDoub;
                                              Double totalprice= totalBht*priceHandDoub;

                                              DecimalFormat d2 = new DecimalFormat("0.00");
                                              DecimalFormat d0 = new DecimalFormat("0");
                                             String numWall =d0.format(num);
                                             String sparWall =d0.format(spar);

                                              totalSqStr = d2.format(totalSquare);

                                              String handPrice = d2.format(priceHandDoub);
                                              String discount = d2.format(handtoDou);
                                              String totalpeice = d2.format(totalBht);


                                              mSquareTv.setText(totalSqStr);
                                                numWallTv.setText(numWall);
                                             sparWallTv.setText(sparWall);

                                              handtoTV.setText(handPrice);
                                              discountTv.setText(discount);
                                              BhtTotalTv.setText(totalpeice);



                                          }else Toast.makeText(getApplicationContext(), "กรุณากรอกข้อมูลในช่องที่มีเครื่องหมาย *", Toast.LENGTH_LONG).show();
                                      }

                                      public void onBackPressed() {
                                          startActivity(new Intent(WallPaper.this, MainActivity.class));



                                      }

                                  }
        );

    }
    public void addcom(){
        spin_manmon =(Spinner)findViewById(R.id.manmonSpin);
        List<String> list = new ArrayList<String>();
        list.add("ผ้าม่านเมืองทอง");
        list.add("ผ้าม่านเมืองเงิน");
        list.add("ผ้าม่านเมืองทองแดง");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_manmon.setAdapter(dataAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_wall_paper, menu);
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

    public void onBackPressed() {

        super.onBackPressed();
        Intent i = new Intent(WallPaper.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();
    }

}

