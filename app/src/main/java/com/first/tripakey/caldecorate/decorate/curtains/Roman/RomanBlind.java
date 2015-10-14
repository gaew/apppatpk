package com.first.tripakey.caldecorate.decorate.curtains.Roman;
//หลักการตั้งตัวเปรใน java = ชนิดตัวแปร(ย่อ)_ชื่อตัวแปลนั้น
//หลักการตั้งตัวเปรใน xml  = ชื่อตัวแปลนั้น_ชนิดตัวแปร(ย่อ

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.first.tripakey.caldecorate.R;

import java.text.DecimalFormat;

public class RomanBlind extends Fragment {
/////เริ่ม1 copy แอดส่วนลดตาม
  private Spinner  spin_LTD ;//ตัวดรอบดาวแสดงค่า I
    LinearLayout container,container2,discountF;
    static EditText            testhand,  field1,field2,field3,field4;
    public  Integer onstart;
    static Double   hand1,hand2,hand3,hand4,hand5,g;
    static TextView numM;

    ///////จบ1 copy แอดส่วนลดตาม
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_roman_blind, container, false);
        /////เริ่ม2 copy แอดส่วนลดตาม
        onstart=0;
        hand1 = 0.0;
        hand2 = 0.0;
        hand3 = 0.0;
        hand4 = 0.0;
        hand5 = 0.0;
        g=0.0;

///////จบ2 copy แอดส่วนลดตาม




        SharedPreferences spp = getActivity().getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
      //  String stg_sharD = spp.getString("My_ValueD", "2.5");
        String stg_sharE = spp.getString("My_ValueEpup", "5.0");
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

        addCompunny(v);

        final EditText  w_edt = (EditText) v.findViewById(R.id.w);
        final EditText h_edt = (EditText) v.findViewById(R.id.h);
        final EditText wfab_edt = (EditText) v.findViewById(R.id.wfab);
        final EditText priceIn_edt = (EditText) v.findViewById(R.id.priceIn);


        final EditText numL_edt =(EditText)v.findViewById(R.id.numL);

        final TextView totalpeice_tv = (TextView) v.findViewById(R.id.totalPiece);
        final TextView ydOut_tv = (TextView) v.findViewById(R.id.ydOut);
        final TextView metreOut_tv = (TextView) v.findViewById(R.id.metreOut);
        final TextView priceUse_tv = (TextView) v.findViewById(R.id.priceUse);
        final TextView discount_tv = (TextView) v.findViewById(R.id.discount);
        final TextView totalBht_tv = (TextView) v.findViewById(R.id.totalBht);
        numM=(TextView)v.findViewById(R.id.numM);


        Button cal_bt = (Button) v.findViewById(R.id.cal);


        final CheckBox vat = (CheckBox) v.findViewById(R.id.vat);

        g = g*2.0;
        //////เริ่ม3 copy แอดส่วนลดตาม
        container = (LinearLayout)v.findViewById(R.id.container);
        container2= (LinearLayout)v.findViewById(R.id.container2);
        discountF = (LinearLayout)v.findViewById(R.id.discountReq);
        testhand = (EditText)v.findViewById(R.id.handi1_edittxt);

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
                        LayoutInflater layoutInflater2 = (LayoutInflater) getActivity().getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
                                if (field1.length() == 1) {
                                    if (onstart == 1) {
                                        onstart = 2;
                                        LayoutInflater layoutInflater2 = (LayoutInflater) getActivity().getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
                                                        LayoutInflater layoutInflater2 = (LayoutInflater) getActivity().getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
                                                                        LayoutInflater layoutInflater2 = (LayoutInflater) getActivity().getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

                    numPiece=metre/numPieceInter;

                    totalpeice_tv.setText(d2.format(numPieceInter));
                    numM.setText(d2.format(numPiece));
                    metreOut_tv.setText(d2.format(metre));
                    ydOut_tv.setText(d2.format(yd));
                    priceUse_tv.setText(d2.format(priceUse));
                    discount_tv.setText(d2.format(price-priceUse));
                    totalBht_tv.setText(d2.format(totalBth));

                } else
                    Toast.makeText(getActivity().getBaseContext(), "ต้องใส่ข้อมูลในช่องที่มีเครื่องหมายดอกจัน *", Toast.LENGTH_SHORT).show();

            }
        });
return v;
    }
    private void addCompunny( View view ){
        spin_LTD = (Spinner) view.findViewById(R.id.spinComp);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity().getBaseContext(),
                R.array.compuny, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spin_LTD.setAdapter(adapter);
    }
}

