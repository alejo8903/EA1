package com.iud.ea1.util;

import java.time.LocalDate;
import java.util.Date;

public class UtilityMethods {

    public static LocalDate dateToLocaleDate(Date date) {
        return new java.sql.Date(date.getTime()).toLocalDate();
    }

    public static Date localDateToDate(LocalDate fechaNacimiento) {
        return java.sql.Date.valueOf(fechaNacimiento);
    }
}
