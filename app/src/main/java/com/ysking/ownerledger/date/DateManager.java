package com.ysking.ownerledger.date;

public class DateManager {

    private static String today;
    private static String checkedDate;

    public static int[] getToday() {
        String[] todaySplit=today.split("-");
        int[] todayInt={Integer.parseInt(todaySplit[0]), Integer.parseInt(todaySplit[1]), Integer.parseInt(todaySplit[2])};
        return todayInt;
    }

    public static void setToday(String today) {
        DateManager.today = today;
    }

    public static int[] getCheckedDate() {
        String[] checkedDateSplit=checkedDate.split("-");
        int[] checkDateSplit={Integer.parseInt(checkedDateSplit[0]), Integer.parseInt(checkedDateSplit[1]), Integer.parseInt(checkedDateSplit[2])};
        return checkDateSplit;
    }

    public static void setChcekedDate(String chcekedDate) {
        DateManager.checkedDate = chcekedDate;
    }


}
