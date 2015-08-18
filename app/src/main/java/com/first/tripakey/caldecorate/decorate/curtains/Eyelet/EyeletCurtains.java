package com.first.tripakey.caldecorate.decorate.curtains.Eyelet;
//หลักการตั้งตัวเปรใน java = ชนิดตัวแปร(ย่อ)_ชื่อตัวแปลนั้น
//หลักการตั้งตัวเปรใน xml  = ชื่อตัวแปลนั้น_ชนิดตัวแปร(ย่อ

//หน้าคำนวนม้านจีบ
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
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

public class EyeletCurtains extends Fragment {
    /////เริ่ม1 copy แอดส่วนลดตาม

    LinearLayout container, container2, discountF;
    static EditText testhand, field1, field2, field3, field4;
    public Integer onstart;
    static Double hand1, hand2, hand3, hand4, hand5;

    ///////จบ1 copy แอดส่วนลดตาม
    public Spinner spin_LTD;//spinner บริษัทขายผ้า
    public boolean checkbox_addFab, checkbox_vat;
    static double double_d, double_e, double_f, double_g, double_h, double_i, double_j,
            double_fabW,//ความกว่างผ้า
            double_priceInt,//ราคาผ้าต่อหลา
            double_priceLast,
            double_priceIntNOhand,//ราคาที่ยังไม่ลดราคา
            double_handi, double_handi1, double_handi2, double_handi3, double_handi4, double_handi5, //ส่วนลดตาม
            double_numPiece2,
            double_doorW, double_doorH,//ความกว้างยาวของหน้าต่าง
            double_numPiece,//จำนวนชิ้นผ้าที่ต้องใช้
            double_metreThaiunitPiece,//ความยาวผ้า หลา
            double_metrePiece,//ความยาวผ้า เมตร
            double_totalPrice,//ราคาทั้งหมด
            double_lastHandi, //ลดราคาสุดท้าย
            double_handless,
            double_numWin,//จำนวนหน้าต่างที่จะไปคูน
            double_interNumpice;
    static EditText edt_doorW, edt_doorH,
            edt_fabricW,
            edt_priceInt,
            edt_handi1, edt_handi2, edt_handi3, edt_handi4, edt_handi5,
            edt_numWin;
    static String stg_doorW, stg_doorH,
            stg_fabricW,
            stg_priceInt,
            stg_handi1, stg_handi2, stg_handi3, stg_handi4, stg_handi5,
            stg_lasthand,
            stg_lastprice,
            stg_numWin;
    static TextView txtV_totalPrice,
            txtV_numPiece,
            numM,
            txtV_metrePiece, txtV_thaimetrePiece,
            txtV_lastHandi,
            txtV_nameCur,
            txtV_branIN,
            txtV_codeIN,
            txtV_handLess;
    static Button bt_cal;
    static ImageButton bt_set;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_eyelet_curtains, container, false);
        /////เริ่ม2 copy แอดส่วนลดตาม
        onstart = 0;
        hand1 = 0.0;
        hand2 = 0.0;
        hand3 = 0.0;
        hand4 = 0.0;
        hand5 = 0.0;
///////จบ2 copy แอดส่วนลดตาม
        //อ่านค่าเซตติงจากไฟล์ SharedPreferences
        SharedPreferences sp = getActivity().getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);
        String stg_sharD = sp.getString("My_ValueDtaki", "2.5");
        String stg_sharE = sp.getString("My_ValueEtaki", "10.0");
        String stg_sharF = sp.getString("My_ValueFtaki", "10.0");
        String stg_sharG = sp.getString("My_ValueGtaki", "15.0");
        String stg_sharH = sp.getString("My_ValueHtaki", "30.0");
        String stg_sharI = sp.getString("My_ValueItaki", "10.0");
        String stg_sharJ = sp.getString("My_ValueJtaki", "50.0");
        //เปลียนเปน double
        double_d = Double.parseDouble(stg_sharD);
        double_e = Double.parseDouble(stg_sharE);
        double_f = Double.parseDouble(stg_sharF);
        double_g = Double.parseDouble(stg_sharG);
        double_h = Double.parseDouble(stg_sharH);
        double_i = Double.parseDouble(stg_sharI);
        double_j = Double.parseDouble(stg_sharJ);
        double_numWin = 1;//จำนวนคูนเริมต้นเปน 1 กันคุนได้ 0

        double_g = double_g * 2.0;
       setSpinnerCom(v);

        //เทียบตัวเปนกับ xml
        edt_numWin = (EditText) v.findViewById(R.id.numWinEdt);
        edt_doorW = (EditText) v.findViewById(R.id.doorW_edittxt);
        edt_doorH = (EditText) v.findViewById(R.id.doorH_edittxt);
        edt_fabricW = (EditText) v.findViewById(R.id.fabricW_edittxt);
        edt_priceInt = (EditText) v.findViewById(R.id.priceInt_edittxt);


        txtV_branIN = (TextView) v.findViewById(R.id.braneInput_textView);
        txtV_codeIN = (TextView) v.findViewById(R.id.codeInput_textView);

        txtV_handLess = (TextView) v.findViewById(R.id.handLess);
        txtV_totalPrice = (TextView) v.findViewById(R.id.totalPrice_textview);
        txtV_numPiece = (TextView) v.findViewById(R.id.numPiece_textview);
        numM = (TextView) v.findViewById(R.id.numM);
        txtV_metrePiece = (TextView) v.findViewById(R.id.metrePiece_textview);
        txtV_thaimetrePiece = (TextView) v.findViewById(R.id.thaimetrePiece_textview);
        txtV_lastHandi = (TextView) v.findViewById(R.id.lastHandi_textview);
        bt_cal = (Button) v.findViewById(R.id.button_cal);

        final CheckBox c_add = (CheckBox) v.findViewById(R.id.check_add);
        final CheckBox c_vat = (CheckBox) v.findViewById(R.id.check_vat);
        //ชื่อหัวข้อเอามาจาตัวแปรที่เก็บใว้ก่อนเข้าหน้านี้แล้ว

        //กดไปหน้าตั้งค่า

        //////เริ่ม3 copy แอดส่วนลดตาม
        container = (LinearLayout) v.findViewById(R.id.container);
        container2 = (LinearLayout) v.findViewById(R.id.container2);
        discountF = (LinearLayout) v.findViewById(R.id.discountReq);
        testhand = (EditText) v.findViewById(R.id.handi1_edittxt);

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
                        LayoutInflater layoutInflater2 = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
                                        LayoutInflater layoutInflater2 = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
                                                        LayoutInflater layoutInflater2 = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
                                                                        LayoutInflater layoutInflater2 = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

        //เมื่อกดคำนวน
        bt_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if เพื่อไม่ไห้ error เวลาช่อง edittext ว่าง
                if ((!edt_doorH.getText().toString().trim().isEmpty()) &&
                        (!edt_doorW.getText().toString().trim().isEmpty()) &&
                        (!edt_fabricW.getText().toString().trim().isEmpty())) {
                    //เอาค่าจากตัวแปรมาใช้
                    checkbox_addFab = c_add.isChecked();
                    checkbox_vat = c_vat.isChecked();
                    stg_doorH = edt_doorH.getText().toString();
                    double_doorH = Double.parseDouble(stg_doorH);
                    stg_doorW = edt_doorW.getText().toString();
                    double_doorW = Double.parseDouble(stg_doorW);
                    stg_fabricW = edt_fabricW.getText().toString();
                    double_fabW = Double.parseDouble(stg_fabricW);
                    stg_priceInt = edt_priceInt.getText().toString();
                    double_priceInt = Double.parseDouble(stg_priceInt);
                    //คำนวน จ ชิ้น
                    double_numPiece = ((double_doorW + double_g) * double_d) / double_fabW;
                    //คำนวน ความยาว เมตร
                    double_metrePiece = ((double_doorH + double_e + double_f + double_h) * double_numPiece) * ((double_i / 100) + 1);
                    double_metrePiece = double_metrePiece / 100;//จาก ซม เปน เมตร
                    //if ช่อง edittext ของจำนวนหน้าต่างมีข้อมูลก้นำเอาไปคำนวนด้วย
                    if (!edt_numWin.getText().toString().trim().isEmpty()) {
                        stg_numWin = edt_numWin.getText().toString();
                        double_numWin = Double.parseDouble(stg_numWin);
                        double_metrePiece = double_metrePiece * double_numWin;
                        double_numPiece = double_numPiece * double_numWin;
                    }
                    //เปลี่ยนเมตรเป็นหลา
                    double_metreThaiunitPiece = double_metrePiece * 1.0936;
                    //คำนวนราคา

                    double_priceIntNOhand = double_priceLast;

                    ///เริ่ม4 copy แอดส่วนลดตาม
                    double_lastHandi = double_priceInt;
                    switch (onstart) {
                        case 0:
                            if (!testhand.getText().toString().trim().isEmpty()) {
                                hand1 = Double.parseDouble(testhand.getText().toString());
                            }
                            break;
                        case 1:
                            if (!testhand.getText().toString().trim().isEmpty()) {
                                hand1 = Double.parseDouble(testhand.getText().toString());
                            }
                            if (!field1.getText().toString().trim().isEmpty()) {
                                hand2 = Double.parseDouble(field1.getText().toString());
                            }
                            break;
                        case 2:
                            if (!testhand.getText().toString().trim().isEmpty()) {
                                hand1 = Double.parseDouble(testhand.getText().toString());
                            }
                            if (!field1.getText().toString().trim().isEmpty()) {
                                hand2 = Double.parseDouble(field1.getText().toString());
                            }
                            if (!field2.getText().toString().trim().isEmpty()) {
                                hand3 = Double.parseDouble(field2.getText().toString());
                            }
                            break;
                        case 3:
                            if (!testhand.getText().toString().trim().isEmpty()) {
                                hand1 = Double.parseDouble(testhand.getText().toString());
                            }
                            if (!field1.getText().toString().trim().isEmpty()) {
                                hand2 = Double.parseDouble(field1.getText().toString());
                            }
                            if (!field2.getText().toString().trim().isEmpty()) {
                                hand3 = Double.parseDouble(field2.getText().toString());
                            }
                            if (!field3.getText().toString().trim().isEmpty()) {
                                hand4 = Double.parseDouble(field3.getText().toString());
                            }
                            break;
                        case 4:
                            if (!testhand.getText().toString().trim().isEmpty()) {
                                hand1 = Double.parseDouble(testhand.getText().toString());
                            }
                            if (!field1.getText().toString().trim().isEmpty()) {
                                hand2 = Double.parseDouble(field1.getText().toString());
                            }
                            if (!field2.getText().toString().trim().isEmpty()) {
                                hand3 = Double.parseDouble(field2.getText().toString());
                            }
                            if (!field3.getText().toString().trim().isEmpty()) {
                                hand4 = Double.parseDouble(field3.getText().toString());
                            }
                            if (!field4.getText().toString().trim().isEmpty()) {
                                hand5 = Double.parseDouble(field4.getText().toString());
                            }
                            break;
                    }
                    double_lastHandi = double_priceInt * (100 - hand1) / 100;
                    double_lastHandi = double_lastHandi * (100 - hand2) / 100;
                    double_lastHandi = double_lastHandi * (100 - hand3) / 100;
                    double_lastHandi = double_lastHandi * (100 - hand4) / 100;
                    double_lastHandi = double_lastHandi * (100 - hand5) / 100;

                    ///////จบ4 copy แอดส่วนลดตาม

                    if (checkbox_vat == true) {
                        //คำนวน แยกภาษี
                        double_lastHandi = double_lastHandi + double_lastHandi * 0.07;
                        // Toast.makeText(getApplicationContext(),"check vat",Toast.LENGTH_SHORT).show();
                    }

                    double_priceLast = double_lastHandi * double_metreThaiunitPiece;


                } else
                    Toast.makeText(v.getContext(), "กรุณากรอกข้อมูลในช่องที่มีเครื่องหมายดอกจัน *", Toast.LENGTH_LONG).show();
                // DecimalFormat d4 = new DecimalFormat("0.0000");//ยังไม่ได้ใช้ เผื่อใช้
                DecimalFormat d2 = new DecimalFormat("0.00");

                double_handless = double_priceInt - double_lastHandi;

                stg_lasthand = d2.format(double_lastHandi);


                String yd = d2.format(double_metreThaiunitPiece);
                double_metreThaiunitPiece = Double.parseDouble(yd);

                double_priceLast = double_lastHandi * double_metreThaiunitPiece;
                stg_lastprice = d2.format(double_priceLast);
                //ปัดเลขขึ้นเปนจำนวนเต็ม หรือ 0.5
                double_numPiece2 = (long) Math.floor(double_numPiece + 0.5d);
                double_interNumpice = double_numPiece2 - double_numPiece;
                if (double_interNumpice < 0) {
                    double_numPiece2 = double_numPiece2 + 0.5;
                }
                //หากมีการติกสายรวบม่าน
                if (checkbox_addFab == true) {
                    //คำนวน +สายรวบม่าน
                    double_metrePiece = double_metrePiece + double_j / 100 * double_numWin;
                    double_metreThaiunitPiece = double_metrePiece * 1.0936;
                    double_priceInt = double_priceInt * double_metreThaiunitPiece;
                    // Toast.makeText(getApplicationContext(),"check add",Toast.LENGTH_SHORT).show();
                }

                double_numPiece = double_metrePiece / double_numPiece2;
                //ตั้งตัวแปรแล้วใช้เลย
                String numPice2_stg = d2.format(double_numPiece2);
                String numPiece_stg = d2.format(double_numPiece);
                String showmetre = d2.format(double_metrePiece);
                String showmetrethai = d2.format(double_metreThaiunitPiece);
                String handLess_stng = d2.format(double_handless);
                // แสดงผลลัพ
                txtV_metrePiece.setText(showmetre);
                txtV_thaimetrePiece.setText(showmetrethai);
                txtV_numPiece.setText(numPice2_stg);
                numM.setText(numPiece_stg);
                txtV_lastHandi.setText(stg_lasthand);
                txtV_totalPrice.setText(stg_lastprice);
                txtV_handLess.setText(handLess_stng);

            }
        });
        return v;
    }


    //เลือกบริษัท
    private void setSpinnerCom( View view ){
        spin_LTD = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity().getBaseContext(),
                R.array.compuny, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spin_LTD.setAdapter(adapter);
    }
}




