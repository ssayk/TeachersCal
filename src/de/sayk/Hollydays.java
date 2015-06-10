package de.sayk;
/**
 * File         Hollydays.java
 *
 * Created      18.07.2011, 09:08:27
 * Last Update  18.07.2011, 09:08:27
 * --------------------------------------------------
 * History:
 * $Log$
 *
 */


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

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
public class Hollydays
{
    private static Vector<Hollyday> days = new Vector<Hollyday>();

    public static void addEntry( String from, String desc )
    {
    	addEntry(from, from ,desc);
    }

    	public static void addEntry( String from, String to, String desc )
    {
        try
        {
            DateFormat df = new SimpleDateFormat( "dd.MM.yyyy hh:mm" );
            Date dfrom = df.parse( from + " 00:00" );
            Date dto = df.parse( to + " 23:59" );
            days.add( new Hollyday( dfrom, dto, desc ) );
        }
        catch( ParseException e )
        {
            e.printStackTrace();
        }

    }

    public static void addFixEntry( String from, String desc )
    {
        try
        {
            DateFormat df = new SimpleDateFormat( "dd.MM.yyyy hh:mm" );
            for ( int i = 11; i < 50; i++ )
            {
                Date dfrom = df.parse( from.substring( 0, 8 ) + i + " 00:00" );
                Date dto = df.parse( from.substring( 0, 8 ) + i + " 23:59" );
                days.add( new Hollyday( dfrom, dto, desc ) );
            }
        }
        catch( ParseException e )
        {
            e.printStackTrace();
        }

    }

    public static boolean isHollyday( Date day )
    {

        for ( Hollyday d : days )
        {
            if ( d.from.getTime() <= day.getTime() && day.getTime() <= d.to.getTime() )
                return true;
        }
        return false;
    }

}
