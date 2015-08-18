package com.first.tripakey.caldecorate.main;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.first.tripakey.caldecorate.R;

import java.text.DecimalFormat;

public class Tab3 extends Fragment {
    public  TextWatcher textWatcherM,textWatcherY,textWatcherM2,textWatcherY2,textWatcherM3,textWatcherY3,textWatcherM4,textWatcherY4;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_3, container, false);
/////Mtr-Yd
      final   EditText ydEdt =(EditText)v.findViewById(R.id.yd_edt);
       final EditText mEdt =(EditText)v.findViewById(R.id.mtr_edt);
//////BthMtr-BthYd
        final   EditText BthydEdt =(EditText)v.findViewById(R.id.BthYd_edt);
        final EditText BthmEdt =(EditText)v.findViewById(R.id.BthMtr_edt);
 ///// ////SqMtr-SqYd
        final   EditText SqydEdt =(EditText)v.findViewById(R.id.Sqyd_edt);
        final EditText SqmEdt =(EditText)v.findViewById(R.id.Sqmtr_edt);
//////SqBthMtr-SqBthYd
        final   EditText BthSqydEdt =(EditText)v.findViewById(R.id.BthSqyd_edt);
        final EditText BthSqmEdt =(EditText)v.findViewById(R.id.BthSqmtr_edt);

        //////////////////start line 1 unit
        textWatcherM=new TextWatcher() {
            DecimalFormat d2 = new DecimalFormat("0.0000");
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                if ((!mEdt.getText().toString().trim().isEmpty()) ){
                   String mtrStr =   mEdt.getText().toString();
                   Double mtrInt = Double.parseDouble(mtrStr);
                    mtrInt=mtrInt*1.093613298;
                    String m =d2.format(mtrInt);
                    ydEdt.removeTextChangedListener(textWatcherY);
                    ydEdt.setText(m);
                    ydEdt.addTextChangedListener(textWatcherY);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        };
        textWatcherY=new TextWatcher() {
            DecimalFormat d2 = new DecimalFormat("0.0000");
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                if ((!ydEdt.getText().toString().trim().isEmpty()) ){
                  String  ydStr =   ydEdt.getText().toString();
                  Double  ydInt = Double.parseDouble(ydStr);
                    ydInt=ydInt*0.9144;
                    String y =d2.format(ydInt);
                    mEdt.removeTextChangedListener(textWatcherM);
                    mEdt.setText(y);
                    mEdt.addTextChangedListener(textWatcherM);
                    // mtrEdt.setText(mtrStr);
                }

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        };
        ydEdt.addTextChangedListener(textWatcherY);
        mEdt.addTextChangedListener(textWatcherM);
        //////////////////end line 1 unit

        //////////////////start line 2 unit
        textWatcherM2=new TextWatcher() {
            DecimalFormat d2 = new DecimalFormat("0.0000");
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                if ((!BthydEdt.getText().toString().trim().isEmpty()) ){
                    String mtrStr =   BthydEdt.getText().toString();
                    Double mtrInt = Double.parseDouble(mtrStr);
                    mtrInt=mtrInt*1.093613298;
                    String m =d2.format(mtrInt);
                    BthmEdt.removeTextChangedListener(textWatcherY2);
                    BthmEdt.setText(m);
                    BthmEdt.addTextChangedListener(textWatcherY2);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        };
        textWatcherY2=new TextWatcher() {
            DecimalFormat d2 = new DecimalFormat("0.0000");
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                if ((!BthmEdt.getText().toString().trim().isEmpty()) ){
                    String  ydStr =   BthmEdt.getText().toString();
                    Double  ydInt = Double.parseDouble(ydStr);
                    ydInt=ydInt*0.9144;
                    String y =d2.format(ydInt);
                    BthydEdt.removeTextChangedListener(textWatcherM2);
                    BthydEdt.setText(y);
                    BthydEdt.addTextChangedListener(textWatcherM2);
                    // mtrEdt.setText(mtrStr);
                }

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        };
        BthmEdt.addTextChangedListener(textWatcherY2);
        BthydEdt.addTextChangedListener(textWatcherM2);
        //////////////////end line 2 unit

        //////////////////start line 3 unit
        textWatcherM3=new TextWatcher() {
            DecimalFormat d2 = new DecimalFormat("0.0000");
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                if ((!SqmEdt.getText().toString().trim().isEmpty()) ){
                    String mtrStr =   SqmEdt.getText().toString();
                    Double mtrInt = Double.parseDouble(mtrStr);
                    mtrInt=mtrInt/1.2;
                    String m =d2.format(mtrInt);
                    SqydEdt.removeTextChangedListener(textWatcherY3);
                    SqydEdt.setText(m);
                    SqydEdt.addTextChangedListener(textWatcherY3);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        };
        textWatcherY3=new TextWatcher() {
            DecimalFormat d2 = new DecimalFormat("0.0000");
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                if ((!SqydEdt.getText().toString().trim().isEmpty()) ){
                    String  ydStr =   SqydEdt.getText().toString();
                    Double  ydInt = Double.parseDouble(ydStr);
                    ydInt=ydInt*1.2;
                    String y =d2.format(ydInt);
                    SqmEdt.removeTextChangedListener(textWatcherM3);
                    SqmEdt.setText(y);
                    SqmEdt.addTextChangedListener(textWatcherM3);
                    // mtrEdt.setText(mtrStr);
                }

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        };
        SqydEdt.addTextChangedListener(textWatcherY3);
        SqmEdt.addTextChangedListener(textWatcherM3);
        //////////////////end line 3 unit

        //////////////////start line 4 unit
        textWatcherM4=new TextWatcher() {
            DecimalFormat d2 = new DecimalFormat("0.0000");
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                if ((!BthSqydEdt.getText().toString().trim().isEmpty()) ){
                    String mtrStr =   BthSqydEdt.getText().toString();
                    Double mtrInt = Double.parseDouble(mtrStr);
                    mtrInt=mtrInt/1.2;
                    String m =d2.format(mtrInt);
                    BthSqmEdt.removeTextChangedListener(textWatcherY4);
                    BthSqmEdt.setText(m);
                    BthSqmEdt.addTextChangedListener(textWatcherY4);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        };
        textWatcherY4=new TextWatcher() {
            DecimalFormat d2 = new DecimalFormat("0.0000");
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                if ((!BthSqmEdt.getText().toString().trim().isEmpty()) ){
                    String  ydStr =   BthSqmEdt.getText().toString();
                    Double  ydInt = Double.parseDouble(ydStr);
                    ydInt=ydInt*1.2;
                    String y =d2.format(ydInt);
                    BthSqydEdt.removeTextChangedListener(textWatcherM4);
                    BthSqydEdt.setText(y);
                    BthSqydEdt.addTextChangedListener(textWatcherM4);
                    // mtrEdt.setText(mtrStr);
                }

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        };
        BthSqmEdt.addTextChangedListener(textWatcherY4);
        BthSqydEdt.addTextChangedListener(textWatcherM4);
        //////////////////end line 4 unit


        return v;
    }

}
