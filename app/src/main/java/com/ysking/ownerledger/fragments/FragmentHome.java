package com.ysking.ownerledger.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.ysking.ownerledger.R;
import com.ysking.ownerledger.date.DateManager;

import java.util.Calendar;

/**
 * Created by alfo06-25 on 2018-05-01.
 */

public class FragmentHome extends Fragment {

    CalendarView calendarView;
    TextView tvYMD;
    String today;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        Calendar calendar=Calendar.getInstance();
        calendarView=view.findViewById(R.id.cv_calendar);
        tvYMD=view.findViewById(R.id.tv_home_ymd);
        today=String.format("%d-%02d-%02d", calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DATE));
        DateManager.setToday(today);
        tvYMD.setText(today);
        calendarView.setOnDateChangeListener(dateChangeListener);
        return view;
    }

    CalendarView.OnDateChangeListener dateChangeListener=new CalendarView.OnDateChangeListener() {
        @Override
        public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
            tvYMD.setText(i+"-"+(i1+1)+"-"+i2);
        }
    };
}
