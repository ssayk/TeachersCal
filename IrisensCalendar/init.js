importPackage(Packages.de.sayk);
calendarname = "BBS OS 2013/14 2.Halbjahr";
startdate    = "03.02.2014";
enddate      = "30.07.2014";

// hier deinen Stundenplan eingeben
//gerade Woche <erste Zahl = 0> Montag <zweite Zahl = 0, Mo-Sa 0-5>
//                    Fach     Raum    Klasse  von      bis  
Timetable.add( 0, 0, "EES", "R321", "AE21", "17:30", "19:00" );
Timetable.add( 0, 0, "EES", "R321", "AE21", "19:20", "20:50" );
Timetable.add( 0, 0, "TME-2", "R514", "BGT12", "11:40", "13:10" );
Timetable.add( 0, 0, "TME-2", "R514", "BGT12", "13:30", "15:00" );
//Dienstag
//Mittwoch
Timetable.add( 0, 2, "LF7", "R511", "SME23", "11:40", "13:10" );
Timetable.add( 0, 2, "LF7", "R524", "SME23", "13:30", "15:00" );
//Donnerstag
Timetable.add( 0, 3, "LF3", "R323", "SME32", "8:00", "9:30" );
Timetable.add( 0, 3, "LF9/11", "R517", "SME12", "9:50", "11:20" );
Timetable.add( 0, 3, "AUT", "R517", "FSE21", "11:40", "13:10" );
Timetable.add( 0, 3, "AUT", "R517", "FSE21", "13:30", "15:00" );
//Freitag
Timetable.add( 0, 4, "LF3", "R323", "SME32", "8:00", "9:30" );
Timetable.add( 0, 4, "LF3", "R323", "SME32", "9:50", "11:20" );
Timetable.add( 0, 4, "TME-4", "R514", "BGT13", "11:40", "13:10" );
Timetable.add( 0, 4, "TME-4", "R514", "BGT13", "13:30", "15:00" );

//ungerade Woche Montag 
Timetable.add( 1, 0, "EES", "R321", "AE21", "17:30", "19:00" );
Timetable.add( 1, 0, "EES", "R321", "AE21", "19:20", "20:50" );
Timetable.add( 1, 0, "TME-2", "R514", "BGT12", "11:40", "13:10" );
Timetable.add( 1, 0, "TME-2", "R514", "BGT12", "13:30", "15:00" );
//Dienstag
//Mittwoch
Timetable.add( 1, 2, "LF7", "R524", "SME23", "09:50", "11:20" );
//Donnerstag
Timetable.add( 1, 3, "LF9/11", "R517", "SME12", "8:00", "9:30" );
Timetable.add( 1, 3, "LF9/11", "R517", "SME12", "9:50", "11:20" );
//Freitag
Timetable.add( 1, 4, "AUT", "R517", "FSE21", "8:00", "9:30" );
Timetable.add( 1, 4, "AUT", "R517", "FSE21", "9:50", "11:20" );
Timetable.add( 1, 4, "TME-4", "R514", "BGT13", "11:40", "13:10" );
Timetable.add( 1, 4, "TME-4", "R514", "BGT13", "13:30", "15:00" );


//Ferien
//                   von           bis           Beschreibung
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
Hollydays.addEntry( "15.05.2015", "15.05.2015", "Pfingstferien" );
Hollydays.addEntry( "26.05.2015", "26.05.2015", "Pfingstferien" );
Hollydays.addEntry( "23.07.2015", "02.09.2015", "Sommerferien" );
Hollydays.addEntry( "19.10.2015", "31.10.2015", "Herbstferien" );
Hollydays.addEntry( "23.12.2015", "06.01.2016", "Weihnachtsferien" );

Hollydays.addEntry( "28.01.2016", "29.01.2016", "Winterferien" );
Hollydays.addEntry( "18.03.2016", "02.04.2016", "Osterferien" );
Hollydays.addEntry( "06.05.2016", "06.05.2016", "Pfingstferien" );
Hollydays.addEntry( "17.05.2016", "17.05.2016", "Pfingstferien" );
Hollydays.addEntry( "23.06.2016", "03.08.2016", "Sommerferien" );
Hollydays.addEntry( "04.10.2016", "15.10.2016", "Herbstferien" );
Hollydays.addEntry( "21.12.2016", "06.01.2017", "Weihnachtsferien" );


//bewegliche Feiertage
//wie Ferien von bis kann der gleich Tag sein
Hollydays.addEntry( "18.04.2014", "18.04.2014", "Karfreitag" );
Hollydays.addEntry( "21.04.2014", "21.04.2014", "Ostermontag" );
Hollydays.addEntry( "29.05.2014", "29.05.2014", "Christi Himmelfahrt" );
Hollydays.addEntry( "09.06.2014", "09.06.2014", "Pfingstmontag" );

Hollydays.addEntry( "03.04.2015", "03.04.2015", "Karfreitag" );
Hollydays.addEntry( "06.04.2015", "06.04.2015", "Ostermontag" );
Hollydays.addEntry( "14.05.2015", "14.05.2015", "Christi Himmelfahrt" );
Hollydays.addEntry( "25.05.2015", "25.05.2015", "Pfingstmontag" );

Hollydays.addEntry( "25.03.2016", "25.03.2016", "Karfreitag" );
Hollydays.addEntry( "28.03.2016", "28.03.2016", "Ostermontag" );
Hollydays.addEntry( "05.05.2016", "05.05.2016", "Christi Himmelfahrt" );
Hollydays.addEntry( "16.05.2016", "16.05.2016", "Pfingstmontag" );

//feste Feiertage
//diese Tage werden immer am gleichen Datum von 2012 - 2050 beruecksigtigt
Hollydays.addFixEntry( "01.01.2012", "Neujahr" );
Hollydays.addFixEntry( "01.05.2012", "Tag der Arbeit" );
Hollydays.addFixEntry( "03.10.2012", "Tag dt Einheit" );
Hollydays.addFixEntry( "25.12.2012", "1. Weihnachstag" );
Hollydays.addFixEntry( "26.12.2012", "2. Weihnachstag" );

        