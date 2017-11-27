package Movie;

import java.sql.Time;

/**
 * File: ShowTime.java This is a wrapper class.
 *
 * @author Hiromi Cota
 */
public class ShowTime {

    int ShowTimeID;
    Time ShowTimeTime;
    int FilmID;
    int TicketsRemaining;

    ShowTime(int ID, int hour, int minutes, int film) {
        ShowTimeID = ID;
        ShowTimeTime = new Time(hour, minutes, 0);
        FilmID = film;
        TicketsRemaining = 100;
    }

}
