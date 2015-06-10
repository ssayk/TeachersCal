importPackage(Packages.de.sayk);
calendarname = "BBS 2011/12 2.Halbjahr";
startdate    = "30.01.2012";
enddate      = "07.07.2012";

// hier deinen Stundenplan eingeben
//gerade Woche <erste Zahl = 0> Montag <zweite Zahl = 0, Mo-Sa 0-5>
//                    Fach     Raum    Klasse  von      bis  
Timetable.add( 0, 0, "TME-2", "R524", "TG12", "11:40", "13:10" );
Timetable.add( 0, 0, "AUT", "R524", "BFI01", "13:30", "15:00" );
Timetable.add( 0, 0, "EES", "R321", "AE01", "17:30", "19:00" );
Timetable.add( 0, 0, "EES", "R321", "AE01", "19:20", "20:50" );
//Dienstag
//Mittwoch
Timetable.add( 0, 2, "AUT", "R517", "FSE01", "8:00", "9:30" );
//Donnerstag
Timetable.add( 0, 3, "TME-1", "R524", "TG12", "8:00", "9:30" );
Timetable.add( 0, 3, "AUT", "R517", "FSE01", "9:50", "11:20" );
Timetable.add( 0, 3, "LF9/11", "R517", "SME92", "11:40", "13:10" );
Timetable.add( 0, 3, "LF9/11", "R517", "SME92", "13:30", "15:00" );
//Freitag

//ungerade Woche Montag 
Timetable.add( 1, 0, "AUT", "R524", "BFI01", "8:00", "9:30" );
Timetable.add( 1, 0, "TME-1", "R524", "TG12", "11:40", "13:10" );
Timetable.add( 1, 0, "AUT", "R524", "BFI01", "13:30", "15:00" );
Timetable.add( 1, 0, "EES", "R321", "AE01", "17:30", "19:00" );
Timetable.add( 1, 0, "EES", "R321", "AE01", "19:20", "20:50" );
//Dienstag
//Mittwoch
Timetable.add( 1, 2, "AUT", "R517", "FSE01", "8:00", "9:30" );
//Donnerstag
Timetable.add( 1, 3, "TME-1", "R524", "TG12", "8:00", "9:30" );
Timetable.add( 1, 3, "AUT", "R517", "FSE01", "9:50", "11:20" );
Timetable.add( 1, 3, "LF9/11", "R517", "SME92", "13:30", "15:00" );
//Freitag

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

//bewegliche Feiertage
//wie Ferien von bis kann der gleich Tag sein
Hollydays.addEntry( "06.04.2012", "06.04.2012", "Karfreitag" );
Hollydays.addEntry( "09.04.2012", "09.04.2012", "Ostermontag" );
Hollydays.addEntry( "17.05.2012", "17.05.2012", "Christi Himmelfahrt" );
Hollydays.addEntry( "28.05.2012", "28.05.2012", "Pfingstmontag" );

Hollydays.addEntry( "29.03.2013", "29.03.2013", "Karfreitag" );
Hollydays.addEntry( "01.04.2013", "01.04.2013", "Ostermontag" );
Hollydays.addEntry( "09.05.2013", "09.05.2013", "Christi Himmelfahrt" );
Hollydays.addEntry( "24.05.2013", "24.05.2013", "Pfingstmontag" );

Hollydays.addEntry( "18.04.2014", "18.04.2014", "Karfreitag" );
Hollydays.addEntry( "21.04.2014", "21.04.2014", "Ostermontag" );
Hollydays.addEntry( "29.05.2014", "29.05.2014", "Christi Himmelfahrt" );
Hollydays.addEntry( "09.06.2014", "09.06.2014", "Pfingstmontag" );

//feste Feiertage
//diese Tage werden immer am gleichen Datum von 2012 - 2050 beruecksigtigt
Hollydays.addFixEntry( "01.01.2012", "Neujahr" );
Hollydays.addFixEntry( "01.05.2012", "Tag der Arbeit" );
Hollydays.addFixEntry( "03.10.2012", "Tag dt Einheit" );
Hollydays.addFixEntry( "25.12.2012", "1. Weihnachstag" );
Hollydays.addFixEntry( "26.12.2012", "2. Weihnachstag" );

        