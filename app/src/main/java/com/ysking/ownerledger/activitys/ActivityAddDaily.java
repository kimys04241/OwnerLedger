package com.ysking.ownerledger.activitys;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.Toast;


import com.ysking.ownerledger.R;
import com.ysking.ownerledger.database.DailyDB;
import com.ysking.ownerledger.date.DateManager;
import com.ysking.ownerledger.fragments.FragmentPurchase;
import com.ysking.ownerledger.fragments.FragmentSales;

public class ActivityAddDaily extends AppCompatActivity {

    Toolbar toolbar;

    FragmentManager fragmentManager;
    Fragment currentFragment;

    RadioGroup radioGroup;

    int[] checkedDate;

    DailyDB dailyDB;
    String division;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_daily);

        dailyDB=new DailyDB(this);

        fragmentManager=getSupportFragmentManager();
        checkedDate= DateManager.getCheckedDate();
        toolbar=findViewById(R.id.toolbar);
        radioGroup=findViewById(R.id.radio_group_daily);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle(String.format("%d-%02d-%02d", checkedDate[0], checkedDate[1], checkedDate[2]));
        radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);
        inflateSalesFragment();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }




    public void inflateSalesFragment(){
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        if(currentFragment!=null) transaction.remove(currentFragment);
        FragmentSales fragmentSales=new FragmentSales();
        currentFragment=fragmentSales;
        transaction.add(R.id.fragment, fragmentSales);
        transaction.commit();
    }

    public void inflatePurchaseFragment(){
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        if(currentFragment!=null) transaction.remove(currentFragment);
        FragmentPurchase fragmentPurchase=new FragmentPurchase();
        currentFragment=fragmentPurchase;
        transaction.add(R.id.fragment, fragmentPurchase);
        transaction.commit();
    }

    RadioGroup.OnCheckedChangeListener onCheckedChangeListener=new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            int radioId=radioGroup.getCheckedRadioButtonId();

            switch (radioId){
                case R.id.radio_button_sales:
                    inflateSalesFragment();
                    division="매출";
                    break;
                case R.id.radio_button_purchase:
                    inflatePurchaseFragment();
                    division="매입";
                    break;
            }
        }
    };




}
