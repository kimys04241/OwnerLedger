package com.ysking.ownerledger.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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

        readResult=new String[cnt][7];

        while (cursor.moveToNext()){
            int no=cursor.getInt(0);
            String name=cursor.getString(1);
            String phone=cursor.getString(2);
            String birth=cursor.getString(3);
            String gender=cursor.getString(4);
            String address=cursor.getString(5);
            String detail=cursor.getString(6);

            for(int i=0; i<readResult[0].length; i++){
                readResult[no-1][i]=cursor.getString(i);
            }

            //buffer.append(no+" "+name+" "+phone+" "+birth+" "+gender+" "+address+" "+detail+"\n");
        }
        //readResult=buffer.toString();

    }

    public String[][] getReadResult() {
        return readResult;
    }
}
