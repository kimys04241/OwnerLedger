package com.ysking.ownerledger.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ysking.ownerledger.R;
import com.ysking.ownerledger.activitys.AddCustomer;

/**
 * Created by alfo06-25 on 2018-05-01.
 */

public class FragmentCustomer extends Fragment {

    ImageView btnAdd;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_customer, container, false);
        btnAdd=view.findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(onClickListener);
        return view;
    }

    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(view.getContext(), AddCustomer.class);
            startActivity(intent);
        }
    };
}
