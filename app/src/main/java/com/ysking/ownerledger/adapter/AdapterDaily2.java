package com.ysking.ownerledger.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ysking.ownerledger.R;
import com.ysking.ownerledger.dailydata.DailyData;
import com.ysking.ownerledger.database.DailyDB;
import com.ysking.ownerledger.fragments.FragmentDaily;

import java.util.ArrayList;

/**
 * Created by alfo06-25 on 2018-05-16.
 */

public class AdapterDaily2 extends RecyclerView.Adapter{

    Context context;
    ArrayList<DailyData> dataList;

    View preItemView;

    public AdapterDaily2(Context context, ArrayList<DailyData> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView;
        LayoutInflater layoutInflater=LayoutInflater.from(context);
        itemView=layoutInflater.inflate(R.layout.recycler_item_inside_daily_fragment, parent, false);

        VH2 holder=new VH2(itemView, dataList);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        VH2 vh2=(VH2)holder;
        bodyBind(vh2, position);
    }

    public void bodyBind(VH2 vh2, int position){
        DailyData dailyData=vh2.holderDataList.get(position);
        if(dailyData.getDivision().equals(DailyData.divisionSales)){
            vh2.itemView.setBackgroundColor(Color.RED);
            vh2.itemView.setTag(dailyData);
            vh2.recyclerItemTv.setText(dailyData.getDivision()+":"+dailyData.getSales());
        }else if(dailyData.getDivision().equals(DailyData.divisionPurchase)){
            vh2.itemView.setBackgroundColor(Color.BLUE);
            vh2.itemView.setTag(dailyData);
            vh2.recyclerItemTv.setText(dailyData.getDivision()+":"+dailyData.getSales());
        }
    }

    public View getPreItemView(){
        return preItemView;
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class VH2 extends RecyclerView.ViewHolder{

        TextView recyclerItemTv;
        ArrayList<DailyData> holderDataList;
        View itemView;

        public VH2(View itemView, ArrayList<DailyData> dataList) {
            super(itemView);
            this.itemView=itemView;
            itemView.setClickable(true);
            itemView.setOnClickListener(onClickListener);
            holderDataList=dataList;
            init(itemView);
        }

        private void init(View itemView){
            recyclerItemTv=itemView.findViewById(R.id.recycler_item_tv);
        }

        View.OnClickListener onClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(preItemView!=null){
                    DailyData dailyData=(DailyData) preItemView.getTag();
                    switch (dailyData.getDivision()){
                        case DailyData.divisionSales:
                            preItemView.setBackgroundColor(Color.RED);
                            break;
                        case DailyData.divisionPurchase:
                            preItemView.setBackgroundColor(Color.BLUE);
                            break;
                    }
                    view.setBackgroundColor(Color.LTGRAY);
                    preItemView=view;
                    FragmentDaily.setPreItemView(preItemView);
                }else if(preItemView==null){
                    view.setBackgroundColor(Color.LTGRAY);
                    preItemView=view;
                    FragmentDaily.setPreItemView(preItemView);
                }
            }
        };
    }
}
