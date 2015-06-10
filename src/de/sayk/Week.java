package de.sayk;
/**
 * File         Week.java
 *
 * Created      15.07.2011, 14:50:02
 * Last Update  15.07.2011, 14:50:02
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
public class Week
{
    public Day[] days = new Day[7];

    public Week()
    {
        for ( int i = 0; i < 7; i++ )
        {
            days[i] = new Day();
        }
    }
}
