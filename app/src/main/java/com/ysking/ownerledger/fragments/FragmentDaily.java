package com.ysking.ownerledger.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.ysking.ownerledger.R;
import com.ysking.ownerledger.adapter.AdapterDaily;
import com.ysking.ownerledger.dailydata.DailyData;
import com.ysking.ownerledger.database.DailyDB;
import com.ysking.ownerledger.dialog.DialogDatePicker;

public class FragmentDaily extends Fragment{



    ListView listView;
    Button btnModify;
    Button btnWrite;
    Button btnDelete;

    DailyDB dailyDB;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_daily, container, false);
        listView=view.findViewById(R.id.listview_inside_daily);
        btnModify=view.findViewById(R.id.btn_inside_daily_modify);
        btnWrite=view.findViewById(R.id.btn_inside_daily_write);
        btnDelete=view.findViewById(R.id.btn_inside_daily_delete);
        btnWrite.setOnClickListener(btnDailyListener);
        dailyDB=new DailyDB(getContext());

        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        if(dailyDB.getDailyData()!=null){
            DailyData dailyData=dailyDB.getDailyData();
            AdapterDaily adapterDaily=new AdapterDaily(getContext(), getLayoutInflater(), dailyData);
            listView.setAdapter(adapterDaily);
        }
    }

    View.OnClickListener btnDailyListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id=view.getId();

            switch (id){
                case R.id.btn_inside_daily_modify:
                    break;
                case R.id.btn_inside_daily_write:
                    btnWriteBehavior();
                    break;
                case R.id.btn_inside_daily_delete:
                    break;
            }
        }
    };

    public void btnWriteBehavior(){
        DialogFragment datePicker=new DialogDatePicker();
        datePicker.show(getFragmentManager(),"date picker");

    }
}
