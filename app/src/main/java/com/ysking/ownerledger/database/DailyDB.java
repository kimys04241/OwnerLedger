package com.ysking.ownerledger.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ysking.ownerledger.dailydata.DailyData;
import com.ysking.ownerledger.date.DateManager;

import java.util.ArrayList;

/**
 * Created by alfo06-25 on 2018-05-09.
 */

public class DailyDB {

    Context context;

    String dbName="daily.db";
    String tableName;

    static SQLiteDatabase db;
    DailyData dailyData;


    public DailyDB(Context context) {
        this.context = context;
        db=context.openOrCreateDatabase(dbName, Context.MODE_PRIVATE, null);

    }

    public void createTable(){

        int[] checkedDate=DateManager.getCheckedDate();
        tableName=String.format("table_%d_%02d_%02d", checkedDate[0], checkedDate[1], checkedDate[2]);
        db.execSQL("CREATE TABLE if not exists "+tableName+"(no integer primary key autoincrement,division text not null,sales text,category text,classification text," +
                "connection text,memo text);");
    }

    public void insertTable(String division, String[] values){
        db.execSQL("insert into "+tableName+"(division,sales,category,classification,connection,memo) values('"+division+"','"+values[0]+"','"+values[1]+"','"+values[2]
                +"','"+values[3]+"','"+values[4]+"')");
    }

    public void selectByTableName(String date){

        String tableName=tableNameTransfer(date);

        Cursor cursor=db.rawQuery("select * from "+tableName, null);
        if(cursor==null) return;
        dailyData=new DailyData();

        int cnt=cursor.getCount();
        dailyData.setCnt(cnt);

        ArrayList<String[]> salesData=new ArrayList<>();
        ArrayList<String[]> purchaseData=new ArrayList<>();

        while (cursor.moveToNext()){
            String division=cursor.getString(1);
            switch (division){
                case "매출":
                    salesData.add(new String[]{cursor.getInt(0)+"", cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)});
                    break;
                case "매입":
                    purchaseData.add(new String[]{cursor.getInt(0)+"", cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)});
                    break;
            }
        }
        dailyData.setSalesData(salesData);
        dailyData.setPurchaseData(purchaseData);
    }

    public String tableNameTransfer(String date){
        String[] split=date.split("-");
        return "table_"+split[0]+"_"+split[1]+"_"+split[2];
    }

    public DailyData getDailyData() {
        return dailyData;
    }
}
