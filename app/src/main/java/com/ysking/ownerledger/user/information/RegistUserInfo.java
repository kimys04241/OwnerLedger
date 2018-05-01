package com.ysking.ownerledger.user.information;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by alfo06-25 on 2018-05-01.
 */

public class RegistUserInfo {
    Context context;

    public RegistUserInfo(Context context) {
        this.context = context;
    }

    public void registInfo(String nickname, String password, boolean isFirstRun){
        SharedPreferences pref=context.getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putString("Nickname", nickname);
        editor.putString("Password", password);
        editor.putBoolean("IsFirstRun", isFirstRun);
        editor.apply();
    }

    public void loadInfo(){
        SharedPreferences pref=context.getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        UserInformation.setNickname(pref.getString("Nickname", "이름없음"));
        UserInformation.setPassword(pref.getString("Password", "비밀번호없음"));
        UserInformation.setIsFirstRun(pref.getBoolean("IsFirstRun", true));
    }
}
