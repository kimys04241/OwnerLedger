package com.ysking.ownerledger.activitys;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ysking.ownerledger.R;
import com.ysking.ownerledger.error.ErrorChecker;
import com.ysking.ownerledger.user.information.UserInformation;

public class ActivityBackup extends AppCompatActivity {


    String[] tempPassword=new String[4];
    int cnt=0;

    Button[] btnArr=new Button[10];
    Button btnCancle;
    Button btnDelete;

    ImageView iv1;
    ImageView iv2;
    ImageView iv3;
    ImageView iv4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backup);

        initContent();
    }

    private void initContent(){
        for(int i=0; i<btnArr.length; i++){
            btnArr[i]=findViewById(R.id.num0+i);
            btnArr[i].setOnClickListener(numClickListener);
        }
        btnCancle=findViewById(R.id.cancel);
        btnDelete=findViewById(R.id.delete);
        btnCancle.setOnClickListener(cancelClickListener);
        btnDelete.setOnClickListener(deleteClickListener);
        iv1=findViewById(R.id.iv_1);
        iv2=findViewById(R.id.iv_2);
        iv3=findViewById(R.id.iv_3);
        iv4=findViewById(R.id.iv_4);
    }

    private void clickNumBtn(int no){
        if(cnt==1){
            iv1.setBackgroundColor(Color.BLACK);
            tempPassword[0]=no+"";
        }else if(cnt==2){
            iv2.setBackgroundColor(Color.BLACK);
            tempPassword[1]=tempPassword[0]+no;
        }else if(cnt==3){
            iv3.setBackgroundColor(Color.BLACK);
            tempPassword[2]=tempPassword[1]+no;
        }else if(cnt==4){
            iv4.setBackgroundColor(Color.BLACK);
            tempPassword[3]=tempPassword[2]+no;
            if(UserInformation.getPassword().equals(tempPassword[3])){
                finish();
            }else{
                iv4.setBackgroundColor(Color.BLACK);
                Toast.makeText(this, "비밀번호 오류", Toast.LENGTH_SHORT).show();
                iv1.setBackgroundColor(Color.WHITE);
                iv2.setBackgroundColor(Color.WHITE);
                iv3.setBackgroundColor(Color.WHITE);
                iv4.setBackgroundColor(Color.WHITE);
                tempPassword=new String[4];
                cnt=0;
            }
        }
        Log.i("TAG", "비밀번호0번방"+tempPassword[0]);
        Log.i("TAG", "비밀번호1번방"+tempPassword[1]);
        Log.i("TAG", "비밀번호2번방"+tempPassword[2]);
        Log.i("TAG", "비밀번호3번방"+tempPassword[3]);
    }

    private void clickDeleteBtn(){
        if(cnt<=0) return;
        else if(cnt<=1) iv1.setBackgroundColor(Color.WHITE);
        else if(cnt<=2) iv2.setBackgroundColor(Color.WHITE);
        else if(cnt<=3) iv2.setBackgroundColor(Color.WHITE);
        else if(cnt<=4) iv2.setBackgroundColor(Color.WHITE);
        cnt--;
        tempPassword[cnt]="";

    }

    private void clickCancelBtn(){
        iv1.setBackgroundColor(Color.WHITE);
        iv2.setBackgroundColor(Color.WHITE);
        iv3.setBackgroundColor(Color.WHITE);
        iv4.setBackgroundColor(Color.WHITE);
        cnt=0;
        tempPassword=new String[4];
    }

    private View.OnClickListener numClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id=view.getId();
            Log.i("TAG", "들어옴");
            switch (id){
                case R.id.num0:
                    cnt++;
                    clickNumBtn(0);
                    break;
                case R.id.num1:
                    cnt++;
                    clickNumBtn(1);
                    break;
                case R.id.num2:
                    cnt++;
                    clickNumBtn(2);
                    break;
                case R.id.num3:
                    cnt++;
                    clickNumBtn(3);
                    break;
                case R.id.num4:
                    cnt++;
                    clickNumBtn(4);
                    break;
                case R.id.num5:
                    cnt++;
                    clickNumBtn(5);
                    break;
                case R.id.num6:
                    cnt++;
                    clickNumBtn(6);
                    break;
                case R.id.num7:
                    cnt++;
                    clickNumBtn(7);
                    break;
                case R.id.num8:
                    cnt++;
                    clickNumBtn(8);
                    break;
                case R.id.num9:
                    cnt++;
                    clickNumBtn(9);
                    break;
            }
        }
    };

    private View.OnClickListener cancelClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            clickCancelBtn();
        }
    };

    private View.OnClickListener deleteClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            clickDeleteBtn();
        }
    };



}
