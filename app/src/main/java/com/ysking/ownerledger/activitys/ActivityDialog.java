package com.ysking.ownerledger.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.ysking.ownerledger.R;

public class ActivityDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    public void clickBtnCheck(View v){

    }

    public void clickBtnCancel(View v){
        finish();
    }
}
