package com.teamOne.cs631.util;

import java.sql.Date;
import java.time.LocalDate;

public class DateUtils {
    public static LocalDate getLocalDate(Date date) {
        return date.toLocalDate();

    }

    public static Date getDate(LocalDate localDate) {
        return java.sql.Date.valueOf(localDate);
    }
}
