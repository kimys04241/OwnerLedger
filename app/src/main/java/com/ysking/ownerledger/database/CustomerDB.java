package com.ysking.ownerledger.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

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

    ArrayList<String[]> customerList=new ArrayList<>();


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
//        customerList.add(new String[]{customerName, customerPhone, customerBirth, customerGender, customerAddress, customerDetail});
    }

    public void readAllDB(){
        Cursor cursor=db.rawQuery("select * from "+tableName, null);
        if(cursor==null) return;
        customerList.clear();

        int cnt=cursor.getCount();


        while (cursor.moveToNext()){
            int no=cursor.getInt(0);
            String name=cursor.getString(1);
            String phone=cursor.getString(2);
            String birth=cursor.getString(3);
            String gender=cursor.getString(4);
            String address=cursor.getString(5);
            String detail=cursor.getString(6);


            customerList.add(new String[]{cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6)});


//            for(int i=0; i<readResult[0].length; i++){
//                readResult[no-1][i]=cursor.getString(i);
//            }
        }
    }

    public void deleteByNo(int no){
//        for(int i=1; i<=readResult.length; i++){
//            db.execSQL("delete from "+tableName+" where no=?", new String[]{i+""});
//        }

        db.execSQL("delete from "+tableName);
        customerList.remove(no-1);

        Cursor cursor=db.rawQuery("select * from "+tableName, null);
        if(cursor!=null) {
            Log.i("CNT", "CNT:"+cursor.getCount());
        }else{
            Log.i("CNT", "CNT:null");
        }

        for(int i=0; i<customerList.size(); i++){
            String[] customer=customerList.get(i);
            writeDB(customer[0], customer[1], customer[2], customer[3], customer[4], customer[5]);
        }
    }

    public ArrayList<String[]> getCustomerList() {
        return customerList;
    }
}
