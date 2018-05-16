package com.ysking.ownerledger;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TabHost;
import android.widget.TextView;

import com.ysking.ownerledger.date.DateManager;
import com.ysking.ownerledger.fragments.FragmentCustomer;
import com.ysking.ownerledger.fragments.FragmentDaily;
import com.ysking.ownerledger.fragments.FragmentDatepicker;
import com.ysking.ownerledger.fragments.FragmentHome;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;

    Toolbar toolbar;
    TextView yearMonthDate;

    TabLayout tabLayout;

    Fragment currentFragment;

    FragmentDatepicker fragmentDatepicker;

    public static final String home="Home";
    public static final String customer="Customer";
    public static final String daily="Daily";
    public static final String chart="Chart";
    public static final String board="Board";

    boolean isFirstClick=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        tabLayout=findViewById(R.id.tab_layout);
        yearMonthDate=findViewById(R.id.year_month);

        fragmentManager=getSupportFragmentManager();

        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        inflateHomeFragment();

        setTab();
        tabLayout.addOnTabSelectedListener(tabSelectedListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(DateManager.getCheckedDate()!=null){
            int[] checkedDate=DateManager.getCheckedDate();
            String setDate=String.format("%d-%02d-%02d", checkedDate[0], checkedDate[1], checkedDate[2]);
            yearMonthDate.setText(setDate);
        }
    }

    public void clickYearMonth(View v){
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        fragmentDatepicker=new FragmentDatepicker();
        transaction.add(R.id.container,fragmentDatepicker);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mainactivity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId=item.getItemId();
        switch (itemId){
            case R.id.menu_change_info:

                break;

            case R.id.menu_backup:
                //TODO n드라이브 연동
                break;

            case R.id.menu_help:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setTab(){
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_home_black_24dp).setTag(home));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_people_black_24dp).setTag(customer));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_edit_black_24dp).setTag(daily));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_pie_chart_black_24dp).setTag(chart));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_content_paste_black_24dp).setTag(board));
    }

    TabLayout.OnTabSelectedListener tabSelectedListener=new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            String tag=(String)tab.getTag();
            if(isFirstClick){
                if(tag==home) return;
                else isFirstClick=false;
            }
            switch (tag){
                case home:
                    inflateHomeFragment();
                    break;
                case customer:
                    inflateCustomerFragment();
                    break;
                case daily:
                    inflateDialyFragment();
                    break;
                case chart:
                    break;
                case board:
                    break;
            }
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };

    public void inflateHomeFragment(){
        //TODO 타이틀 가운데로
        toolbar.setTitle(R.string.appbar_title_home);
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        if(currentFragment!=null) transaction.remove(currentFragment);
        FragmentHome fragmentHome=new FragmentHome();
        currentFragment=fragmentHome;
        transaction.add(R.id.fragment, fragmentHome);
        transaction.commit();
        yearMonthDate.setVisibility(View.GONE);
    }

    public void inflateCustomerFragment(){
        toolbar.setTitle(R.string.appbar_title_customer);
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        if(currentFragment!=null) transaction.remove(currentFragment);
        FragmentCustomer fragmentCustomer=new FragmentCustomer();
        currentFragment=fragmentCustomer;
        transaction.add(R.id.fragment, fragmentCustomer);
        transaction.commit();
        yearMonthDate.setVisibility(View.GONE);
    }

    public void inflateDialyFragment(){
        toolbar.setTitle("일별장부");
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        if(currentFragment!=null) transaction.remove(currentFragment);
        FragmentDaily fragmentDaily=new FragmentDaily();
        currentFragment=fragmentDaily;
        transaction.add(R.id.fragment, fragmentDaily);
        transaction.commit();
        yearMonthDate.setVisibility(View.VISIBLE);
        int[] today= DateManager.getToday();
        String chcekedDate=String.format("%d-%02d-%02d", today[0], today[1], today[2]);
        DateManager.setChcekedDate(chcekedDate);
        yearMonthDate.setText(chcekedDate);
    }

    public void setDatePickerResult(){

        int[] datePicker=DateManager.getDatePicker();
        yearMonthDate.setText(String.format("%d-%02d-%02d", datePicker[0], datePicker[1], datePicker[2]));
    }

    public void destroyFragmentDatepicker(){
        FragmentDaily fragmentDaily=(FragmentDaily) currentFragment;
        //fragmentDaily.setListView();
        fragmentDaily.setRecyclerAdapter();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        if(fragmentDatepicker!=null) transaction.remove(fragmentDatepicker);
        transaction.commit();
    }

}
