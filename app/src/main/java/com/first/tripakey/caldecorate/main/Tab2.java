package com.first.tripakey.caldecorate.main;

/**
 * Created by gaewgan on 8/7/2015.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.first.tripakey.caldecorate.R;
import com.first.tripakey.caldecorate.cost.costFurnitureFabrics;
import com.first.tripakey.caldecorate.cost.costWallpaper;
import com.first.tripakey.caldecorate.cost.cost_curtain;

/**
 * Created by hp1 on 21-01-2015.
 */
public class Tab2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_2,container,false);
        Button bt1 =(Button)v.findViewById(R.id.bt_curtain);
        Button bt2 =(Button)v.findViewById(R.id.manmonBt);
        Button bt3 =(Button)v.findViewById(R.id.mooliBt);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), cost_curtain.class);
                startActivity(intent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), costFurnitureFabrics.class);
                startActivity(intent);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), costWallpaper.class);
                startActivity(intent);
            }
        });

        return v;
    }
}
