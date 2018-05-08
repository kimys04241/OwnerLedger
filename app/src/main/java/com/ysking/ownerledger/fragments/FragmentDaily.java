package com.ysking.ownerledger.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ysking.ownerledger.R;

public class FragmentDaily extends Fragment{

    RecyclerView recyclerView;
    Button btnModify;
    Button btnWrite;
    Button btnDelete;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_daily, container, false);
        recyclerView=view.findViewById(R.id.recycler_inside_daily);
        btnModify=view.findViewById(R.id.btn_inside_daily_modify);
        btnWrite=view.findViewById(R.id.btn_inside_daily_write);
        btnDelete=view.findViewById(R.id.btn_inside_daily_delete);

        return view;

    }

    View.OnClickListener btnDailyListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id=view.getId();

            switch (id){
                case R.id.btn_inside_daily_modify:
                    break;
                case R.id.btn_inside_daily_write:
                    break;
                case R.id.btn_inside_daily_delete:
                    break;
            }
        }
    };

    public void btnWriteBehavior(){

    }
}
