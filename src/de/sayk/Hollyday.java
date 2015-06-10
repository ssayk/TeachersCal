package de.sayk;
/**
 * File         Hollyday.java
 *
 * Created      18.07.2011, 09:09:04
 * Last Update  18.07.2011, 09:09:04
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
public class Hollyday
{
    public String description;
    public Date   from;
    public Date   to;

    public Hollyday( Date from, Date to, String desc )
    {
        this.from = from;
        this.to = to;
        this.description = desc;
    }

}
