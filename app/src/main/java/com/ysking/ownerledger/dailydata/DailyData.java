package com.ysking.ownerledger.dailydata;

import java.util.ArrayList;

/**
 * Created by alfo06-25 on 2018-05-11.
 */

public class DailyData {
    String date;

    int no;
    String division;
    String sales;
    String category;
    String classification;
    String connection;
    String memo;

    public static final String divisionSales="매출";
    public static final String divisionPurchase="매입";

    public DailyData(String date, String division, String sales, String category, String classification, String connection, String memo) {
        this.date = date;
        this.division = division;
        this.sales = sales;
        this.category = category;
        this.classification = classification;
        this.connection = connection;
        this.memo = memo;
    }

    public DailyData(int no, String date, String division, String sales, String category, String classification, String connection, String memo) {
        this.no=no;
        this.date = date;
        this.division = division;
        this.sales = sales;
        this.category = category;
        this.classification = classification;
        this.connection = connection;
        this.memo = memo;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
