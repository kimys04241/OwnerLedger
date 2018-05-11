package com.ysking.ownerledger.dailydata;

import java.util.ArrayList;

/**
 * Created by alfo06-25 on 2018-05-11.
 */

public class DailyData {

    int cnt;

    ArrayList<String[]> salesData;
    ArrayList<String[]> purchaseData;

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public ArrayList<String[]> getSalesData() {
        return salesData;
    }

    public void setSalesData(ArrayList<String[]> salesData) {
        this.salesData = salesData;
    }

    public ArrayList<String[]> getPurchaseData() {
        return purchaseData;
    }

    public void setPurchaseData(ArrayList<String[]> purchaseData) {
        this.purchaseData = purchaseData;
    }
}
