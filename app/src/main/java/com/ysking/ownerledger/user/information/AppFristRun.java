package com.ysking.ownerledger.user.information;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.ysking.ownerledger.MainActivity;
import com.ysking.ownerledger.R;
import com.ysking.ownerledger.error.ErrorChecker;

public class AppFristRun extends AppCompatActivity {

    private EditText editNickname;
    private EditText editPassword;
    private EditText editPasswordCheck;

    ErrorChecker errorChecker=new ErrorChecker();


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
        String nickname=editNickname.getText().toString();
        String password=editPassword.getText().toString();
        String passwordCheck=editPasswordCheck.getText().toString();

        int checkResult=errorChecker.check(nickname, password, passwordCheck);
        switch (checkResult){
            case ErrorChecker.nicknameError:
                new AlertDialog.Builder(this).setMessage(R.string.nickname_error).setPositiveButton("확인", null).create().show();
                break;
            case ErrorChecker.passwordLengthError:
                new AlertDialog.Builder(this).setMessage(R.string.password_error).setPositiveButton("확인", null).create().show();
                break;
            case ErrorChecker.passwordDiscord:
                new AlertDialog.Builder(this).setMessage(R.string.password_discord_error).setPositiveButton("확인", null).create().show();
                break;
            case ErrorChecker.allOk:
                RegistUserInfo registUserInfo=new RegistUserInfo(this);
                registUserInfo.registInfo(nickname, password, false);
                registUserInfo.loadInfo();
                Intent intent=new Intent(this, MainActivity.class);
                startActivity(intent);
                fileList();
                finish();
                break;
        }

    }
}
