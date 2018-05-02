package com.ysking.ownerledger.activitys;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.ysking.ownerledger.MainActivity;
import com.ysking.ownerledger.R;
import com.ysking.ownerledger.database.CustomerDB;
import com.ysking.ownerledger.error.ErrorChecker;

public class AddCustomer extends AppCompatActivity {

    EditText editCustomerName;
    EditText editCustomerPhone;
    EditText editCustomerBirth;
    RadioGroup radioGroupGender;
    EditText editCustomerAddress;
    EditText editCustomerDetail;

    CustomerDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        editCustomerName=findViewById(R.id.edit_customer_name);
        editCustomerPhone=findViewById(R.id.edit_customer_phone);
        editCustomerBirth=findViewById(R.id.edit_customer_birth);
        radioGroupGender=findViewById(R.id.radio_group_gender);
        editCustomerAddress=findViewById(R.id.edit_customer_address);
        editCustomerDetail=findViewById(R.id.edit_customer_detail);

        db=new CustomerDB(this);

    }

    public void clickCancel(View v){
        new AlertDialog.Builder(this).setMessage(R.string.dialog_addcustomer_cancel_message).setPositiveButton("확인", onClickListener).setNegativeButton("취소", null).create().show();
    }

    public void clickSummit(View v){
        ErrorChecker errorChecker=new ErrorChecker();
        String customerName=editCustomerName.getText().toString();
        String customerPhone=editCustomerPhone.getText().toString();
        String customerBirth=editCustomerBirth.getText().toString();
        String customerGender=null;
        switch (radioGroupGender.getCheckedRadioButtonId()){
            case R.id.radio_button_male:
                customerGender="남성";
                break;
            case R.id.radio_button_female:
                customerGender="여성";
        }
        String customerAddress=editCustomerAddress.getText().toString();
        String customerDetail=editCustomerDetail.getText().toString();
        int result=errorChecker.checkCustomerRegist(customerName);

        switch (result){
            case ErrorChecker.customerNameError:
                new AlertDialog.Builder(this).setMessage(R.string.dialog_addcustomer_name_error).setPositiveButton("확인", null).create().show();
                break;
            case ErrorChecker.checkCustomerRegistOk:
                db.writeDB(customerName, customerPhone, customerBirth, customerGender, customerAddress, customerDetail);
                finish();
                break;
        }
    }

    DialogInterface.OnClickListener onClickListener=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int button) {

            switch (button){
                case Dialog.BUTTON_POSITIVE:
                    finish();
                    break;
            }
        }
    };
}
