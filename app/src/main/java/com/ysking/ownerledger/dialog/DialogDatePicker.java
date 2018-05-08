package com.ysking.ownerledger.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.Toast;

import com.ysking.ownerledger.activitys.ActivityAddDaily;
import com.ysking.ownerledger.date.DateManager;

/**
 * Created by alfo06-25 on 2018-05-08.
 */

public class DialogDatePicker extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        int[] today= DateManager.getToday();

        int year=today[0];
        int month=today[1];
        int date=today[2];


        return new DatePickerDialog(getContext(), onDateSetListener, year, month, date);
    }

    private DatePickerDialog.OnDateSetListener onDateSetListener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int date) {
            String checkedDate=String.format("%d-%02d-%02d", year, month+1, date);
            DateManager.setChcekedDate(checkedDate);
            Intent intent=new Intent(getContext(), ActivityAddDaily.class);
            startActivity(intent);
        }
    };
}
