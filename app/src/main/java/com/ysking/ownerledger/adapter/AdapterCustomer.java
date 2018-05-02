package com.ysking.ownerledger.adapter;

import android.content.Context;
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

    public AdapterCustomer(Context context, String[][] readResult) {
        this.context = context;
        this.readResult=readResult;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View itemView=inflater.inflate(R.layout.recycler_item_inside_customer_fragment, parent, false);
        VH holder=new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        VH vh=(VH)holder;
        vh.tvNo.setText(readResult[position][0]);
        vh.tvName.setText(readResult[position][1]);
        vh.tvPhone.setText(readResult[position][2]);
        vh.tvBirth.setText(readResult[position][3]);
    }

    @Override
    public int getItemCount() {
        return readResult.length;
    }

    class VH extends RecyclerView.ViewHolder{

        TextView tvNo;
        TextView tvName;
        TextView tvBirth;
        TextView tvPhone;


        public VH(View itemView) {
            super(itemView);

            tvNo=itemView.findViewById(R.id.tv_no);
            tvName=itemView.findViewById(R.id.tv_name);
            tvBirth=itemView.findViewById(R.id.tv_birth);
            tvPhone=itemView.findViewById(R.id.tv_phone);
        }
    }
}
