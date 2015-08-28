package com.first.tripakey.caldecorate.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.first.tripakey.caldecorate.R;
import com.first.tripakey.caldecorate.decorate.BambooBlind;
import com.first.tripakey.caldecorate.decorate.RollerBlind;
import com.first.tripakey.caldecorate.decorate.VenetianBlind;
import com.first.tripakey.caldecorate.decorate.WallPaper;
import com.first.tripakey.caldecorate.decorate.RoomPartition;

public class Tab1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_1, container, false);
        Button curtain =(Button)v.findViewById(R.id.bt_curtain);
        Button manmon =(Button)v.findViewById(R.id.manmonBt);
        Button mooli =(Button)v.findViewById(R.id.mooliBt);
        Button mooliAlu =(Button)v.findViewById(R.id.mooliAlu);
        Button chag =(Button)v.findViewById(R.id.chag);
        Button wall =(Button)v.findViewById(R.id.wall);

        curtain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), com.first.tripakey.caldecorate.decorate.curtain.class);
                startActivity(intent);
            }
        });
        manmon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RollerBlind.class);
                startActivity(intent);
            }
        });
        mooli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BambooBlind.class);
                startActivity(intent);
            }
        });
        mooliAlu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), VenetianBlind.class);
                startActivity(intent);
            }
        });

        chag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RoomPartition.class);
                startActivity(intent);
            }
        });
        wall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), WallPaper.class);
                startActivity(intent);
            }
        });

        return v;
    }
}
