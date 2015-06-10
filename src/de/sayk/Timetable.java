package de.sayk;
/**
 * File         Timetable.java
 *
 * Created      15.07.2011, 14:49:49
 * Last Update  15.07.2011, 14:49:49
 * --------------------------------------------------
 * History:
 * $Log$
 *
 */


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
public class Timetable
{

    public static Week[] weeks = null;

    public static void add( int week, int day, String name, String room, String course, String from, String to )
    {
        if (weeks==null){
            weeks = new Week[2];
            weeks[0] = new Week();
            weeks[1] = new Week();
        }
        weeks[week].days[day].lessons.add( new Lesson( name, room, course, from, to ) );
    }

}
