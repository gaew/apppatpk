package com.first.tripakey.caldecorate.cost;
//หลักการตั้งตัวเปรใน java = ชนิดตัวแปร(ย่อ)_ชื่อตัวแปลนั้น
//หลักการตั้งตัวเปรใน xml  = ชื่อตัวแปลนั้น_ชนิดตัวแปร(ย่อ

//หน้าคำนวนค่าใช้จ่ายตัวที่ 1 ผ้าม้าน/ผ้าบุเฟอนิเจอร์
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.first.tripakey.caldecorate.main.MainActivity;
import com.first.tripakey.caldecorate.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class costFurnitureFabrics extends ActionBarActivity {
/////เริ่ม1 copy แอดส่วนลดตาม

    LinearLayout container,container2,discountF;
    static EditText            testhand,  field1,field2,field3,field4;
    public  Integer onstart;
    static Double   hand1,hand2,hand3,hand4,hand5;

    ///////จบ1 copy แอดส่วนลดตาม
    public Spinner spin_cost1;//แสดงชื้อบริษัทจำหน่ายผ้าม้าน

    static Double priceUse_d;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.costfer);
        setContentView(R.layout.activity_cost_furniture_fabrics);



        cost1addCompunny();
/////เริ่ม2 copy แอดส่วนลดตาม
        onstart=0;
        hand1 = 0.0;
        hand2 = 0.0;
        hand3 = 0.0;
        hand4 = 0.0;
        hand5 = 0.0;
///////จบ2 copy แอดส่วนลดตาม

        final EditText price = (EditText) findViewById(R.id.price);
        final EditText fab = (EditText) findViewById(R.id.fab);



        final TextView priceUse = (TextView) findViewById(R.id.priceUse);
        final TextView discount = (TextView) findViewById(R.id.discount);
        final TextView totalBht = (TextView) findViewById(R.id.totalBht);

        Button cal = (Button) findViewById(R.id.cal);


        final CheckBox vat = (CheckBox) findViewById(R.id.vat);
///เริ่ม3 copy แอดส่วนลดตาม
        container = (LinearLayout)findViewById(R.id.container);
        container2= (LinearLayout)findViewById(R.id.container2);
        discountF = (LinearLayout)findViewById(R.id.discountReq);
        testhand = (EditText)findViewById(R.id.handi1_edittxt);

        ImageView imgView = (ImageView)findViewById(R.id.ban_ic);
        imgView.setImageResource(R.drawable.ban_ic);

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



        ///////จบ3 copy แอดส่วนลด
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if          ((!price.getText().toString().trim().isEmpty())&&
                        (!fab.getText().toString().trim().isEmpty())){
                    Boolean cvat = vat.isChecked();

                    Double price_d = Double.parseDouble(price.getText().toString());
                    Double fab_d = Double.parseDouble(fab.getText().toString());
                    //เริ่ม4 copy แอดส่วนลดตาม
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

                    Double discount_d=price_d-priceUse_d;
                    Double totalBht_d=priceUse_d*fab_d;

                    DecimalFormat d4 = new DecimalFormat("0.0000");
                    DecimalFormat d2 = new DecimalFormat("0.00");

                    priceUse.setText(d2.format(priceUse_d));
                    discount.setText(d2.format(discount_d));
                    totalBht.setText(d2.format(totalBht_d));
                }else Toast.makeText(getApplicationContext(),"ต้องใส่ข้อมูลในช่องที่มีเครื่องหมายดอกจัน *",Toast.LENGTH_SHORT).show();



            }
        });

    }



    public void cost1addCompunny() {
        spin_cost1 = (Spinner) findViewById(R.id.cost1_spin);
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

        startActivity(new Intent(costFurnitureFabrics.this, MainActivity.class));

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cost1_2, menu);
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

