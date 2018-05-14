package com.ysking.ownerledger.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputType;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ysking.ownerledger.R;
import com.ysking.ownerledger.activitys.ActivityAddDaily;
import com.ysking.ownerledger.dailydata.DailyData;
import com.ysking.ownerledger.database.DailyDB;
import com.ysking.ownerledger.date.DateManager;

/**
 * Created by alfo06-25 on 2018-05-08.
 */

public class FragmentSales extends Fragment{

    EditText editSales;
    EditText editCategory;
    EditText editClassification;
    EditText editConnection;
    EditText editMemo;
    Button btnCheck;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_sales, container, false);
        editSales=view.findViewById(R.id.edit_sales);
        editCategory=view.findViewById(R.id.edit_sales_category);
        editClassification=view.findViewById(R.id.edit_sales_classification);
        editConnection=view.findViewById(R.id.edit_sales_connection);
        editMemo=view.findViewById(R.id.edit_sales_memo);
        btnCheck=view.findViewById(R.id.btn_fragment_sales_check);
        btnCheck.setOnClickListener(onClickListener);

        return view;
    }

    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            passDailyData();
        }
    };

    public void passDailyData(){

        int[] split=DateManager.getCheckedDate();
        String date=String.format("%d-%02d-%02d", split[0], split[1], split[2]);
        DailyData dailyData=new DailyData(date, "매출", editSales.getText().toString(), editCategory.getText().toString(), editClassification.getText().toString()
                                           , editConnection.getText().toString(), editMemo.getText().toString());
        DailyDB dailyDB=new DailyDB(getContext());
        dailyDB.createTable(date);
        dailyDB.insertData(dailyData);
        ActivityAddDaily activityAddDaily=(ActivityAddDaily) getActivity();
        activityAddDaily.finish();
    }

}
