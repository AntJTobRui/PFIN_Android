package com.example.fin_android.controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyTools {

    public static int calculaEdad(Calendar fech){
        Calendar cal = Calendar.getInstance();
        int diferencia = cal.get(Calendar.YEAR) - fech.get(Calendar.YEAR);
        //System.out.println(cal.get(Calendar.YEAR) +"  "+ fech.get(Calendar.YEAR));
        // Si la diferencia de años es 0, no hay que restar nada
        // Si el año del dia de la fecha que yo paso es mayor que la actual, resto uno
        if (diferencia != 0 && (fech.get(Calendar.DAY_OF_YEAR) >= cal.get(Calendar.DAY_OF_YEAR))) {
            diferencia--;
        }
        return diferencia;
    }

    public static String gregorianCalendarToString(GregorianCalendar fecha){
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        return formatDate.format(fecha.getTime());
    }

    public static String gregorianCalendarToAmerican(GregorianCalendar fecha){
        SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
        return formatDate.format(fecha.getTime());
    }

    public static GregorianCalendar stringToGregorianCalendar(String fecha) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");
        GregorianCalendar gc = null;
        try {
            gc = dateToGregorianCalendar(formatDate.parse(fecha));
        } catch (ParseException ex) {
            //Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return gc;
    }

    public static GregorianCalendar dateToGregorianCalendar(Date fecha){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(fecha);
        return gc;
    }

    public static String dateToString(Date fecha){
        SimpleDateFormat sdm = new SimpleDateFormat("MM/dd/YYYY");
        return sdm.format(fecha);
    }

    public static Date stringToDate(String fecha){
        SimpleDateFormat sdm = new SimpleDateFormat("MM/dd/YYYY");
        try {
            return sdm.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(MyTools.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
