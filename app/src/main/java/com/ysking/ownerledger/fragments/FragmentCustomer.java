package com.ysking.ownerledger.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ysking.ownerledger.R;
import com.ysking.ownerledger.activitys.AddCustomer;
import com.ysking.ownerledger.adapter.AdapterCustomer;
import com.ysking.ownerledger.database.CustomerDB;

/**
 * Created by alfo06-25 on 2018-05-01.
 */

public class FragmentCustomer extends Fragment {


    View view;

    RecyclerView recyclerView;
    AdapterCustomer adapterCustomer;

    ImageView btnAdd;

    CustomerDB db;
    String[][] readResult;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_customer, container, false);
        this.view=view;

        db=new CustomerDB(view.getContext());
        apllyDB();

        recyclerView=view.findViewById(R.id.recycler);
        adapterCustomer=new AdapterCustomer(view.getContext(), readResult);
        recyclerView.setAdapter(adapterCustomer);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        btnAdd=view.findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(addBtnlistener);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        apllyDB();
        //adapterCustomer.notifyDataSetChanged();
        adapterCustomer=new AdapterCustomer(view.getContext(), readResult);
        recyclerView.setAdapter(adapterCustomer);
    }

    View.OnClickListener addBtnlistener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(view.getContext(), AddCustomer.class);
            startActivity(intent);
        }
    };

    public void apllyDB(){
        db.readAllDB();
        readResult=db.getReadResult();
    }



}
