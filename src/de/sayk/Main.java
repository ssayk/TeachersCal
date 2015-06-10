package de.sayk;

/**
 * File         Main.java
 *
 * Created      15.07.2011, 16:15:23
 * Last Update  15.07.2011, 16:15:23
 * --------------------------------------------------
 * History:
 * $Log$
 *
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

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
public class Main
{
    public static void main( String[] args ) throws ScriptException, FileNotFoundException
    {
        // Set username and password from command-line arguments.
        if ( args.length != 2 )
        {
            usage();
            return;
        }

        String uname = args[0];//sayk.stefan@googlemail.com
        String upassword = args[1];

        ScriptEngine engine = new ScriptEngineManager().getEngineByName( "JavaScript" );
        engine.eval( new InputStreamReader( new FileInputStream("./init.js" ) ) );

        String calendarname = engine.get( "calendarname" ) + "";
        String startdate = engine.get( "startdate" ) + "";
        String enddate = engine.get( "enddate" ) + "";

        System.out.println( "connecting google services..." );
        System.out.println( uname + ", #######" );
        CalendarService cs = GoogleCal.getService( uname, upassword );
        CalendarEntry entry = GoogleCal.buildCalendar( cs, calendarname );

        Calendar c = new Calendar( cs, entry, startdate, enddate );
        c.makeAppointments();

    }

    /**
     * Prints the command line usage of this sample application.
     */
    private static void usage()
    {
        System.out.println( "Syntax: Main <username> <password>" );
        System.out.println( "\nThe username and password are used for " + "authentication to your google account!"
                            + "\nPlease make sure that this JavaScript file init.js is in the same directory." );
    }

}
