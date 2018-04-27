package com.ysking.ownerledger;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AppFristRun extends AppCompatActivity {

    private boolean inputAllClear=false;
    private boolean nicknameError=false;
    private boolean passwordError=false;

    private EditText editNickname;
    private EditText editPassword;
    private EditText editPasswordCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_frist_run);

        editNickname=findViewById(R.id.edit_nickname);
        editPassword=findViewById(R.id.edit_password);
        editPasswordCheck=findViewById(R.id.edit_passwordcheck);
    }

    public void clickCancel(View v){
        finish();
    }

    public void clickSummit(View v){

        errorCheck();
        if(inputAllClear){
            registUserInformation(editNickname.getText().toString(), editPassword.getText().toString());
            Intent intent=new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }else{
            if(nicknameError){
                new AlertDialog.Builder(this).setMessage(R.string.nickname_error).setPositiveButton("확인", null).create().show();
                editNickname.setText("");
            }else if(passwordError){
                new AlertDialog.Builder(this).setMessage(R.string.password_error).setPositiveButton("확인", null).create().show();
                editPassword.setText("");
                editPasswordCheck.setText("");
            }
        }

    }

    public void errorCheck(){
        if(editNickname.getText().length()>0){
            //TODO 서버의 닉네임 중복체크
            nicknameError=false;

            if(editPassword.getText().length()>=4 && editPasswordCheck.getText().length()>=4){
                if(editPassword.getText().toString().equals(editPasswordCheck.getText().toString())){
                    passwordError=false;
                    inputAllClear=true;
                }else{
                    passwordError=true;
                    inputAllClear=false;
                }
            }else{
                passwordError=true;
                inputAllClear=false;
            }
        }else{
            nicknameError=true;
            inputAllClear=false;
        }
    }

    private void registUserInformation(String nickname, String password){
        int finalPassword=Integer.parseInt(password);
    }
}
