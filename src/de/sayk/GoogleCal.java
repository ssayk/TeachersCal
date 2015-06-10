package de.sayk;
/**
 * File         GoogleCal.java
 *
 * Created      18.07.2011, 14:38:24
 * Last Update  18.07.2011, 14:38:24
 * --------------------------------------------------
 * History:
 * $Log$
 *
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collections;
import java.util.TimeZone;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.services.calendar.Calendar;

/**
* Demonstrates interactions with the Calendar data API's calendar feeds using
* the Java client library:
* 
* <ul>
* <li>Retrieving the metafeed list of all the user's calendars</li>
* <li>Retrieving the allcalendars list of calendars</li>
* <li>Retrieving the owncalendars list of calendars</li>
* <li>Creating a new calendar</li>
* <li>Updating an existing calendar</li>
* <li>Deleting a calendar</li>
* <li>Subscribing to an existing calendar</li>
* <li>Updating a subscription</li>
* <li>Deleting a subscription</li>
* </ul>
*/
public class GoogleCal
{

    // The base URL for a user's calendar metafeed (needs a username appended).
    private static final String METAFEED_URL_BASE            = "https://www.google.com/calendar/feeds/";

    // The string to add to the user's metafeedUrl to access the allcalendars
    // feed.
    private static final String ALLCALENDARS_FEED_URL_SUFFIX = "/allcalendars/full";

    // The string to add to the user's metafeedUrl to access the owncalendars
    // feed.
    private static final String OWNCALENDARS_FEED_URL_SUFFIX = "/owncalendars/full";

    // The string to add to the user's metafeedUrl to access the event feed for
    // their primary calendar.
    private static final String EVENT_FEED_URL_SUFFIX        = "/private/full";

    // The URL for the metafeed of the specified user.
    // (e.g. http://www.google.com/feeds/calendar/jdoe@gmail.com)
    private static URL          metafeedUrl                  = null;

    // The URL for the allcalendars feed of the specified user.
    // (e.g. http://www.googe.com/feeds/calendar/jdoe@gmail.com/allcalendars/full)
    private static URL          allcalendarsFeedUrl          = null;

    // The URL for the owncalendars feed of the specified user.
    // (e.g. http://www.googe.com/feeds/calendar/jdoe@gmail.com/owncalendars/full)
    private static URL          owncalendarsFeedUrl          = null;

    // The URL for the event feed of the specified user's primary calendar.
    // (e.g. http://www.googe.com/feeds/calendar/jdoe@gmail.com/private/full)
    private static URL          eventFeedUrl                 = null;

    // The calendar ID of the public Google Doodles calendar
    private static final String DOODLES_CALENDAR_ID          = "c4o4i7m2lbamc4k26sc2vokh5g%40group.calendar.google.com";

    // The HEX representation of red, blue and green
    private static final String RED                          = "#A32929";
    private static final String BLUE                         = "#2952A3";
    private static final String GREEN                        = "#0D7813";

    private static String       userName;

    /**
     * Utility classes should not have a public or default constructor.
     */
    protected GoogleCal()
    {
    }

    /**
     * Prints the titles of calendars in the feed specified by the given URL.
     * 
     * @param service An authenticated CalendarService object.
     * @param feedUrl The URL of a calendar feed to retrieve.
     * @throws IOException If there is a problem communicating with the server.
     * @throws ServiceException If the service is unable to handle the request.
     */
    private static void printUserCalendars( CalendarService service, URL feedUrl ) throws IOException, ServiceException
    {

        // Send the request and receive the response:
        CalendarFeed resultFeed = service.getFeed( feedUrl, CalendarFeed.class );

        // Print the title of each calendar
        for ( int i = 0; i < resultFeed.getEntries().size(); i++ )
        {
            CalendarEntry entry = resultFeed.getEntries().get( i );
            System.out.println( "\t" + entry.getTitle().getPlainText() );
        }
    }

    /**
     * Creates a new secondary calendar using the owncalendars feed.
     * 
     * @param service An authenticated CalendarService object.
     * @return The newly created calendar entry.
     * @throws IOException If there is a problem communicating with the server.
     * @throws ServiceException If the service is unable to handle the request.
     */
    private static CalendarEntry createCalendar( String title, Calendar service ) throws IOException, ServiceException
    {
        System.out.println( "Creating a secondary calendar" );

        // Create the calendar
        CalendarEntry calendar = new CalendarEntry();
        calendar.setTitle( new PlainTextConstruct( title ) );
        calendar.setSummary( new PlainTextConstruct( "Dieser Kalender wurde durch OSIS erstellt. Viel Spaß damit wünscht Stefan" ) );
        calendar.setTimeZone( new TimeZoneProperty( "Europe/Berlin" ) );
        calendar.setHidden( HiddenProperty.FALSE );
        calendar.setColor( new ColorProperty( BLUE ) );
        calendar.addLocation( new Where( "", "", "Melle" ) );

        // Insert the calendar
        return service.insert( owncalendarsFeedUrl, calendar );
    }

    /**
     * Updates the title, color, and selected properties of the given calendar
     * entry using the owncalendars feed. Note that the title can only be updated
     * with the owncalendars feed.
     * 
     * @param calendar The calendar entry to update.
     * @return The newly updated calendar entry.
     * @throws IOException If there is a problem communicating with the server.
     * @throws ServiceException If the service is unable to handle the request.
     */
    private static CalendarEntry updateCalendar( CalendarEntry calendar ) throws IOException, ServiceException
    {
        System.out.println( "Updating the secondary calendar" );

        calendar.setTitle( new PlainTextConstruct( "New title" ) );
        calendar.setColor( new ColorProperty( GREEN ) );
        calendar.setSelected( SelectedProperty.TRUE );
        return calendar.update();
    }

    /**
     * Deletes the given calendar entry.
     * 
     * @param calendar The calendar entry to delete.
     * @throws IOException If there is a problem communicating with the server.
     * @throws ServiceException If the service is unable to handle the request.
     */
    private static void deleteCalendar( CalendarEntry calendar ) throws IOException, ServiceException
    {
        System.out.println( "Deleting the secondary calendar" );

        calendar.delete();
    }

    /**
     * Subscribes to the public Google Doodles calendar using the allcalendars
     * feed.
     * 
     * @param service An authenticated CalendarService object.
     * @return The newly created calendar entry.
     * @throws IOException If there is a problem communicating with the server.
     * @throws ServiceException If the service is unable to handle the request.
     */
    private static CalendarEntry createSubscription( CalendarService service ) throws IOException, ServiceException
    {
        System.out.println( "Subscribing to the Google Doodles calendar" );

        CalendarEntry calendar = new CalendarEntry();
        calendar.setId( DOODLES_CALENDAR_ID );
        return service.insert( allcalendarsFeedUrl, calendar );
    }

    /**
     * Updated the color property of the given calendar entry.
     * 
     * @param calendar The calendar entry to update.
     * @return The newly updated calendar entry.
     * @throws IOException If there is a problem communicating with the server.
     * @throws ServiceException If the service is unable to handle the request.
     */
    private static CalendarEntry updateSubscription( CalendarEntry calendar ) throws IOException, ServiceException
    {
        System.out.println( "Updating the display color of the Doodles calendar" );

        calendar.setColor( new ColorProperty( RED ) );
        return calendar.update();
    }

    /**
     * Deletes the given calendar entry.
     * 
     * @param calendar The calendar entry to delete
     * @throws IOException If there is a problem communicating with the server.
     * @throws ServiceException If the service is unable to handle the request.
     */
    private static void deleteSubscription( CalendarEntry calendar ) throws IOException, ServiceException
    {
        System.out.println( "Deleting the subscription to the Doodles calendar" );

        calendar.delete();
    }

    public static Calendar getService( )
    {

	    HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
	    JacksonFactory jsonFactory = JacksonFactory.getDefaultInstance();

	    // The clientId and clientSecret can be found in Google Developers Console
	    String clientId = "677404751535-4nm0cnp672jr3rr0v0lub5imbqfv7jpp.apps.googleusercontent.com";
	    String clientSecret = "DlwxCdo1mSQyoXlD9knAFfs9";

	    // Or your redirect URL for web based applications.
	    String redirectUrl = "urn:ietf:wg:oauth:2.0:oob";
	    String scope = "https://www.googleapis.com/auth/calendar";

	    GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow(
	        httpTransport, jsonFactory, clientId, clientSecret, Collections.singleton(scope));
	    // Step 1: Authorize
	    String authorizationUrl = flow.newAuthorizationUrl().setRedirectUri(redirectUrl).build();

	    // Point or redirect your user to the authorizationUrl.
	    System.out.println("Go to the following link in your browser:");
	    System.out.println(authorizationUrl);

	    // Read the authorization code from the standard input stream.
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    System.out.println("What is the authorization code?");
	    String code = "4/Pe9R8PppPhYOXiLpFS2XQYWFAGghMc7JPI9O47GKyBo.MuXoBOl3yYkaoiIBeO6P2m8oQOKflgI";// in.readLine();
	    // End of Step 1

	    // Step 2: Exchange
	    GoogleTokenResponse response = flow.newTokenRequest(code).setRedirectUri(redirectUrl)
	        .execute();
	    // End of Step 2

	    Credential credential = new GoogleCredential.Builder()
	        .setTransport(httpTransport)
	        .setJsonFactory(jsonFactory)
	        .setClientSecrets(clientId, clientSecret)
	        .build().setFromTokenResponse(response);

	
	    
	    Calendar service = new Calendar.Builder(httpTransport, jsonFactory, credential)
        .setApplicationName("TeachersCal").build();

	    
            return service;

    }

    /**
     * Instantiates a CalendarService object and uses the command line arguments
     * to authenticate. The CalendarService object is used to demonstrate
     * interactions with the Calendar data API's calendar feeds.
     * 
     * @param args Must be length 2 and contain a valid username/password
     */
    public static CalendarEntry buildCalendar( CalendarService service, String title )
    {

        // Demonstrate retrieving various calendar feeds.
        try
        {
            System.out.println( "Calendars in metafeed" );
            printUserCalendars( service, metafeedUrl );
            System.out.println( "Calendars in allcalendars feed" );
            printUserCalendars( service, allcalendarsFeedUrl );
            System.out.println( "Calendars in owncalendars feed" );
            printUserCalendars( service, owncalendarsFeedUrl );

            // Send the request and receive the response:
            CalendarFeed resultFeed = service.getFeed( allcalendarsFeedUrl, CalendarFeed.class );
            CalendarEntry newCalendar = null;
            // Print the title of each calendar
            for ( int i = 0; i < resultFeed.getEntries().size(); i++ )
            {
                CalendarEntry entry = resultFeed.getEntries().get( i );
                if ( entry.getTitle().getPlainText().equals( title ) )
                    newCalendar = entry;
            }
            if ( newCalendar == null )
                newCalendar = createCalendar( title, service );

            return newCalendar;
        }
        catch( IOException e )
        {
            // Communications error
            System.err.println( "There was a problem communicating with the service." );
            e.printStackTrace();
        }
        catch( ServiceException e )
        {
            // Server side error
            System.err.println( "The server had a problem handling your request." );
            e.printStackTrace();
        }
        return null;
    }

    public static CalendarEventEntry buildEvent( CalendarService service, CalendarEntry entry, Appointment ap )
    {

        CalendarEventEntry myEntry = new CalendarEventEntry();

        myEntry.setTitle( new PlainTextConstruct( ap.title ) );
        myEntry.setContent( new PlainTextConstruct( ap.location ) );

        DateTime startTime = new DateTime( ap.from, TimeZone.getDefault() );
        DateTime endTime = new DateTime( ap.to, TimeZone.getDefault() );
        When eventTimes = new When();
        eventTimes.setStartTime( startTime );
        eventTimes.setEndTime( endTime );
        myEntry.addTime( eventTimes );

        // Send the request and receive the response:
        try
        {
            
            eventFeedUrl = new URL(entry.getLink("http://schemas.google.com/gCal/2005#eventFeed", null).getHref());

            return service.insert( eventFeedUrl, myEntry );
        }
        catch( IOException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch( ServiceException e )
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
