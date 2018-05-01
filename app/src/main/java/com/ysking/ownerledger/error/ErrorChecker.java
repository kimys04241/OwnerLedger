package com.ysking.ownerledger.error;

/**
 * Created by alfo06-25 on 2018-05-01.
 */

public class ErrorChecker {

    public static final int nicknameError=1;
    public static final int passwordLengthError=2;
    public static final int passwordDiscord=3;
    public static final int allOk=4;

    public int check(String nickname, String password, String passwordCheck){
        if(nickname.length()<=0){
            return nicknameError;
        }else if(password.length()<4 || passwordCheck.length()<4){
            return passwordLengthError;
        }else if(!password.equals(passwordCheck)){
            return passwordDiscord;
        }else{
            return allOk;
        }
    }
}
