importPackage(Packages.de.sayk);
calendarname = "BBS 2014/15 2.Halbjahr";
startdate    = "04.02.2015";
enddate      = "01.08.2015";

// hier deinen Stundenplan eingeben
//gerade Woche <erste Zahl = 0> Montag <zweite Zahl = 0, Mo-Sa 0-5>
//                    Fach     Raum    Klasse  von      bis  
//Dienstag
//Mittwoch
Timetable.add( 0, 2, "TME-3", "R517", "BGT13", "8:00", "9:30" );
Timetable.add( 0, 2, "LF9/11", "R517", "SME23", "9:50", "11:20" );
Timetable.add( 0, 2, "LF9/11", "R517", "SME21", "11:40", "13:10" );
Timetable.add( 0, 2, "LF9/11", "R517", "SME23", "13:30", "15:00" );
//Donnerstag
Timetable.add( 0, 3, "AUT", "R517", "FSE31", "9:50", "11:20" );
Timetable.add( 0, 3, "AUT", "R517", "FSE31", "11:40", "13:10" );
//Freitag
Timetable.add( 0, 4, "TEE", "R321", "BGT11", "8:00", "9:30" );
Timetable.add( 0, 4, "TEE", "R321", "BGT11", "9:50", "11:20" );
Timetable.add( 0, 4, "TME-3", "R517", "BGT13", "11:40", "13:10" );
Timetable.add( 0, 4, "LF7", "R514", "SME33", "13:30", "15:00" );

//ungerade Woche Montag 
//Dienstag
//Mittwoch
Timetable.add( 1, 2, "TME-3", "R517", "BGT13", "8:00", "9:30" );
Timetable.add( 1, 2, "LF9/11", "R517", "SME21", "9:50", "11:20" );
Timetable.add( 1, 2, "LF9/11", "R517", "SME21", "11:40", "13:10" );
Timetable.add( 1, 2, "LF9/11", "R517", "SME23", "13:30", "15:00" );
//Donnerstag
Timetable.add( 1, 3, "AUT", "R517", "FSE31", "9:50", "11:20" );
Timetable.add( 1, 3, "AUT", "R517", "FSE31", "11:40", "13:10" );
//Freitag
Timetable.add( 1, 4, "TEE", "R321", "BGT11", "8:00", "9:30" );
Timetable.add( 1, 4, "TEE", "R321", "BGT11", "9:50", "11:20" );
Timetable.add( 1, 4, "TME-3", "R517", "BGT13", "11:40", "13:10" );
Timetable.add( 1, 4, "LF7", "R514", "SME33", "13:30", "15:00" );


//Ferien
//                   von           bis           Beschreibung
Hollydays.addEntry( "07.07.2011", "17.08.2011", "Sommerferien" );
Hollydays.addEntry( "17.10.2011", "29.10.2011", "Herbstferien" );
Hollydays.addEntry( "23.12.2011", "04.01.2012", "Weihnachtsferien" );
Hollydays.addEntry( "30.01.2012", "31.01.2012", "Winterferien" );
Hollydays.addEntry( "26.03.2012", "11.04.2012", "Osterferien" );
Hollydays.addEntry( "30.04.2012", "30.04.2012", "Osterferien" );
Hollydays.addEntry( "18.05.2012", "18.05.2012", "Pfingstferien" );
Hollydays.addEntry( "29.05.2012", "29.05.2012", "Pfingstferien" );
Hollydays.addEntry( "23.07.2012", "31.08.2012", "Sommerferien" );
Hollydays.addEntry( "22.10.2012", "03.11.2012", "Herbstferien" );
Hollydays.addEntry( "24.12.2012", "05.01.2013", "Weihnachtsferien" );
Hollydays.addEntry( "31.01.2013", "01.02.2013", "Winterferien" );
Hollydays.addEntry( "16.03.2013", "02.04.2013", "Osterferien" );
Hollydays.addEntry( "10.05.2013", "10.05.2013", "Pfingstferien" );
Hollydays.addEntry( "21.05.2013", "21.05.2013", "Pfingstferien" );
Hollydays.addEntry( "27.06.2013", "07.08.2013", "Sommerferien" );
Hollydays.addEntry( "04.10.2013", "18.10.2013", "Herbstferien" );
Hollydays.addEntry( "23.12.2013", "03.01.2014", "Weihnachtsferien" );
Hollydays.addEntry( "30.01.2014", "31.01.2014", "Winterferien" );
Hollydays.addEntry( "03.04.2014", "22.04.2014", "Osterferien" );
Hollydays.addEntry( "02.05.2014", "02.05.2014", "Osterferien" );
Hollydays.addEntry( "30.05.2014", "30.05.2014", "Pfingstferien" );
Hollydays.addEntry( "10.06.2014", "10.06.2014", "Pfingstferien" );
Hollydays.addEntry( "31.07.2014", "10.09.2014", "Sommerferien" );
Hollydays.addEntry( "27.10.2014", "08.11.2014", "Herbstferien" );
Hollydays.addEntry( "22.12.2014", "05.01.2015", "Weihnachtsferien" );

Hollydays.addEntry( "02.02.2015", "03.02.2015", "Winterferien" );
Hollydays.addEntry( "25.03.2015", "10.04.2015", "Osterferien" );
Hollydays.addEntry( "15.05.2015", "Pfingstferien" );
Hollydays.addEntry( "26.05.2015", "Pfingstferien" );
Hollydays.addEntry( "23.07.2015", "02.09.2015", "Sommerferien" );
Hollydays.addEntry( "19.10.2015", "31.10.2015", "Herbstferien" );
Hollydays.addEntry( "23.12.2015", "06.01.2016", "Weihnachtsferien" );

Hollydays.addEntry( "28.01.2016", "29.01.2016", "Winterferien" );
Hollydays.addEntry( "18.03.2016", "02.04.2016", "Osterferien" );
Hollydays.addEntry( "06.05.2016", "Pfingstferien" );
Hollydays.addEntry( "17.05.2016", "Pfingstferien" );
Hollydays.addEntry( "23.06.2016", "03.08.2016", "Sommerferien" );
Hollydays.addEntry( "04.10.2016", "15.10.2016", "Herbstferien" );
Hollydays.addEntry( "21.12.2016", "06.01.2017", "Weihnachtsferien" );

Hollydays.addEntry( "30.01.2017", "31.01.2017", "Winterferien" );
Hollydays.addEntry( "10.04.2017", "22.04.2017", "Osterferien" );
Hollydays.addEntry( "26.05.2017", "Pfingstferien" );
Hollydays.addEntry( "06.06.2017", "Pfingstferien" );
Hollydays.addEntry( "22.06.2017", "02.08.2017", "Sommerferien" );


//bewegliche Feiertage
//wie Ferien von bis kann der gleich Tag sein
Hollydays.addEntry( "06.04.2012", "Karfreitag" );
Hollydays.addEntry( "09.04.2012", "Ostermontag" );
Hollydays.addEntry( "17.05.2012", "Christi Himmelfahrt" );
Hollydays.addEntry( "28.05.2012", "Pfingstmontag" );

Hollydays.addEntry( "29.03.2013", "Karfreitag" );
Hollydays.addEntry( "01.04.2013", "Ostermontag" );
Hollydays.addEntry( "09.05.2013", "Christi Himmelfahrt" );
Hollydays.addEntry( "24.05.2013", "Pfingstmontag" );

Hollydays.addEntry( "18.04.2014", "Karfreitag" );
Hollydays.addEntry( "21.04.2014", "Ostermontag" );
Hollydays.addEntry( "29.05.2014", "Christi Himmelfahrt" );
Hollydays.addEntry( "09.06.2014", "Pfingstmontag" );

Hollydays.addEntry( "03.04.2015", "Karfreitag" );
Hollydays.addEntry( "06.04.2015", "Ostermontag" );
Hollydays.addEntry( "14.05.2015", "Christi Himmelfahrt" );
Hollydays.addEntry( "25.05.2015", "Pfingstmontag" );

Hollydays.addEntry( "25.03.2016", "Karfreitag" );
Hollydays.addEntry( "28.03.2016", "Ostermontag" );
Hollydays.addEntry( "05.05.2016", "Christi Himmelfahrt" );
Hollydays.addEntry( "16.05.2016", "Pfingstmontag" );

Hollydays.addEntry( "14.04.2017", "Karfreitag" );
Hollydays.addEntry( "17.04.2017", "Ostermontag" );
Hollydays.addEntry( "25.05.2017", "Christi Himmelfahrt" );
Hollydays.addEntry( "05.06.2017", "Pfingstmontag" );



//feste Feiertage
//diese Tage werden immer am gleichen Datum von 2012 - 2050 beruecksigtigt
Hollydays.addFixEntry( "01.01.2012", "Neujahr" );
Hollydays.addFixEntry( "01.05.2012", "Tag der Arbeit" );
Hollydays.addFixEntry( "03.10.2012", "Tag dt Einheit" );
Hollydays.addFixEntry( "25.12.2012", "1. Weihnachstag" );
Hollydays.addFixEntry( "26.12.2012", "2. Weihnachstag" );

        

