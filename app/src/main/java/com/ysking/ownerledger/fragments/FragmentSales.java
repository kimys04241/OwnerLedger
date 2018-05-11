package com.ysking.ownerledger.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputType;
import android.text.method.KeyListener;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ysking.ownerledger.R;
import com.ysking.ownerledger.activitys.ActivityAddDaily;

/**
 * Created by alfo06-25 on 2018-05-08.
 */

public class FragmentSales extends Fragment{

    EditText editSales;
    EditText editCategory;
    EditText editClassification;
    EditText editConnection;
    EditText editMemo;
    Button btnCheck;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_sales, container, false);
        editSales=view.findViewById(R.id.edit_sales);
        //editSales.setKeyListener(keyListener);
        editCategory=view.findViewById(R.id.edit_sales_category);
        editClassification=view.findViewById(R.id.edit_sales_classification);
        editConnection=view.findViewById(R.id.edit_sales_connection);
        editMemo=view.findViewById(R.id.edit_sales_memo);
        btnCheck=view.findViewById(R.id.btn_fragment_sales_check);
        btnCheck.setOnClickListener(onClickListener);

        return view;
    }





//    KeyListener keyListener=new KeyListener() {
//        @Override
//        public int getInputType() {
//            return InputType.TYPE_NUMBER_VARIATION_NORMAL;
//        }
//
//        @Override
//        public boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
//            return false;
//        }
//
//        @Override
//        public boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyEvent) {
//            if(i%5==0){
//                EditText editText=(EditText)view;
//                String com=editText.getText().toString();
//                com="."+com;
//            }
//            return false;
//        }
//
//        @Override
//        public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
//            return false;
//        }
//
//        @Override
//        public void clearMetaKeyState(View view, Editable editable, int i) {
//
//        }
//};

    View.OnClickListener onClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            clearEdit();
            passValues();
        }
    };

    public void passValues(){
        String[] values={editSales.getText().toString(), editCategory.getText().toString(), editClassification.getText().toString(),
                editConnection.getText().toString(), editMemo.getText().toString()};
        ActivityAddDaily activityAddDaily=(ActivityAddDaily) getActivity();
        activityAddDaily.setValues(values);
        activityAddDaily.finish();
    }

    public void clearEdit(){
        editSales.setText("");
        editCategory.setText("");
        editClassification.setText("");
        editConnection.setText("");
        editMemo.setText("");
    }

}
