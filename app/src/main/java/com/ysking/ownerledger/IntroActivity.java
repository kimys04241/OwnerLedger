package com.ysking.ownerledger;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.ysking.ownerledger.user.information.AppFristRun;
import com.ysking.ownerledger.user.information.RegistUserInfo;
import com.ysking.ownerledger.user.information.UserInformation;

import java.util.Timer;
import java.util.TimerTask;

public class IntroActivity extends AppCompatActivity {

    ImageView ivLogo;
    Timer timer=new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        ivLogo=findViewById(R.id.iv_logo);
        Animation aniLogo= AnimationUtils.loadAnimation(this, R.anim.ani_logo);
        ivLogo.startAnimation(aniLogo);

        timer.schedule(task, 4000);
    }

    TimerTask task=new TimerTask() {
        @Override
        public void run() {
            RegistUserInfo registUserInfo=new RegistUserInfo(IntroActivity.this);
            registUserInfo.loadInfo();

            if(UserInformation.getIsIsFirstRun()){
                Intent intent=new Intent(IntroActivity.this, AppFristRun.class);
                startActivity(intent);
            }else{
                Intent intent=new Intent(IntroActivity.this, MainActivity.class);
                startActivity(intent);
            }
            finish();
            
        }
    };

}
