package com.ysking.ownerledger.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ysking.ownerledger.R;
import com.ysking.ownerledger.customerdata.CustomerData;

import java.util.ArrayList;


/**
 * Created by alfo06-25 on 2018-05-02.
 */

public class AdapterCustomer extends RecyclerView.Adapter {

    Context context;
    ArrayList<CustomerData> customerList;

    private boolean headrFlag=false;

    private static TextView preTv;
    private static View preView;

    public AdapterCustomer(Context context, ArrayList<CustomerData> customerList) {
        this.context = context;
        this.customerList=customerList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView;
        LayoutInflater inflater=LayoutInflater.from(context);
        if(viewType==0){
            headrFlag=true;
            itemView=inflater.inflate(R.layout.recycler_header_inside_customer_fragment, parent, false);
        }else{
            headrFlag=false;
            itemView=inflater.inflate(R.layout.recycler_item_inside_customer_fragment, parent, false);
        }

        VH holder=new VH(itemView);
        return holder;

//        LayoutInflater inflater=LayoutInflater.from(context);
//        View itemView=inflater.inflate(R.layout.recycler_item_inside_customer_fragment, parent, false);
//        VH holder=new VH(itemView);
//        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        VH vh=(VH)holder;

        if(!vh.isHeader){
            bodyBind(vh, position);
        }else{
            headerBind(vh);
        }
    }

    private void headerBind(VH vh){

    }

    private void bodyBind(VH vh, int position){
        CustomerData customer=customerList.get(position-1);
        vh.tvNo.setText(position+"");
        vh.tvName.setText(customer.getName());
        vh.tvPhone.setText(customer.getPhone());
        vh.tvBirth.setText(customer.getBirth());
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return customerList.size()+1;
    }

    public static View getPreView() {
        return preView;
    }

    public static TextView getPreTv() {
        return preTv;
    }

    class VH extends RecyclerView.ViewHolder{

        boolean isHeader=headrFlag;

        TextView tvNo;
        TextView tvName;
        TextView tvBirth;
        TextView tvPhone;



        public VH(View itemView) {
            super(itemView);

            if(!isHeader){
                init(itemView);
            }else{
                headerInit(itemView);
            }

        }

        private void headerInit(View itemView){

        }

        private void init(View itemView){
            itemView.setClickable(true);
            itemView.setOnClickListener(onClickListener);

            tvNo=itemView.findViewById(R.id.tv_no);
            tvName=itemView.findViewById(R.id.tv_name);
            tvBirth=itemView.findViewById(R.id.tv_birth);
            tvPhone=itemView.findViewById(R.id.tv_phone);
        }

        View.OnClickListener onClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(preTv!=null) preTv.setTextColor(Color.BLACK);
                preView=view;
                preTv=tvNo;
                tvNo.setTextColor(Color.RED);
            }
        };
    }
}
