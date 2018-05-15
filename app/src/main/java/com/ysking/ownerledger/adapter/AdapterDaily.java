package com.ysking.ownerledger.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
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
    ArrayList<DailyData> dataList;





    public AdapterDaily(Context context, LayoutInflater inflater, ArrayList<DailyData> dataList) {
        this.context = context;
        this.inflater=inflater;
        this.dataList=dataList;


    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
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
        DailyData dailyData=dataList.get(position);
        tv.setText(dailyData.getDivision()+":"+dailyData.getSales());
        if(dailyData.getDivision().equals(DailyData.divisionSales)){
            view.setBackgroundColor(Color.RED);
            view.setTag(dailyData);
        }
        else{
            view.setBackgroundColor(Color.BLUE);
            view.setTag(dailyData);
        }
        return view;
    }

}
