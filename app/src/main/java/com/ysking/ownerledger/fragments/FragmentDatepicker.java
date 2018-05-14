package com.ysking.ownerledger.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.ysking.ownerledger.MainActivity;
import com.ysking.ownerledger.R;
import com.ysking.ownerledger.date.DateManager;

/**
 * Created by alfo06-25 on 2018-05-09.
 */

public class FragmentDatepicker extends Fragment {

    DatePicker datePicker;
    Button btnCheck;
    private static boolean isFirst=true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_datepicker, container, false);
        datePicker=view.findViewById(R.id.datepicker);
        btnCheck=view.findViewById(R.id.btn_datepicker_check);
        btnCheck.setOnClickListener(onClickListener);

        if(isFirst) isFirst=false;
        else{
            int[] datepicker=DateManager.getDatePicker();
            datePicker.init(datepicker[0], datepicker[1]-1, datepicker[2], null);
        }

        return view;
    }

    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            DateManager.setDatePicker(datePicker.getYear()+"-"+(datePicker.getMonth()+1)+"-"+datePicker.getDayOfMonth());
            DateManager.setChcekedDate(datePicker.getYear()+"-"+(datePicker.getMonth()+1)+"-"+datePicker.getDayOfMonth());
            MainActivity mainActivity=(MainActivity) getActivity();
            mainActivity.setDatePickerResult();
            mainActivity.destroyFragmentDatepicker();

        }
    };


}
