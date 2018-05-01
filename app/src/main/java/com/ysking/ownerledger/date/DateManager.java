package com.ysking.ownerledger.date;

public class DateManager {

    private static String today;
    private static String chcekedDate;

    public static String getToday() {
        return today;
    }

    public static void setToday(String today) {
        DateManager.today = today;
    }

    public static String getChcekedDate() {
        return chcekedDate;
    }

    public static void setChcekedDate(String chcekedDate) {
        DateManager.chcekedDate = chcekedDate;
    }
}
