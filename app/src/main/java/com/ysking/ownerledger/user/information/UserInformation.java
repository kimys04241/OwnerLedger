package com.ysking.ownerledger.user.information;

/**
 * Created by alfo06-25 on 2018-04-27.
 */

public class UserInformation {
    private static String nickname;
    private static String password;
    private static boolean isFirstRun;

    public static String getNickname() {
        return nickname;
    }

    public static void setNickname(String nickname) {
        UserInformation.nickname = nickname;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        UserInformation.password = password;
    }

    public static boolean getIsIsFirstRun() {
        return isFirstRun;
    }

    public static void setIsFirstRun(boolean isFirstRun) {
        UserInformation.isFirstRun = isFirstRun;
    }
}
