package com.nyxtech.capthis.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;


/**
 * Created by varoqua on 1/10/16.
 */
public class Tools {

    public static String getIsoDateTime() {
        DateTime dateTime = new DateTime(DateTimeZone.UTC);
        DateTimeFormatter formatter = ISODateTimeFormat.dateTime();
        return formatter.print(dateTime);
    }

}
