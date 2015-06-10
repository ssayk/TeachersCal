package de.sayk;
/**
 * File         Appointment.java
 *
 * Created      18.07.2011, 13:42:48
 * Last Update  18.07.2011, 13:42:48
 * --------------------------------------------------
 * History:
 * $Log$
 *
 */


import java.util.Date;

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
public class Appointment
{
    public String title;
    public Date   from;
    public Date   to;
    public String location;
    public String description;

    public Appointment( String title, Date from, Date to, String location )
    {
        this.title = title;
        this.from = from;
        this.to = to;
        this.location = location;
    }

    public String toString()
    {
        return title + " (" + from + ",  " + to + ", " + location + ")";
    }

}
