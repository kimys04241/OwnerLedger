package com.ysking.ownerledger.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ysking.ownerledger.R;



/**
 * Created by alfo06-25 on 2018-05-02.
 */

public class AdapterCustomer extends RecyclerView.Adapter {

    Context context;
    String[][] readResult;

    private boolean headrFlag=false;

    private static TextView preTv;
    private static View preView;

    public AdapterCustomer(Context context, String[][] readResult) {
        this.context = context;
        this.readResult=readResult;
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
        vh.tvNo.setText(readResult[position-1][0]);
        vh.tvName.setText(readResult[position-1][1]);
        vh.tvPhone.setText(readResult[position-1][2]);
        vh.tvBirth.setText(readResult[position-1][3]);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return readResult.length+1;
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
