package com.ysking.ownerledger.user.information;

/**
 * Created by alfo06-25 on 2018-04-27.
 */

public class UserInformation {
    private static String nickname;
    private static int password;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
