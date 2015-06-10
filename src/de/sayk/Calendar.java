package de.sayk;
/**
 * File         Calendar.java
 *
 * Created      15.07.2011, 16:23:17
 * Last Update  15.07.2011, 16:23:17
 * --------------------------------------------------
 * History:
 * $Log$
 *
 */


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import com.google.gdata.client.calendar.CalendarService;
import com.google.gdata.data.calendar.CalendarEntry;

/**
 * TODO Class description <br>
 * <br>
 * Copyright:   Copyright (c) 2011 <br>
 * Company:     b-next Engineering GmbH <br>
 * Creator:     Stefan Sayk <br>
 *
 * @author      $Author:$, $Date:$
 * @version     $Revision:$
 */
public class Calendar
{
    CalendarService gService;
    CalendarEntry   gCal;
    Date            from;
    Date            to;

    public Calendar( CalendarService cs, CalendarEntry entry, String fromTxt, String toTxt )
    {

        this.gService = cs;
        this.gCal = entry;
        try
        {
            DateFormat df = new SimpleDateFormat( "dd.MM.yyyy hh:mm:ss" );
            from = df.parse( fromTxt + " 00:00:00" );
            to = df.parse( toTxt + " 00:00:00" );
        }
        catch( ParseException e )
        {
            e.printStackTrace();
        }

    }

    public void makeAppointments()
    {

        long faktor = 24 * 3600 * 1000;

        for ( long i = from.getTime() / faktor; i < to.getTime() / faktor; i++ )
        {
            Date d = new Date( i * faktor );

            System.out.println( !Hollydays.isHollyday( d ) ? d + ": hau rein." : d + ": leg dich hin." );
            if ( !Hollydays.isHollyday( d ) )
            {
                                for ( Appointment ap : getAppointments( d ) )
                                {
                                    System.out.println( ap );
                                    GoogleCal.buildEvent( gService, gCal, ap );
                                }
            }
        }

    }

    private ArrayList<Appointment> getAppointments( Date day )
    {
        ArrayList<Appointment> aps = new ArrayList<Appointment>();
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime( day );

        int week = gc.get( java.util.Calendar.WEEK_OF_YEAR );
        int i = week % 2 == 0 ? 0 : 1;

        int weekday = gc.get( java.util.Calendar.DAY_OF_WEEK );
        int j = weekday == 1 ? 6 : weekday - 2;

        try
        {
            DateFormat df = new SimpleDateFormat( "dd.MM.yyyy hh:mm" );
            String txtDate = df.format( day );
            for ( Lesson l : Timetable.weeks[i].days[j].lessons )
            {
                Date from = df.parse( txtDate.substring( 0, 11 ) + l.startTime );
                Date to = df.parse( txtDate.substring( 0, 11 ) + l.endTime );
                Appointment ap = new Appointment( l.title + " " + l.courseName, from, to, l.roomNo );
                aps.add( ap );
            }
        }
        catch( ParseException e )
        {
            e.printStackTrace();
        }

        return aps;
    }

}
