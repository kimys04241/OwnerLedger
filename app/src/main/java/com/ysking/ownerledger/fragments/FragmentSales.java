package com.ysking.ownerledger.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ysking.ownerledger.R;

/**
 * Created by alfo06-25 on 2018-05-08.
 */

public class FragmentSales extends Fragment{

    EditText editSales;
    EditText editCategory;
    EditText editClassification;
    EditText editConnection;
    EditText editMemo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_sales, container, false);
        editSales=view.findViewById(R.id.edit_sales);
        editCategory=view.findViewById(R.id.edit_sales_category);
        editClassification=view.findViewById(R.id.edit_sales_classification);
        editConnection=view.findViewById(R.id.edit_sales_connection);
        editMemo=view.findViewById(R.id.edit_sales_memo);

        return view;
    }
}
