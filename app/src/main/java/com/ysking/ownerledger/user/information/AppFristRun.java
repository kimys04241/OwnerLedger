package com.ysking.ownerledger.user.information;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.SimpleMultiPartRequest;
import com.android.volley.toolbox.Volley;
import com.ysking.ownerledger.MainActivity;
import com.ysking.ownerledger.R;
import com.ysking.ownerledger.error.ErrorChecker;

public class AppFristRun extends AppCompatActivity {

    private EditText editNickname;
    private EditText editPassword;
    private EditText editPasswordCheck;
    private EditText editEmail;

    ErrorChecker errorChecker=new ErrorChecker();

    private final String serverUrl="http://kimys04241.dothome.co.kr/OwnerLedger/insertUser.php";
    
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_frist_run);

        editNickname=findViewById(R.id.edit_nickname);
        editPassword=findViewById(R.id.edit_password);
        editPasswordCheck=findViewById(R.id.edit_passwordcheck);
        editEmail=findViewById(R.id.edit_eamil);


    }

    public void clickCancel(View v){
        finish();
    }

    public void clickSummit(View v){
        String nickname=editNickname.getText().toString();
        String password=editPassword.getText().toString();
        String passwordCheck=editPasswordCheck.getText().toString();
        String email=editEmail.getText().toString();

        int checkResult=errorChecker.checkJoin(nickname, password, passwordCheck);
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
            case ErrorChecker.checkJoinOk:
                RegistUserInfo registUserInfo=new RegistUserInfo(this);
                registUserInfo.registInfo(nickname, password, false);
                registUserInfo.loadInfo();
                sendUserInfoToDB(nickname, password, email);
                break;
        }

    }

    public void sendUserInfoToDB(String nickName, String password, String email){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        SimpleMultiPartRequest multiPartRequest=getMultiPart();
        multiPartRequest.addStringParam("id", nickName);
        multiPartRequest.addStringParam("password", password);
        multiPartRequest.addStringParam("email", email);
        requestQueue.add(multiPartRequest);
    }

    private SimpleMultiPartRequest getMultiPart(){
        return new SimpleMultiPartRequest(Request.Method.POST, serverUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                new AlertDialog.Builder(AppFristRun.this).setMessage(response).setPositiveButton("확인",onClickListener).create().show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                new AlertDialog.Builder(AppFristRun.this).setMessage(error.getMessage()).setPositiveButton("확인",null).create().show();
            }
        });
    }

    DialogInterface.OnClickListener onClickListener=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent=new Intent(AppFristRun.this, MainActivity.class);
            startActivity(intent);
            fileList();
            finish();
        }
    };

}
