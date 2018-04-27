package com.ysking.ownerledger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

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
            Intent intent=new Intent(IntroActivity.this, AppFristRun.class);
            startActivity(intent);

            finish();
        }
    };
}
