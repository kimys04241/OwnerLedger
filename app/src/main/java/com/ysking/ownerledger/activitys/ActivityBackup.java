package com.ysking.ownerledger.activitys;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.ysking.ownerledger.R;
import com.ysking.ownerledger.error.ErrorChecker;
import com.ysking.ownerledger.user.information.UserInformation;

public class ActivityBackup extends AppCompatActivity {

    EditText edit1;
    EditText edit2;
    EditText edit3;
    EditText edit4;
    InputMethodManager imm;

    TextView tv;

    final int MAX_LENGTH=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backup);

        edit1=findViewById(R.id.edit1);
        edit2=findViewById(R.id.edit2);
        edit3=findViewById(R.id.edit3);
        edit4=findViewById(R.id.edit4);
        tv=findViewById(R.id.tv);
        edit1.requestFocus();
        edit1.addTextChangedListener(textWatcher);
        edit2.addTextChangedListener(textWatcher);
        edit3.addTextChangedListener(textWatcher);
        edit4.addTextChangedListener(textWatcher);

        imm= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

    }

    TextWatcher textWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if(editable.length()==MAX_LENGTH){
                if(edit4.getText().toString().length()!=0){
                    View view = ActivityBackup.this.getCurrentFocus();
                    if (view != null) {
                        imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                        String password=edit1.getText().toString()+edit2.getText().toString()+edit3.getText().toString()+edit4.getText().toString();

                        if(UserInformation.getPassword().equals(password)){

                        }else{
                            tv.setVisibility(View.VISIBLE);
                            edit1.requestFocus();
                            edit1.setText("");
                            edit2.setText("");
                            edit3.setText("");
                            edit4.setText("");
                            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                        }


                    }
                }else if(edit3.getText().toString().length()!=0){
                    edit4.requestFocus();
                }else if(edit2.getText().toString().length()!=0){
                    edit3.requestFocus();
                }else if(edit1.getText().toString().length()!=0){
                    edit2.requestFocus();
                }
            }
        }
    };

    public void checkResult(int result){
        switch (result){
            case ErrorChecker.passwordMatch:

                break;
            case ErrorChecker.passwordMissMatch:
                tv.setVisibility(View.VISIBLE);
                edit1.requestFocus();
                edit1.setText("");
                edit2.setText("");
                edit3.setText("");
                edit4.setText("");
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                break;
        }
    }
}
