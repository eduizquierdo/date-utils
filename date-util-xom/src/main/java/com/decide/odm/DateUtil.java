package com.decide.odm;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static long DaysBetween(Date d1, Date d2) {
        LocalDate local1 = d1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate local2 = d2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return ChronoUnit.DAYS.between(local1, local2);
    }

    public static Date getDateOfToday() {
        return Calendar.getInstance().getTime();
    }

}
