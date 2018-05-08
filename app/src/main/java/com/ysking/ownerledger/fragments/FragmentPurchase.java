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

public class FragmentPurchase extends Fragment {

    EditText editPurchase;
    EditText editCategory;
    EditText editClassification;
    EditText editConnection;
    EditText editMemo;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_purchase, container, false);

        editPurchase=view.findViewById(R.id.edit_purchase);
        editCategory=view.findViewById(R.id.edit_purchase_category);
        editClassification=view.findViewById(R.id.edit_purchase_classification);
        editConnection=view.findViewById(R.id.edit_purchase_connection);
        editMemo=view.findViewById(R.id.edit_purchase_memo);

        return view;
    }
}
