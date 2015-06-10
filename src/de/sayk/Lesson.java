package de.sayk;
/**
 * File         Lesson.java
 *
 * Created      15.07.2011, 14:51:18
 * Last Update  15.07.2011, 14:51:18
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
public class Lesson
{

    public String title;
    public String roomNo;
    public String courseName;
    public String startTime;
    public String endTime;

    public Lesson( String title, String roomNo, String courseName, String startTime, String endTime )
    {
        this.title = title;
        this.roomNo = roomNo;
        this.courseName = courseName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

 

}
