package com.ysking.ownerledger.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by alfo06-25 on 2018-05-02.
 */

public class CustomerDB {

    Context context;

    String customerName;
    String customerPhone;
    String customerBirth;
    String customerGender;
    String customerAddress;
    String customerDetail;

    String[][] readResult;

    private String dbName="customer.db";
    private String tableName="customer";

    boolean firstRead=true;

    SQLiteDatabase db;


    public CustomerDB(Context context) {
        this.context = context;

        db=context.openOrCreateDatabase(dbName, Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE if not exists "+tableName+"(no integer primary key autoincrement,name text not null,phone text,birth text,gender text,address text,detail text);");
    }

    public void writeDB(String customerName, String customerPhone, String customerBirth, String customerGender, String customerAddress, String customerDetail){
        db.execSQL("insert into "+tableName+"(name,phone,birth,gender,address,detail) values('"+customerName+"','"+customerPhone+"','"+customerBirth+"','"+customerGender+"','"
        +customerAddress+"','"+customerDetail+"')");
    }

    public void readAllDB(){
        Cursor cursor=db.rawQuery("select * from "+tableName, null);
        if(cursor==null) return;

        int cnt=cursor.getCount();
        //readResult=new String[cnt][7];
        

        while (cursor.moveToNext()){
            int a=1;
            int no=cursor.getInt(0);
            String name=cursor.getString(1);
            String phone=cursor.getString(2);
            String birth=cursor.getString(3);
            String gender=cursor.getString(4);
            String address=cursor.getString(5);
            String detail=cursor.getString(6);
            Log.i("NO", "NO:"+no);


//            for(int i=0; i<readResult[0].length; i++){
//                readResult[no-1][i]=cursor.getString(i);
//            }
        }
    }

    public void deleteByNo(int no){
//        for(int i=1; i<=readResult.length; i++){
//            db.execSQL("delete from "+tableName+" where no=?", new String[]{i+""});
//        }
        int cnt=0;
        if(readResult==null) return;
        db.execSQL("delete from "+tableName);
        readResult[no-1]=null;
        String[][] deleteResult=new String[readResult.length-1][7];
        for(int i=0; i<readResult.length; i++){
            if(readResult[i]==null) continue;
            for(int j=0; j<7; j++){
                deleteResult[cnt][j]=readResult[i][j];
                cnt++;
            }
        }
        readResult=deleteResult;
        for(int i=0; i<readResult.length; i++){
            writeDB(readResult[i][1], readResult[i][2], readResult[i][3], readResult[i][4], readResult[i][5], readResult[i][6]);
        }
    }

    public String[][] getReadResult() {
        return readResult;
    }
}
