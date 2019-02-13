package br.com.home.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ApplicationUtil {

    public static Date toDate(String date) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(String.format("%s-%s: %s", "ApplicationUtil", "toDate",
                    "Nao foi possivel converter a string de data informada em um objeto java.util.Date."));
        }
    }

    public static Calendar toCalendar(String date) {
        try {
            Date objectdate = new SimpleDateFormat("dd/MM/yyyy").parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(objectdate);
            return calendar;
        } catch (ParseException e) {
            throw new RuntimeException(String.format("%s-%s: %s", "ApplicationUtil", "toCalendar",
                    "Nao foi possivel converter a string de data informada em um objeto java.util.Calendar."));
        }
    }

    public static java.sql.Date toSqlDate(Calendar calendar) {
        return new java.sql.Date(calendar.getTimeInMillis());
    }

    public static Calendar toCalendar(java.sql.Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime());
        return calendar;
    }

    public static Integer toInteger(String number) {
        Integer numero = 0;
        try {
            numero = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.out.println("Nao foi possivel converter a string em um numero inteiro.");
        }
        return numero;
    }

    public static java.sql.Date toSqlDate(Date datafinalizacao) {
        if (datafinalizacao == null) {
            return null;
        }
        return new java.sql.Date(datafinalizacao.getTime());
    }

    public static Date toDate(java.sql.Date sqldate) {
        if (sqldate == null) {
            return null;
        }
        return new Date(sqldate.getTime());
    }
}
