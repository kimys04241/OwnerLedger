package com.ysking.ownerledger.activitys;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.ysking.ownerledger.R;

public class ActivityBackup extends AppCompatActivity {

    EditText edit1;
    EditText edit2;
    EditText edit3;
    EditText edit4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backup);

        edit1=findViewById(R.id.edit1);
        edit2=findViewById(R.id.edit2);
        edit3=findViewById(R.id.edit3);
        edit4=findViewById(R.id.edit4);

        edit1.requestFocus();

        InputMethodManager imm= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

    }
}
