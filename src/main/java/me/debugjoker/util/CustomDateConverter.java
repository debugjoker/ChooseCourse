package me.debugjoker.util;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CustomDateConverter implements Converter<String,Date> {

    public Date convert(String s) {
        System.out.println("s = " + s);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        try{
            Date date = simpleDateFormat.parse(s);
            System.out.println("date = " + date);
            String aDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            System.out.println("aDate = " + aDate);
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(aDate);
        }catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }
}
