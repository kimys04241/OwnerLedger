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

    public static int cursorNull=0;
    public static int cursorNotNull=1;

    ArrayList<DailyData> dataList;

    public DailyDB(Context context) {
        this.context = context;
        db=context.openOrCreateDatabase(dbName, Context.MODE_PRIVATE, null);

    }

    public void createTable(String date){

        tableName=tableNameTransfer(date);
        db.execSQL("CREATE TABLE if not exists "+tableName+"(no integer primary key autoincrement,division text not null,sales text,category text,classification text," +
                "connection text,memo text);");
    }

    public void insertData(DailyData dailyData){
        db.execSQL("insert into "+tableName+"(division,sales,category,classification,connection,memo) values('"
                +dailyData.getDivision()+"','"+dailyData.getSales()
                +"','"+dailyData.getCategory()+"','"+dailyData.getClassification()
                +"','"+dailyData.getConnection()+"','"+dailyData.getMemo()+"')");
    }

    public int selectByTableName(String date){

        tableName=tableNameTransfer(date);

        Cursor cursor=db.rawQuery("select * from "+tableName, null);
        if(cursor==null) return cursorNull;
        int cnt=cursor.getCount();

        dataList=new ArrayList<>();
        while (cursor.moveToNext()){
            dataList.add(new DailyData(cursor.getInt(0), date, cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6)));
        }
        return cursorNotNull;
    }

    public ArrayList<DailyData> getDataList(){
     return dataList;
    }

    public String tableNameTransfer(String date){
        String[] split=date.split("-");
        return "table_"+split[0]+"_"+split[1]+"_"+split[2];
    }

}
