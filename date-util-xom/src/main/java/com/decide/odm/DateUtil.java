package com.decide.odm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyy-MM-dd");

    public static long getDaysBetween(Date d1, Date d2) {
        LocalDate local1 = d1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate local2 = d2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return ChronoUnit.DAYS.between(local1, local2);
    }

    public static Date getDateOfToday() {
        return Calendar.getInstance().getTime();
    }

    public static String getDateAsString(Date d) {
        return FORMAT.format(d);
    }

    public static Date getDateFromString(String str) throws ParseException {
        return FORMAT.parse(str);
    }

    public static Date addDays(Date d, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return calendar.getTime();
    }

    public static void main(String[] args) throws ParseException {
        Date d1 = DateUtil.getDateFromString("2021-09-01");
        Date d2 = DateUtil.getDateFromString("2021-09-28");
        System.out.println(getDateAsString(d1) + " + 5 days = " + getDateAsString(addDays(d1, 5)));
        System.out.println(
                "days between " + getDateAsString(d1) + " and " + getDateAsString(d2) + " = " + getDaysBetween(d1, d2));

    }

}
