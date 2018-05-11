package com.ysking.ownerledger.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ysking.ownerledger.R;
import com.ysking.ownerledger.dailydata.DailyData;

import java.util.ArrayList;

/**
 * Created by alfo06-25 on 2018-05-11.
 */

public class AdapterDaily extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    DailyData dailyData;
    ArrayList<String[]> salesData;
    ArrayList<String[]> purchaseData;
    int cnt;

    public AdapterDaily(Context context, LayoutInflater inflater, DailyData dailyData) {
        this.context = context;
        this.inflater=inflater;
        this.dailyData = dailyData;
        salesData=dailyData.getSalesData();
        purchaseData=dailyData.getPurchaseData();
        cnt=dailyData.getCnt();
    }

    @Override
    public int getCount() {
        return cnt;
    }

    @Override
    public Object getItem(int position) {
      if(salesData.size()<=position+1){
          return salesData.get(position);
      }else{
          return purchaseData.get(position-salesData.size());
      }

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if(view==null){
            view=inflater.inflate(R.layout.list_item_inside_daily, viewGroup, false);
        }

        TextView tv=view.findViewById(R.id.list_item_tv);
        String[] data;
        if(salesData.size()<=position){
            data=salesData.get(position);
            tv.setBackgroundColor(Color.RED);
        }else{
            data=purchaseData.get(position-salesData.size());
            tv.setBackgroundColor(Color.BLUE);
        }
        String s=data[3]+":"+data[2];
        return view;
    }
}
