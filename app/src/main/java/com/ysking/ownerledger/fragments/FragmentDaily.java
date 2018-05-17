package com.ysking.ownerledger.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.ysking.ownerledger.R;
import com.ysking.ownerledger.activitys.ActivityModifyDaily;
import com.ysking.ownerledger.adapter.AdapterDaily;
import com.ysking.ownerledger.adapter.AdapterDaily2;
import com.ysking.ownerledger.dailydata.DailyData;
import com.ysking.ownerledger.database.DailyDB;
import com.ysking.ownerledger.date.DateManager;
import com.ysking.ownerledger.dialog.DialogDatePicker;

import java.util.ArrayList;

public class FragmentDaily extends Fragment{

    RecyclerView recyclerView;
    Button btnModify;
    Button btnWrite;
    Button btnDelete;

    DailyDB db;
    AdapterDaily2 adapterDaily2;

    private static View preItemView;

    boolean clicked=true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_daily, container, false);
//        listView=view.findViewById(R.id.listview_inside_daily);
//        listView.setOnItemClickListener(onItemClickListener);
        recyclerView=view.findViewById(R.id.recycler_inside_daily);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        btnModify=view.findViewById(R.id.btn_inside_daily_modify);
        btnWrite=view.findViewById(R.id.btn_inside_daily_write);
        btnDelete=view.findViewById(R.id.btn_inside_daily_delete);
        btnModify.setOnClickListener(btnDailyListener);
        btnWrite.setOnClickListener(btnDailyListener);
        btnDelete.setOnClickListener(btnDailyListener);
        db=new DailyDB(getContext());
        //setListView();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //setListView();
        setRecyclerAdapter();
    }

    public void setRecyclerAdapter(){
        int[] checkedDate=DateManager.getCheckedDate();
        String date=String.format("%d-%02d-%02d", checkedDate[0], checkedDate[1], checkedDate[2]);
        db.createTable(date);
        if(db.selectByTableName(date)!=DailyDB.cursorNull){
            ArrayList<DailyData> dataList=db.getDataList();
            adapterDaily2=new AdapterDaily2(getContext(), dataList);
            recyclerView.setAdapter(adapterDaily2);
            Log.i("TAG", "TAG:"+dataList.size());
        }
    }

    public static View getPreItemView() {
        return preItemView;
    }

    public static void setPreItemView(View preItemView) {
        FragmentDaily.preItemView = preItemView;
    }

    //    public void setListView(){
//        int[] checkedDate= DateManager.getCheckedDate();
//        String date=String.format("%d-%02d-%02d", checkedDate[0], checkedDate[1], checkedDate[2]);
//        db.createTable(date);
//        if(db.selectByTableName(date)!=DailyDB.cursorNull){
//            ArrayList<DailyData> dataList=db.getDataList();
//            adapterDaily=new AdapterDaily(getContext(), getLayoutInflater(), dataList);
//            listView.setAdapter(adapterDaily);
//        }
//    }

    View.OnClickListener btnDailyListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id=view.getId();

            switch (id){
                case R.id.btn_inside_daily_modify:
                    btnModifyBehavior();
                    break;
                case R.id.btn_inside_daily_write:
                    btnWriteBehavior();
                    break;
                case R.id.btn_inside_daily_delete:
                    btnDeleteBehavior();
                    break;
            }
        }
    };

    private void btnModifyBehavior(){
        if(preItemView!=null){
            Intent intent=new Intent(getContext(), ActivityModifyDaily.class);
            startActivity(intent);
        }else{
            new AlertDialog.Builder(getContext()).setMessage("수정할 정보를 선택하세요.").setPositiveButton("확인", null)
                    .create().show();
        }

    }

    private void btnWriteBehavior(){
        DialogFragment datePicker=new DialogDatePicker();
        datePicker.show(getFragmentManager(),"date picker");

    }

    private void btnDeleteBehavior(){
        if(preItemView!=null){
            new AlertDialog.Builder(getContext()).setMessage(R.string.dialog_removedaily).setPositiveButton("확인", alertDialogPositive)
                    .setNegativeButton("취소", null).create().show();
        }else{
            new AlertDialog.Builder(getContext()).setMessage(R.string.dialog_removedaily_nonselect)
                    .setPositiveButton("확인", null).create().show();
        }

    }

    DialogInterface.OnClickListener alertDialogPositive=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            int[] split=DateManager.getCheckedDate();
            String date=String.format("%d-%02d-%02d", split[0], split[1], split[2]);
            DailyData dailyData=(DailyData) preItemView.getTag();
            db.deleteByNo(date, dailyData);
            setRecyclerAdapter();
        }
    };

//    AdapterView.OnItemClickListener onItemClickListener=new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//            view.setBackgroundColor(Color.LTGRAY);
//            if(preView!=view){
//                if(preView!=null){
//                    DailyData dailyData=(DailyData)preView.getTag();
//                    switch (dailyData.getDivision()){
//                        case DailyData.divisionSales:
//                            preView.setBackgroundColor(Color.RED);
//                            break;
//                        case DailyData.divisionPurchase:
//                            preView.setBackgroundColor(Color.BLUE);
//                            break;
//                    }
//                }
//                preView=view;
//                view.setBackgroundColor(Color.LTGRAY);
//            }else if(preView==view){
//                if(clicked){
//                    DailyData dailyData=(DailyData) view.getTag();
//                    switch (dailyData.getDivision()){
//                        case DailyData.divisionSales:
//                            view.setBackgroundColor(Color.RED);
//                            clicked=!clicked;
//                            break;
//                        case DailyData.divisionPurchase:
//                            view.setBackgroundColor(Color.BLUE);
//                            clicked=!clicked;
//                            break;
//                    }
//                }else{
//                    view.setBackgroundColor(Color.LTGRAY);
//                    clicked=!clicked;
//                }
//
//            }
//
//        }
//    };
}
