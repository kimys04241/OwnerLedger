package com.ysking.ownerledger.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ysking.ownerledger.R;
import com.ysking.ownerledger.activitys.AddCustomer;
import com.ysking.ownerledger.database.CustomerDB;

/**
 * Created by alfo06-25 on 2018-05-01.
 */

public class FragmentCustomer extends Fragment {

    View view;

    TextView tvTest;
    ImageView btnAdd;

    CustomerDB db;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_customer, container, false);
        this.view=view;
        db=new CustomerDB(view.getContext());
        tvTest=view.findViewById(R.id.tv_test);
        btnAdd=view.findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(addBtnlistener);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        apllyDB();
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
        String readResult=db.getReadResult();
        if(readResult!=null) Toast.makeText(view.getContext(), readResult, Toast.LENGTH_SHORT).show();
            //tvTest.setText(readResult);
    }


}
